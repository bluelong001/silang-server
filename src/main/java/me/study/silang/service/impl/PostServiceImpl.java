package me.study.silang.service.impl;

import me.study.silang.entity.Post;
import me.study.silang.mapper.PostMapper;
import me.study.silang.service.IPostService;
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
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
