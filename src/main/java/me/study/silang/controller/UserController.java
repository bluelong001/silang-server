package me.study.silang.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import me.study.silang.bean.ParamUtils;
import me.study.silang.bean.Rest;
import me.study.silang.entity.*;
import me.study.silang.model.UserData;
import me.study.silang.model.UserInfo;
import me.study.silang.service.*;
import me.study.silang.utils.TokenUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private IUserService userService;
    @Resource
    private FileController fileController;
    @Resource
    private IPostService postService;
    @Resource
    private IReplyService replyService;
    @Resource
    private IVideoService videoService;

    @Resource
    private IFileService fileService;

    @GetMapping
    public Rest list(@RequestParam Map map, HttpServletRequest request) {
        ParamUtils param = new ParamUtils(map);
        IPage page = userService.page(param.toPage(), param.toQueryWrapper());
        List<UserInfo> list = new ArrayList<>();
        List<User> users = page.getRecords();
        users.forEach(user -> {
            try {
                list.add(UserInfo.builder()
                        .id(user.getId())
                        .role(user.getRole())
                        .headIcon((String) fileController.get(user.getFileId(), request).getData())
                        .displayname(user.getDisplayname())
                        .username(user.getUsername())
                        .signature(user.getSignature())
                        .build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return Rest.ok().data(list).total(page.getTotal());
    }

    @PostMapping
    public Rest add(@RequestParam Map map) {
        ParamUtils param = new ParamUtils(map);
        User user = param.toObj(User.class);

        try {

            if (null == user.getRole() || user.getRole() == 0)
                user.setRole(1);
            if (null == user.getFileId() || user.getFileId() == 0){
                org.springframework.core.io.Resource resource = new ClassPathResource("default" + java.io.File.separator + "default.jpg");
                File file = fileService.saveFile(resource.getInputStream(), "jpg");
                user.setFileId(file.getId());
            }
            userService.save(user);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return Rest.ok();
    }

    @PutMapping
    public Rest update(@RequestParam Map map) {
        ParamUtils param = new ParamUtils(map);
        User user = param.toObj(User.class);
        userService.saveOrUpdate(user);
        return Rest.ok();
    }

    @PutMapping("set-pass")
    public Rest setPass(Integer userId, String oldPass, String newPass) {
        User user = userService.getById(userId);
        if (oldPass.equals(user.getPassword()))
            user.setPassword(newPass);
        else return Rest.fail("旧密码错误");
        userService.saveOrUpdate(user);
        return Rest.ok();
    }

    @PutMapping("swap-head")
    public Rest swapHead(@RequestParam Map map, HttpServletRequest request) {
//        ParamUtils param = new ParamUtils(map);
        User user = userService.getById(TokenUtils.getUserInfo(request));
        user.setFileId(Integer.valueOf((String) map.get("fileId")));
        userService.saveOrUpdate(user);
        return Rest.ok();
    }

    @PutMapping("swap-signature")
    public Rest swapSignature(@RequestParam Map map, HttpServletRequest request) {
//        ParamUtils param = new ParamUtils(map);
        User user = userService.getById(TokenUtils.getUserInfo(request));
        user.setSignature((String) map.get("signature"));
        userService.saveOrUpdate(user);
        return Rest.ok();
    }

    @GetMapping("get/token")
    public Rest token(String token, HttpServletRequest request) {
        return Rest.ok().data(userService.getUserInfo(token, request));
    }

    @GetMapping("/by-id")
    public Rest getById(Integer id, HttpServletRequest request) {
        if (id == null) id = TokenUtils.getUserInfo(request);
        return Rest.ok().data(userService.getUserInfo(id, request));
    }

    @GetMapping("get-data")
    public Rest getData(Integer id, HttpServletRequest request) {
        if (id == null) id = TokenUtils.getUserInfo(request);
        UserData userData = UserData.builder()
                .postNum(String.valueOf(postService.count(new QueryWrapper<Post>().lambda().eq(Post::getUserId, id))))
                .videoNum(String.valueOf(videoService.count(new QueryWrapper<Video>().lambda().eq(Video::getUserId, id))))
                .replyNum(String.valueOf(replyService.count(new QueryWrapper<Reply>().lambda().eq(Reply::getUserId, id))))
                .readNum("0")
                .build();
        return Rest.ok().data(userData);
    }

    @GetMapping("/by-token")
    public Rest getById(String token, HttpServletRequest request) {
        return Rest.ok().data(userService.getUserInfo(token, request));
    }


    @DeleteMapping
    public Rest del(Integer id) {
        userService.removeById(id);
        return Rest.ok();
    }
}
