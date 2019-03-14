package com.hjj.blog.configutation;

import org.pegdown.PegDownProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author haojunjie
 * @create 2019-03-13 15:01
 */
@Configuration
public class PegDownConfiguration {
    @Bean
    public PegDownProcessor peg() {
        return new PegDownProcessor(Integer.MAX_VALUE);
    }
}
