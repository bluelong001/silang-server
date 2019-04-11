package me.study.silang.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import me.study.silang.entity.User;

import javax.servlet.http.HttpServletRequest;

public class TokenUtils {

    public static Integer getUserInfo(String token){
        return Integer.valueOf(JWT.decode(token).getAudience().get(0));
    }

    public static Integer getUserInfo(HttpServletRequest request){
        return getUserInfo(request.getHeader("Authorization"));
    }

    public static String makeToken(User user){
        return JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
    }
}
