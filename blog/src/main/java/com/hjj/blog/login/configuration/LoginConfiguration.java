package com.hjj.blog.login.configuration;

import com.hjj.blog.projo.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-25 14:03
 */
@Configuration
public class LoginConfiguration {
    @Bean
    public Set<Article> articles() {
        return new HashSet<>();
    }
}
