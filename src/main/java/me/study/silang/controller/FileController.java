package me.study.silang.controller;

import me.study.silang.bean.Param;
import me.study.silang.bean.Rest;
import me.study.silang.service.IFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
@RestController
@RequestMapping("/api/file")
public class FileController {
    @Value("${project-path}")
    public String projectPath;

    @Resource
    private IFileService fileService;

    @PostMapping("/upload")
    public Rest upload(@RequestParam Param param, @RequestParam(value = "file") List<MultipartFile> files, HttpServletRequest request) {
        String type = null != param.get("type") ? (String) param.get("type") : "cache";
        String savePath = projectPath + File.separator + type;
        for (MultipartFile f : files) {
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");
            File file = new File(savePath, fileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            while (file.exists()) file = new File(savePath, UUID.randomUUID().toString().replaceAll("-", ""));
            try {
                boolean flag = file.createNewFile();
                if (!flag) throw new IOException("create fail");

            } catch (IOException e) {
                e.printStackTrace();
                return Rest.fail();
            }
            try {
                f.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
                return Rest.fail();
            } finally {
                file.delete();
            }
            me.study.silang.entity.File fileBean = me.study.silang.entity.File.builder().fileName(fileName).type(type).build();
            fileService.save(fileBean);
        }
        return Rest.ok();
    }

    @GetMapping("/down")
    public ResponseEntity<InputStreamResource> downloadFile(Integer fileId, HttpServletRequest req) throws Exception {

        me.study.silang.entity.File fileBean = fileService.getById(fileId);
        File file = new File(projectPath + File.separator + fileBean.getType(), fileBean.getFileName());
        InputStream inputStream = new FileInputStream(file);
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(inputStreamResource);


    }
}
