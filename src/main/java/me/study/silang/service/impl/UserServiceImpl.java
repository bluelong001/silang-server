package me.study.silang.service.impl;

import me.study.silang.entity.User;
import me.study.silang.mapper.UserMapper;
import me.study.silang.model.UserInfo;
import me.study.silang.service.IFileService;
import me.study.silang.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.study.silang.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    IFileService fileService;

    @Override
    public UserInfo getUserInfo(Integer id, HttpServletRequest request) {
        User user = getById(id);
        return UserInfo.builder()
                .id(id)
                .displayname(user.getDisplayname())
                .headIcon(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + request.getContextPath() + fileService.getById(user.getFileId()).getFileName())
                .role(user.getRole())
                .build();
    }

    @Override
    public UserInfo getUserInfo(String token, HttpServletRequest request) {
        Integer id = TokenUtils.getUserInfo(token);
        return getUserInfo(id, request);
    }
}
