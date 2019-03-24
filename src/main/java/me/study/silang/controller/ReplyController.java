package me.study.silang.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import me.study.silang.bean.Param;
import me.study.silang.bean.Rest;
import me.study.silang.entity.Reply;
import me.study.silang.service.IReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
@RestController
@RequestMapping("/api/reply")
public class ReplyController {
    @Resource
    private IReplyService postService;

    @GetMapping
    public Rest list(@RequestParam Param param){
        IPage page = postService.page(param.toPage(), param.toQueryWrapper());
        return Rest.ok().data(page.getRecords()).total(page.getTotal());
    }

    @PostMapping
    public Rest add(@RequestParam Param param){
        postService.save((Reply)param.toObj(Reply.class));
        return Rest.ok();
    }

    @PutMapping
    public Rest update(@RequestParam Param param){
        postService.saveOrUpdate(param.toObj(Reply.class));
        return Rest.ok();
    }

    @DeleteMapping
    public Rest del(Integer id){
        postService.removeById(id);
        return Rest.ok();
    }
}
