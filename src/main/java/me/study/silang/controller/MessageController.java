package me.study.silang.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.study.silang.bean.Rest;
import me.study.silang.entity.Message;
import me.study.silang.entity.UserMessage;
import me.study.silang.service.IMessageService;
import me.study.silang.service.IUserMessageService;
import me.study.silang.service.SocketIOService;
import me.study.silang.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Me
 * @since 2019-05-01
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Resource
    public IMessageService messageService;
    @Resource
    public IUserMessageService userMessageService;

    @Resource
    public SocketIOService socketIOService;

    @GetMapping("/list/user")
    public Rest listByUserId(HttpServletRequest request) {
        List<UserMessage> list = userMessageService.list(new QueryWrapper<UserMessage>().lambda().eq(UserMessage::getUserId,
                TokenUtils.getUserInfo(request)));
        List<Message> msgs = new ArrayList<>();
        list.forEach(item ->
                msgs.add(messageService.getById(item.getMessageId())));
        return Rest.ok().data(msgs);
    }

    @GetMapping
    public Rest list() {
        List<Message> list = messageService.list();
        return Rest.ok().data(list);
    }

    @PostMapping
    public Rest add(String message, Boolean pushEnabled) {
        if (pushEnabled){

            socketIOService.pushMessageToAllUser(message);
        }else
            messageService.save(Message.builder().message(message).build());
        return Rest.ok();
    }

    @GetMapping("/get/by-id")
    public Rest getById(Integer id, HttpServletRequest request) {
        return Rest.ok().data(messageService.getById(id));
    }

    @DeleteMapping
    public Rest del(Integer id) {
        messageService.removeById(id);
        return Rest.ok();
    }

    @DeleteMapping("/del/um")
    public Rest delMessage(Integer id, HttpServletRequest request) {
        userMessageService.remove(new QueryWrapper<UserMessage>().lambda().eq(UserMessage::getUserId,
                TokenUtils.getUserInfo(request)).eq(UserMessage::getMessageId, id));
        return Rest.ok();
    }
}
