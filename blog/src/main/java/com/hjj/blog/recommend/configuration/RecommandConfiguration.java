package com.hjj.blog.recommend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-25 11:17
 */
@Configuration
public class RecommandConfiguration {
    @Bean(value = "viewRecords")
    public Set<Integer> viewRecords() {
        return new HashSet<>();
    }
}
