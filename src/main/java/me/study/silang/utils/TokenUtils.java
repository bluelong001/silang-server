package me.study.silang.utils;

import me.study.silang.entity.User;

import javax.servlet.http.HttpServletRequest;

public class TokenUtils {

    public static User getUserInfo(String token){
        return User.builder().id(1).username("test").displayname("hello").headIcon("default.jpg").build();
    }

    public static User getUserInfo(HttpServletRequest request){
        return getUserInfo(request.getHeader("Authorization"));
    }
}
