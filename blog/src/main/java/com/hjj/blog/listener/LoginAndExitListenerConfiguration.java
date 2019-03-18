package com.hjj.blog.listener;

import com.hjj.blog.listener.service.UserInformationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author haojunjie
 * @create 2019-03-18 15:04
 */
@Configuration
public class LoginAndExitListenerConfiguration {
    @Bean
    public UserInformationService userInformationService() {
        return new UserInformationService();
    }
}
