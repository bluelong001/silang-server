package me.study.silang.service.impl;

import me.study.silang.bean.Rest;
import me.study.silang.entity.File;
import me.study.silang.mapper.FileMapper;
import me.study.silang.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

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
    @Value("${project-path}")
    public String projectPath;
    @Override
    public File saveFile(MultipartFile f,String type) {
        String savePath = projectPath + java.io.File.separator + type;
        String fileName = UUID.randomUUID().toString().replaceAll("-", "")+"."+type;
        java.io.File file = new java.io.File(savePath, fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if(file.exists())file.delete();
        try {
            Files.copy(f.getInputStream(), file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        me.study.silang.entity.File fileBean = me.study.silang.entity.File.builder().fileName(fileName).type(type).build();
        save(fileBean);
        return fileBean;
    }

    @Override
    public File saveFile(java.io.File f, String type) {
        String savePath = projectPath + java.io.File.separator + type;
        String fileName = UUID.randomUUID().toString().replaceAll("-", "")+"."+type;
        java.io.File file = new java.io.File(savePath, fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if(file.exists())file.delete();
        try {
            Files.copy(f.toPath(), file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        me.study.silang.entity.File fileBean = me.study.silang.entity.File.builder().fileName(fileName).type(type).build();
        save(fileBean);
        return fileBean;
    }
}
