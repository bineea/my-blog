package my.blog.content.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"my.blog.account.api"})
public class ApiConfig {

}
