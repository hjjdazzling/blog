package com.hjj.blog.register.exceptionhandler;

import com.hjj.blog.register.exception.UserExistedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by haojunjie on 2019/2/25
 */
@ControllerAdvice
public class RegisterExceptionHandler {
    @ExceptionHandler(UserExistedException.class)
    public ModelAndView handlerUserExistedException() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("existedUser", "对不起,此用户名已被注册");
        return modelAndView;
    }
}
