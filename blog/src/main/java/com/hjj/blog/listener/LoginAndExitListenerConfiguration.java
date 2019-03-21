package com.hjj.blog.listener;

import com.hjj.blog.listener.service.UserInformationService;
import com.hjj.blog.listener.service.ViewRecordService;
import com.hjj.blog.projo.UserInformation2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

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

    @Bean
    public ViewRecordService viewRecordService() {
        return new ViewRecordService();
    }

    @Bean
    public Set<Integer> set() {
        return new HashSet<Integer>();
    }
}
