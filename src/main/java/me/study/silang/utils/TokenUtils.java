package me.study.silang.utils;

import me.study.silang.entity.User;

import javax.servlet.http.HttpServletRequest;

public class TokenUtils {

    public static Integer getUserInfo(String token){
        return 1;
    }

    public static Integer getUserInfo(HttpServletRequest request){
        return getUserInfo(request.getHeader("Authorization"));
    }
}
