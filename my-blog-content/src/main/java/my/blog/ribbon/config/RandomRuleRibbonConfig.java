package my.blog.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomRuleRibbonConfig {

    @Bean
    public IRule getIRule() {
        return new RandomRule();
    }
}
