package com.hjj.blog.register.controller;

import com.hjj.blog.projo.User;
import com.hjj.blog.projo.UserInformation;
import com.hjj.blog.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by haojunjie on 2019/2/25
 */
@RequestMapping("/RegisterController")
@Controller
public class RegisterController {
    @Autowired
    public RegisterService registerService;

    @RequestMapping("/register.html")
    public String getRegister() {
        return "register";
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
        userInformation.setUser_id(user.getId());
        registerService.registerUserInformation(userInformation);


        return "index";
    }
}
