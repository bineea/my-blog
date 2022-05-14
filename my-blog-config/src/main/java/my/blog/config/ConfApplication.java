package my.blog.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//因为Spring Cloud Config 服务是Spring Boot应用程序，因此需要用@SpringBootApplication进行标记
//@SpringBootApplication 告诉Spring Boot框架，这是项目的引导类。实现服务的核心初始化逻辑
@SpringBootApplication
//@EnableConfigServer使服务成为Spring Cloud Config服务
@EnableConfigServer
public class ConfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfApplication.class, args);
    }

}
