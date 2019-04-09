package me.study.silang.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import me.study.silang.bean.ParamUtils;
import me.study.silang.bean.Rest;
import me.study.silang.entity.User;
import me.study.silang.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping
    public Rest list(@RequestParam Map map){
        ParamUtils param = new ParamUtils(map);
        IPage page = userService.page(param.toPage(), param.toQueryWrapper());
        return Rest.ok().data(page.getRecords()).total(page.getTotal());
    }

    @PostMapping
    public Rest add(@RequestParam Map map){
        ParamUtils param = new ParamUtils(map);
        userService.save((User)param.toObj(User.class));
        return Rest.ok();
    }

    @PutMapping
    public Rest update(@RequestParam Map map){
        ParamUtils param = new ParamUtils(map);
        userService.saveOrUpdate(param.toObj(User.class));
        return Rest.ok();
    }

    @GetMapping("/by-id")
    public Rest getById(Integer id, HttpServletRequest request){
        return Rest.ok().data(userService.getUserInfo(id, request));
    }

    @GetMapping("/by-token")
    public Rest getById(String token, HttpServletRequest request){
        return Rest.ok().data(userService.getUserInfo(token, request));
    }

    @DeleteMapping
    public Rest del(Integer id){
        userService.removeById(id);
        return Rest.ok();
    }
}
