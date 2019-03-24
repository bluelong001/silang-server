package me.study.silang.service.impl;

import me.study.silang.entity.Video;
import me.study.silang.mapper.VideoMapper;
import me.study.silang.service.IVideoService;
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
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

}
