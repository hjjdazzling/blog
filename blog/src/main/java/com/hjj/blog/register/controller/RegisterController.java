package com.hjj.blog.register.controller;

import com.hjj.blog.projo.User;
import com.hjj.blog.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haojunjie on 2019/2/25
 */
@RestController
public class RegisterController {
    @Autowired
    public RegisterService registerService;


}
