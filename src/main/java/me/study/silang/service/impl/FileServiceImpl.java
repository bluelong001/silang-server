package me.study.silang.service.impl;

import me.study.silang.bean.Rest;
import me.study.silang.entity.File;
import me.study.silang.mapper.FileMapper;
import me.study.silang.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.study.silang.utils.VideoUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
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
    public File saveFile(MultipartFile f, String type) {
        java.io.File file = newFile(type);
        try {
            Files.copy(f.getInputStream(), file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getFile(type, file);
    }

    private File getFile(String type, java.io.File file) {
        if (type.equals("mp4")) {
            try {
                VideoUtils.getVideoHead(file.getPath(),file.getPath().replace(".mp4",".jpg"));
            } catch (Exception e) {
                e.printStackTrace();
//            VideoUtils.getVideoHead2(file.getPath(), file.getPath().replace(".mp4", ".jpg"));

            }
        }
        File fileBean = File.builder().fileName(file.getName()).type(type).build();
        save(fileBean);
        return fileBean;
    }

    @Override
    public File saveFile(java.io.File f, String type) {
        java.io.File file = newFile(type);
        try {
            Files.copy(f.toPath(), file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getFile(type, file);
    }

    @Override
    public File saveFile(InputStream f, String type) {
        java.io.File file = newFile(type);
        try {
            Files.copy(f, file.toPath());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return getFile(type, file);
    }

    private java.io.File newFile(String type) {
        String savePath = projectPath + java.io.File.separator + type;
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + type;
        java.io.File file = new java.io.File(savePath, fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) file.delete();

        return file;
    }
}
