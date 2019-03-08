package com.hjj.blog.edit.controller;

import org.pegdown.PegDownProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * @author haojunjie
 * @create 2019-03-07 19:27
 */
@Controller
public class EditController {
    @RequestMapping("/write")
    public String write() {
        //获取文章类型的值放入request域中
        return "write";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("title") String title,@RequestParam("content") String content,
                        HttpServletRequest request) {


        return "display";
    }

}
