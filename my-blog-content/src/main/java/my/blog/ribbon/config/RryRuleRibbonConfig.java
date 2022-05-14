package my.blog.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RryRuleRibbonConfig {

    @Bean
    public IRule getIRule() {
        return new RetryRule();
    }
}
