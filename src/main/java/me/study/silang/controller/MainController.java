package me.study.silang.controller;

import me.study.silang.bean.Rest;
import me.study.silang.service.IUserService;
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
    public Rest login(String username,String Password){
        return Rest.ok().data("token");
    }
}
