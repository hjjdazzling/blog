package com.hjj.blog.message.controller;

import com.hjj.blog.message.service.MessageService;
import com.hjj.blog.projo.CriteriaMessage;
import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-28 20:24
 */
@Controller
@RequestMapping("/MessageController")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/getMessageList")
    public String getMessageList(HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        List<CriteriaMessage> list = messageService.getCriteriaMessagesByUserId(user.getId());
        session.setAttribute("criteriaMessages", list);
        return "message";
    }


    @RequestMapping("/updateMessageState")
    public String updateMessageState(@RequestParam("id") int id, HttpSession session) {
        messageService.updateCriteriaMessagesById(id);
        List<CriteriaMessage> list = (List<CriteriaMessage>)session.getAttribute("criteriaMessages");

        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.get(i).setRead(true);
            }
        }

        session.setAttribute("criteriaMessages", list);
        return "message";
    }

}
