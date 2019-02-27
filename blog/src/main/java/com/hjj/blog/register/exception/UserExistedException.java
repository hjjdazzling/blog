package com.hjj.blog.register.exception;

/**
 * Created by haojunjie on 2019/2/25
 */
public class UserExistedException extends RuntimeException {
    public UserExistedException() {
        super("用户名已存在");
    }
}
