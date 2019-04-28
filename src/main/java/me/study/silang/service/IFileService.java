package me.study.silang.service;

import me.study.silang.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
public interface IFileService extends IService<File> {
    File saveFile(MultipartFile f, String type);

    File saveFile(java.io.File f, String type);
}
