package me.study.silang.service;

import me.study.silang.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import me.study.silang.model.UserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
public interface IUserService extends IService<User> {

    UserInfo getUserInfo (Integer id, HttpServletRequest request);
    UserInfo getUserInfo (String token, HttpServletRequest request);
}
