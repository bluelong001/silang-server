package me.study.silang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.study.silang.bean.Rest;
import me.study.silang.entity.User;
import me.study.silang.service.IUserService;
import me.study.silang.utils.TokenUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class MainController {
    @Resource
    private IUserService userService;

    @PostMapping("/login")
    public Rest clientLogin(String username,String password){
        User user =userService.getOne(new QueryWrapper<User>().lambda().eq(User::getPassword,password).eq(User::getUsername,username));
        if(user==null)return Rest.fail("认证失败");
        return Rest.ok().data(TokenUtils.makeToken(user));
    }

    @PostMapping("/back/login")
    public Rest webAdminLogin(String username,String password){
        User user =userService.getOne(new QueryWrapper<User>().lambda().eq(User::getPassword,password).eq(User::getUsername,username));
        if(user==null)return Rest.fail("认证失败");
        if(user.getRole()!=2)return Rest.fail("你不是管理员，禁止登录");
        return Rest.ok().data(TokenUtils.makeToken(user));
    }

    @PostMapping("/logout")
    public Rest login(){
        return Rest.ok();
    }
}