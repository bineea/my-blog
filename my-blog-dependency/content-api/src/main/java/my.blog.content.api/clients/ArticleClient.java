package my.blog.content.api.clients;

import my.blog.content.api.model.ArticleModel;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient 标识服务
@EnableFeignClients("contentservice")
public interface ArticleClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/article/findByUserId/{userId}",
            consumes = "application/json"
    )
    List<ArticleModel> findByUserId(@PathVariable("userId") String userId);
}
