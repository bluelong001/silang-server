package me.study.silang.mapper;

import me.study.silang.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Me
 * @since 2019-05-01
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}
