package me.study.silang.mapper;

import me.study.silang.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

}
