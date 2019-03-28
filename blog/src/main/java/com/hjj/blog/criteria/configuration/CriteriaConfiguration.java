package com.hjj.blog.criteria.configuration;

import com.hjj.blog.projo.CriteriaMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author haojunjie
 * @create 2019-03-27 14:42
 */
@Configuration
public class CriteriaConfiguration {
    @Bean
    public CriteriaMessage criteriaMessage() {
        return new CriteriaMessage();
    }
}
