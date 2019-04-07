package me.study.silang;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.study.silang.bean.Rest;
import me.study.silang.controller.PostController;
import me.study.silang.entity.Post;
import me.study.silang.service.IPostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SilangApplicationTests {

    @Resource
    PostController postController;

    @Resource
    IPostService postService;

    @Test
    public void del(){
        System.out.println(postController.del(1));
    }

}
