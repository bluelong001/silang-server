package me.study.silang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import me.study.silang.bean.ParamUtils;
import me.study.silang.bean.Rest;
import me.study.silang.entity.Post;
import me.study.silang.entity.Reply;
import me.study.silang.model.PostModel;
import me.study.silang.service.IPostService;
import me.study.silang.service.IReplyService;
import me.study.silang.service.IUserService;
import me.study.silang.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
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
@RequestMapping("/api/post")
public class PostController {

    @Resource
    private IPostService postService;
    @Resource
    private IReplyService replyService;
    @Resource
    private IUserService userService;

    @GetMapping
    public Rest list(@RequestParam Map map) {
        ParamUtils param = new ParamUtils(map);
        IPage page = postService.page(param.toPage(), param.toQueryWrapper());
        List<PostModel> modelList = new ArrayList<>();
        List<Post> postList = page.getRecords();

        postList.forEach(post -> modelList.add(PostModel.builder()
                .content(post.getContent())
                .gmtCreate(post.getGmtCreate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .gmtUpdate(post.getGmtUpdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .replyNum(replyService.list(new QueryWrapper<Reply>().lambda().eq(Reply::getPostId, post.getId())).size())
                .userName(userService.getById(post.getUserId()).getUsername())
                .title(post.getTitle())
                .build()));
        return Rest.ok().data(postList).total(page.getTotal());
    }

    @PostMapping
    public Rest add(@RequestParam Map map) {
        ParamUtils param = new ParamUtils(map);
        postService.save((Post) param.toObj(Post.class));
        return Rest.ok();
    }

    @PutMapping
    public Rest update(@RequestParam Map map) {
        ParamUtils param = new ParamUtils(map);
        postService.saveOrUpdate(param.toObj(Post.class));
        return Rest.ok();
    }

    @DeleteMapping
    public Rest del(Integer id) {
        postService.removeById(id);
        return Rest.ok();
    }
}
