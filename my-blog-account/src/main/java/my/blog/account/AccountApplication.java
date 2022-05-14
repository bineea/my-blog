package my.blog.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;

//@SpringBootApplication 告诉Spring Boot框架，这是项目的引导类。实现服务的核心初始化逻辑
@SpringBootApplication

//允许访问/refresh端点，强制Spring Boot应用重新读取程序配置
@RefreshScope

//启用Hystrix
@EnableCircuitBreaker
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

}
