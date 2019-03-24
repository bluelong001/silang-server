package me.study.silang.service.impl;

import me.study.silang.entity.User;
import me.study.silang.mapper.UserMapper;
import me.study.silang.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
