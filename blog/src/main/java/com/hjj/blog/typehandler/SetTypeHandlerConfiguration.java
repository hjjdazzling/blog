package com.hjj.blog.typehandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-14 14:27
 */
@Configuration
public class SetTypeHandlerConfiguration {
    @Bean(name="set")
    public Set<Integer> set() {
        return new HashSet<Integer>();
    }
}
