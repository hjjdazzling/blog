package com.hjj.blog.modify.personal.controller;

import com.hjj.blog.modify.personal.service.PersonalInformationService;
import com.hjj.blog.projo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-11 13:21
 */
@Controller
@RequestMapping("/PersonalInformationChangeController")
public class PersonalInformationChangeController {
    @Autowired
    public PersonalInformationService personalInformationService;
    @RequestMapping("updateProfessionType1")
    public String selectProfessionType1(HttpServletRequest request) {
        List<ProfessionalType1> list = personalInformationService.selectProfessionType1();
        request.setAttribute("professionType1", list);
        return "updateType1";
    }
    @RequestMapping("updateProfessionType2")
    public String selectProfessionType2(@RequestParam("professionType1Id") Integer id, HttpServletRequest request) {
        List<ProfessionalType2> list = personalInformationService.selectProfessionType2(id);
        request.setAttribute("professionType2", list);
        return "updateType2";
    }
    @RequestMapping("updateProfessionType3")
    public String selectProfessionType3(@RequestParam("professionType2Id") Integer id, HttpServletRequest request) {
        List<ProfessionalType3> list = personalInformationService.selectProfessionType3(id);
        request.setAttribute("professionType3", list);
        return "updateType3";
    }

    @RequestMapping("/selectPersonalInformation")
    public String selectPersonalInformation(@RequestParam("professionType3Id") Integer professionType3Id,
                                            HttpSession session,HttpServletRequest request) {
        User user = (User)session.getAttribute("user");
        request.setAttribute("id", professionType3Id);
        request.setAttribute("userInformation", personalInformationService.selectUserInformation(user.getId()));

        return "updatePersonalInformation";
    }

    @RequestMapping("/updateInformation")
    public String updateInformation(@RequestParam("password") String password,
                                    @Valid UserInformation userInformation,
                                    BindingResult bindingResult2,
                                    @RequestParam("password2") String password2,
                                    HttpServletRequest request,HttpSession session) {
        if ( bindingResult2.getErrorCount() > 0) {
            List<FieldError> fieldErrors2 = bindingResult2.getFieldErrors();

            for (FieldError fieldError : fieldErrors2) {
                //属性
                String field = fieldError.getField();
                //错误信息
                String message = fieldError.getDefaultMessage();

                request.setAttribute(field, message);

                if (field.equals("birth")) {
                    request.setAttribute(field, "日期格式不正确");
                }
            }

            return "updatePersonalInformation";
        }


        if (password == null || password.trim() == " "
            || password2 == null || password2.trim() == " ") {
            request.setAttribute("password2", "密码不能为空");

            return "updatePersonalInformation";
        }
        if (!password.equals(password2)) {
            request.setAttribute("password2", "两次输入密码不一致");

            return "updatePersonalInformation";
        }
        User user = (User) session.getAttribute("user");
        user.setPassword(password);
        userInformation.setUserId(user.getId());
        personalInformationService.update(user, userInformation);

        return "select";

    }


}
