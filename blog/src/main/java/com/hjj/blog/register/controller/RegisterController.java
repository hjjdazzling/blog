package com.hjj.blog.register.controller;

import com.hjj.blog.projo.*;
import com.hjj.blog.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by haojunjie on 2019/2/25
 */
@RequestMapping("/RegisterController")
@Controller
public class RegisterController {
    @Autowired
    public RegisterService registerService;

    @RequestMapping("/register.html")
    public String getRegister(@RequestParam("professionType3Id") Integer id, HttpServletRequest request) {
        request.setAttribute("id", id);
        return "register";
    }

    @RequestMapping("selectProfessionType1")
    public String selectProfessionType1(HttpServletRequest request) {
        List<ProfessionalType1> list = registerService.selectProfessionType1();
        request.setAttribute("professionType1", list);
        return "selectType1";
    }
    @RequestMapping("selectProfessionType2")
    public String selectProfessionType2(@RequestParam("professionType1Id") Integer id, HttpServletRequest request) {
        List<ProfessionalType2> list = registerService.selectProfessionType2(id);
        request.setAttribute("professionType2", list);
        return "selectType2";
    }
    @RequestMapping("selectProfessionType3")
    public String selectProfessionType3(@RequestParam("professionType2Id") Integer id, HttpServletRequest request) {
        List<ProfessionalType3> list = registerService.selectProfessionType3(id);
        request.setAttribute("professionType3", list);
        return "selectType3";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult bindingResult,
                                 @Valid UserInformation userInformation, BindingResult bindingResult2,
                                 @RequestParam("password2") String password2, HttpServletRequest request) {

        if (bindingResult.getErrorCount() > 0 || bindingResult2.getErrorCount() > 0) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<FieldError> fieldErrors2 = bindingResult2.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                //属性
                String field = fieldError.getField();
                //错误信息
                String message = fieldError.getDefaultMessage();

                request.setAttribute(field, message);
            }

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

            return "register.html";
        }


        if (!user.getPassword().equals(password2)) {
            request.setAttribute("password2", "两次输入密码不一致");

            return "register.html";
        }

        registerService.registerUser(user);
        userInformation.setUserId(user.getId());
        registerService.registerUserInformation(userInformation);


        return "index";
    }

}
