package me.study.silang.controller;

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
import java.nio.file.Files;
import java.util.ArrayList;
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
    public Rest upload(@RequestParam Map<String,String> param, @RequestParam(value = "file") List<MultipartFile> files) {
        String type = null != param.get("type") ? param.get("type") : "cache";
        String savePath = projectPath + File.separator + type;
        List<String> ids=new ArrayList<>();
        for (MultipartFile f : files) {
            String fileName = UUID.randomUUID().toString().replaceAll("-", "")+"."+type;
            File file = new File(savePath, fileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                Files.copy(f.getInputStream(), file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
                return Rest.fail();
            }
            me.study.silang.entity.File fileBean = me.study.silang.entity.File.builder().fileName(fileName).type(type).build();
            fileService.save(fileBean);
            ids.add(fileBean.getId().toString());
        }
        return Rest.ok().data(String.join(";",ids));
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

    @GetMapping
    public Rest get(Integer fileId, HttpServletRequest request) throws Exception {

        me.study.silang.entity.File fileBean = fileService.getById(fileId);
        String url = (request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + request.getContextPath()+ fileService.getById(fileId).getFileName());
        return Rest.ok().data(url);



    }
}
