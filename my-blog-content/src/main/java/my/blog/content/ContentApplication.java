package my.blog.content;

import com.netflix.loadbalancer.RoundRobinRule;
import my.blog.ribbon.config.RandomRuleRibbonConfig;
import my.blog.ribbon.config.RryRuleRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication 告诉Spring Boot框架，这是项目的引导类。实现服务的核心初始化逻辑
@SpringBootApplication

//允许访问/refresh端点，强制Spring Boot应用重新读取程序配置
@RefreshScope

//启用Feign客户端
@EnableFeignClients(basePackages = {"my.blog.account.api"})

//启用Hystrix
@EnableCircuitBreaker

//不同的微服务配置不同负载均衡策略
@RibbonClients({
        @RibbonClient(name = "zuulservice", configuration = RoundRobinRule.class),
        @RibbonClient(name = "accountservice", configuration = RandomRuleRibbonConfig.class),
        @RibbonClient(name = "confservice", configuration = RryRuleRibbonConfig.class)
})
public class ContentApplication {

    // @LoadBalanced注解告诉Spring Cloud创建一个支持Ribbon的RestTemplate类
    // 在使用支持Ribbon的RestTemplate时，并不需要@EnableDiscoveryClient和@EnableFeignClients，因此可以移除
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        /*调用启动Spring Boot服务*/
        SpringApplication.run(ContentApplication.class, args);    }

}
