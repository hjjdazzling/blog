package com.hjj.blog.edit;

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
        return "write";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("title") String title,@RequestParam("content") String content,
                        HttpServletRequest request) {
        request.setAttribute("title", title);
        PegDownProcessor  peg=new PegDownProcessor();
        String html =peg.markdownToHtml(content);
        request.setAttribute("content", html);
        return "display";
    }

}
