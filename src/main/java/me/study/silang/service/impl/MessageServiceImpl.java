package me.study.silang.service.impl;

import me.study.silang.entity.Message;
import me.study.silang.mapper.MessageMapper;
import me.study.silang.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Me
 * @since 2019-05-01
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
