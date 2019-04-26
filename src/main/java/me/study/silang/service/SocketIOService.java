package me.study.silang.service;

import me.study.silang.entity.Post;
import me.study.silang.entity.Video;

import java.util.Map;

public interface SocketIOService {   //推送的事件
    public static final String PUSH_EVENT = "push_event";

    // 启动服务
    void start() throws Exception;

    // 停止服务
    void stop();



    //
//    void pushMessageToAllUser();

    //

    //
    void pushMessageToAllUser(Post post);

    void pushMessageToAllUser(Video post);

    void pushMessageToUser(Map<String, Object> map);
}
