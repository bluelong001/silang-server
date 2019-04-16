package me.study.silang.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import me.study.silang.bean.ParamUtils;
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
import org.apache.ibatis.annotations.Update;
import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    private IPostService postService;
    @Resource
    private IReplyService replyService;
    @Resource
    private IVideoService videoService;

    @GetMapping
    public Rest list(@RequestParam Map map) {
        ParamUtils param = new ParamUtils(map);
        IPage page = userService.page(param.toPage(), param.toQueryWrapper());
        return Rest.ok().data(page.getRecords()).total(page.getTotal());
    }

    @PostMapping
    public Rest add(@RequestParam Map map) {
        ParamUtils param = new ParamUtils(map);
        User user = param.toObj(User.class);
        user.setRole(1);
        user.setFileId(1);
        userService.save(user);
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

    @GetMapping("get/token")
    public Rest token(String token,HttpServletRequest request){
        return Rest.ok().data(userService.getUserInfo(token,request));
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
                .postNum(String.valueOf(postService.count(new QueryWrapper<Post>().lambda().eq(Post::getUserId,id))))
                .videoNum(String.valueOf(videoService.count(new QueryWrapper<Video>().lambda().eq(Video::getUserId,id))))
                .replyNum(String.valueOf(replyService.count(new QueryWrapper<Reply>().lambda().eq(Reply::getUserId,id))))
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
