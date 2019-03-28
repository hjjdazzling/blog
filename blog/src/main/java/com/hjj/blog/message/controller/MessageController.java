package com.hjj.blog.message.controller;

import com.hjj.blog.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haojunjie
 * @create 2019-03-28 20:24
 */
@Controller
@RequestMapping("/MessageController")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/getMessage")
    public String getMessage() {
        return "";
    }
}
