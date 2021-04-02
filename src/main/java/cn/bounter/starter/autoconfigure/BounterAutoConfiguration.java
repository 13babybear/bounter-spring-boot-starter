package cn.bounter.starter.autoconfigure;

import cn.bounter.starter.service.BounterService;
import cn.bounter.starter.service.BounterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BounterProperties.class)
@ConditionalOnProperty(name = "bounter.name")
public class BounterAutoConfiguration {

    @Autowired
    private BounterProperties bounterProperties;


    @Bean
    @ConditionalOnMissingBean
    public BounterService bounterService() {
        return new BounterService(bounterProperties.getName());
    }

    @Bean
    @ConditionalOnBean(BounterService.class)
    public BounterUtil bounterUtil() {
        return new BounterUtil();
    }
}
