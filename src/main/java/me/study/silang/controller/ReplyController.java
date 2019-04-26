package me.study.silang.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import me.study.silang.bean.ParamUtils;
import me.study.silang.bean.Rest;
import me.study.silang.entity.Reply;
import me.study.silang.model.ReplyModel;
import me.study.silang.service.IReplyService;
import me.study.silang.service.IUserService;
import me.study.silang.service.SocketIOService;
import me.study.silang.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private IReplyService replyService;
    @Resource
    private IUserService userService;
    @Resource
    private SocketIOService socketIOService;
    @GetMapping
    public Rest list(@RequestParam Map map,HttpServletRequest request){
        ParamUtils param = new ParamUtils(map);
        IPage page = replyService.page(param.toPage(), param.toQueryWrapper());
        List<Reply> replies = page.getRecords();
        List<ReplyModel> replyModels=new ArrayList<>();
        replies.forEach(reply -> {
            replyModels.add(ReplyModel.builder()
                    .id(reply.getId())
                    .context(reply.getContext())
                    .gmtCreate(reply.getGmtCreate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                    .gmtUpdate(reply.getGmtUpdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                    .userInfo(userService.getUserInfo(reply.getUserId(),request)).build());
        });
        return Rest.ok().data(replyModels).total(page.getTotal());
    }

    @PostMapping
    public Rest add(@RequestParam Map map, HttpServletRequest request){
        ParamUtils param = new ParamUtils(map);
        Reply reply =(Reply)param.toObj(Reply.class);
        reply.setUserId(TokenUtils.getUserInfo(request));
        replyService.save(reply);

        //找到主题的发表人id
        Map<String,Object> replyMsg=new HashMap<>();
        replyMsg.put("toPostId",reply.getPostId());
        replyMsg.put("fromUserId",reply.getUserId());
        socketIOService.pushMessageToUser(replyMsg);
        return Rest.ok();
    }

    @PutMapping
    public Rest update(@RequestParam Map map){
        ParamUtils param = new ParamUtils(map);
        replyService.saveOrUpdate(param.toObj(Reply.class));
        return Rest.ok();
    }

    @DeleteMapping
    public Rest del(Integer id){
        replyService.removeById(id);
        return Rest.ok();
    }
}
