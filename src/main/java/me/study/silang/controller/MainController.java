package me.study.silang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.study.silang.bean.Rest;
import me.study.silang.entity.Post;
import me.study.silang.entity.Reply;
import me.study.silang.entity.User;
import me.study.silang.entity.Video;
import me.study.silang.model.UserData;
import me.study.silang.service.IPostService;
import me.study.silang.service.IReplyService;
import me.study.silang.service.IUserService;
import me.study.silang.service.IVideoService;
import me.study.silang.utils.TokenUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class MainController {
    @Resource
    private IUserService userService;
    @Resource
    private IPostService postService;
    @Resource
    private IReplyService replyService;
    @Resource
    private IVideoService videoService;
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

    @GetMapping("/get-data")
    public Rest getData() {
        UserData userData = UserData.builder()
                .postNum(String.valueOf(postService.count()))
                .videoNum(String.valueOf(videoService.count()))
                .replyNum(String.valueOf(replyService.count()))
                .userNum(String.valueOf(userService.count()))
                .build();
        return Rest.ok().data(userData);
    }

    @PostMapping("/logout")
    public Rest login(){
        return Rest.ok();
    }
}