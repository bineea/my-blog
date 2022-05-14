package my.blog.content.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import my.blog.account.api.clients.AccountClient;
import my.blog.account.api.model.UserModel;
import my.blog.comm.base.pub.MyManagerException;
import my.blog.comm.base.tools.JsonTools;
import my.blog.content.model.CreateArticleModel;
import my.blog.content.resources.entity.Article;
import my.blog.content.resources.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl extends AbstractService implements ArticleService {

    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private AccountClient accountClient;

    @HystrixCommand(
            //断路器模式配置
            commandProperties = {
                    //断路器一次滚动窗口的统计时间内的最小请求数量
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"),
                    //错误比率阀值，如果错误率大于等于该值，且满足一次滚动窗口时间内的最小请求数量，将触发断路，即断路所有请求，并触发fallback。默认为50
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "75"),
                    //断路器触发断路后，维持断路状态的时间，然后会再次尝试是否应再次关闭
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    //断路器超时时间
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    //断路器统计信息的滚动窗口
                    @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value = "15000"),
                    //断路器并不是最后统计信息，而是按照bucket来统计，bucket数量为3，则是15000/3=5000ms，每5000ms统计一次数据
                    @HystrixProperty(name="metrics.rollingStats.numBuckets", value = "3")
            },
            //后备模式配置
            fallbackMethod = "findByUserIdFallback",
            //舱壁模式配置
            //配置线程池的唯一名称
            threadPoolKey = "contentDBThreadPool",
            threadPoolProperties = {
                    //配置线程池中线程的最大数量
                    @HystrixProperty(name="coreSize", value="30"),
                    //配置位于线程池前的队列，对传入请求进行排队。一但请求数量超过队列大小，对线程池的任何其他请求都将失败，直到队列中有空间
                    @HystrixProperty(name="maxQueueSize", value="10")
            }
    )
    @Override
    public List<Article> findByUserId(String userId) throws MyManagerException {
        try {
            UserModel userModel = accountClient.findUserById(userId);
            if(userModel == null || userModel.getStatus() != UserModel.UserStatus.NORMAL) {
                throw new MyManagerException("用户信息异常");
            }
            System.out.println("userModel:"+ JsonTools.writeValueAsString(userModel));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleRepo.findByUserId(userId);
    }

    private List<Article> findByUserIdFallback(String userId) {
        return new ArrayList<Article>();
    }

    @Override
    public String createArticle(CreateArticleModel articleModel) throws MyManagerException {

        try {
            UserModel userModel = accountClient.findUserById(articleModel.getUserId());
            if(userModel == null || userModel.getStatus() != UserModel.UserStatus.NORMAL) {
                throw new MyManagerException("用户信息异常");
            }
            System.out.println("userModel:"+ JsonTools.writeValueAsString(userModel));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
