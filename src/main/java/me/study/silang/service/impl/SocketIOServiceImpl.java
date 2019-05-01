package me.study.silang.service.impl;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import me.study.silang.entity.*;
import me.study.silang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service(value = "socketIOService")
public class SocketIOServiceImpl implements SocketIOService {

    // 用来存已连接的客户端
    private static Map<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();

    @Resource
    private SocketIOServer socketIOServer;
    @Resource
    private IPostService postService;
    @Resource
    private IUserService userService;
    @Resource
    private IReplyService replyService;
    @Resource
    private IUserMessageService userMessageService;
    @Resource
    private IMessageService messageService;

    /**
     * Spring IoC容器创建之后，在加载SocketIOServiceImpl Bean之后启动
     *
     * @throws Exception
     */
    @PostConstruct
    private void autoStartup() throws Exception {
        start();
    }

    /**
     * Spring IoC容器在销毁SocketIOServiceImpl Bean之前关闭,避免重启项目服务端口占用问题
     *
     * @throws Exception
     */
    @PreDestroy
    private void autoStop() throws Exception {
        stop();
    }

    @Override
    public void start() {
        // 监听客户端连接
        socketIOServer.addConnectListener(client -> {
//            String loginUserNum = getParamsByClient(client);
//            if (loginUserNum != null) {
//                clientMap.put(loginUserNum, client);
//            }
        });

        // 监听客户端断开连接
        socketIOServer.addDisconnectListener(client -> {
//            String loginUserNum = getParamsByClient(client);
//            if (loginUserNum != null) {
//                clientMap.remove(loginUserNum);
//                client.disconnect();
//            }
        });

        // 处理自定义的事件，与连接监听类似
        socketIOServer.addEventListener("login", String.class, (client, data, ackSender) -> {
            clientMap.put(data, client);
        });

        socketIOServer.addEventListener("logout", String.class, (client, data, ackSender) -> {
            clientMap.remove(data);
        });


        socketIOServer.start();
    }

    @Override
    public void stop() {
        if (socketIOServer != null) {
            socketIOServer.stop();
            socketIOServer = null;
        }
    }


    private Integer saveMessage(String msg, boolean _toAll, Integer... userId) {
        Message message = Message.builder()
                .message(msg)
                .build();
        messageService.save(message);
        if (_toAll) {
            List<User> list = userService.list();
            list.forEach(item ->
                    userMessageService.save(UserMessage.builder().userId(item.getId()).messageId(message.getId()).build()));
        } else {
            for (Integer integer : userId) {
                userMessageService.save(UserMessage.builder().userId(integer).messageId(message.getId()).build());
            }
        }
        return message.getId();
    }

    @Override
    public void pushMessageToAllUser(String msg) {
        Integer id  =saveMessage(msg, true);
        for (String key : clientMap.keySet()) {
            SocketIOClient client = clientMap.get(key);
            if (client != null)
                client.sendEvent("systemCall",id );
        }
    }

    @Override
    public void pushMessageToUser(Map<String, Object> map) {
        Integer postId = (Integer) map.get("toPostId");
        Post post = postService.getById(postId);
        Integer toUser = post.getUserId();
        String msg = userService.getById(toUser).getDisplayname() + "回复了你发表的主题：" + post.getTitle();
        Integer id  =saveMessage(msg, false, toUser);
        SocketIOClient client = clientMap.get(toUser.toString());
        if (client != null)
            client.sendEvent("replyCall", id);

    }

    /**
     * 此方法为获取client连接中的参数，可根据需求更改
     *
     * @param client
     * @return
     */
    private String getParamsByClient(SocketIOClient client) {
        // 从请求的连接中拿出参数（这里的loginUserNum必须是唯一标识）
        Map<String, List<String>> params = client.getHandshakeData().getUrlParams();
        List<String> list = params.get("loginUserNum");
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}