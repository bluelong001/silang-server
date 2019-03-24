package me.study.silang;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.study.silang.bean.Param;
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
    public void contextLoads() {
        Post p = new Post();
        p.setUserId(1);
        try {
            postController.add(Param.build().obj(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void conList(){

        Rest r = null;
        try {
            Post p = new Post();
            p.setUserId(1);
            r = postController.list(Param.build().page(1).pageSize(1).obj(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(r.toString());
    }

    @Test
    public void mapList(){
        QueryWrapper queryWrapper=new QueryWrapper<>().eq("user_id", 2);
        List<Post> post = postService.list(queryWrapper);
        System.out.println(post);
    }

    @Test
    public void update(){

        Rest r = null;
        try {
            Post p = Post.builder().userId(1).content("test").id(1).build();
            r = postController.update(Param.build().obj(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(r.toString());
    }

    @Test
    public void del(){
        System.out.println(postController.del(1));
    }

}
