package me.study.silang.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import me.study.silang.bean.ParamUtils;
import me.study.silang.bean.Rest;
import me.study.silang.entity.Video;
import me.study.silang.model.VideoModel;
import me.study.silang.service.IFileService;
import me.study.silang.service.IUserService;
import me.study.silang.service.IVideoService;
import me.study.silang.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
@RestController
@RequestMapping("/api/video")
public class VideoController {
    @Resource
    private IVideoService videoService;
    @Resource
    private IFileService fileService;
    @Resource
    private IUserService userService;
    @GetMapping
    public Rest list(@RequestParam Map map, HttpServletRequest request) {
        ParamUtils param = new ParamUtils(map);
        IPage page = videoService.page(param.toPage(), param.toQueryWrapper());
        List<VideoModel> modelList = new ArrayList<>();
        List<Video> videoList = page.getRecords();
        videoList.forEach(video -> {
            modelList.add(VideoModel.builder()
                    .content(video.getContent())
                    .title(video.getTitle())
                    .fileUrl(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + request.getContextPath() + fileService.getById(video.getFileId()).getFileName())
                    .userName(userService.getById(video.getUserId()).getUsername())
                    .gmtCreate(video.getGmtCreate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                    .gmtUpdate(video.getGmtUpdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                    .id(video.getId())
                    .build());
        });
        return Rest.ok().data(modelList).total(page.getTotal());
    }

    @PostMapping
    public Rest add(@RequestParam Map map, HttpServletRequest request) {
        Video video = (Video) new ParamUtils(map).toObj(Video.class);
        video.setUserId(TokenUtils.getUserInfo(request).getId());
        videoService.save(video);
        return Rest.ok();
    }

    @PutMapping
    public Rest update(@RequestParam Map map) {
        ParamUtils param = new ParamUtils(map);
        videoService.saveOrUpdate(param.toObj(Video.class));
        return Rest.ok();
    }

    @DeleteMapping
    public Rest del(Integer id) {
        videoService.removeById(id);
        return Rest.ok();
    }
}
