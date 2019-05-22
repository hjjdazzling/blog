package com.hjj.blog.exit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author haojunjie
 * @create 2019-04-21 20:21
 */
@Controller
@RequestMapping("/ExitController")
public class ExitController {

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "index";
    }
}
