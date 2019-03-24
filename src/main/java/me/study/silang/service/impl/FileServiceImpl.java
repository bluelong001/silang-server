package me.study.silang.service.impl;

import me.study.silang.entity.File;
import me.study.silang.mapper.FileMapper;
import me.study.silang.service.IFileService;
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
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

}
