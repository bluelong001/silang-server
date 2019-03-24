package me.study.silang.bean;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.Data;

import java.io.Serializable;

@Data
public class Rest<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Integer SUCCESS = 200;
    private static final Integer FAIL = 201;
    private static final Integer NO_AUTHENTICATION = 202;
    private static final Integer API_UNAUTHORIZED = 203;
    private static final Integer NO_EXITS = 204;
    private static final Integer AUTHENTICATION_ERROR = 205;
    private static final Integer DISK_UNAUTHORIZED = 206;
    private static final Integer SERVER_EXCEPTION = 207;

    private T data; //服务端数据
    private Integer status = SUCCESS; //状态码
    private String msg = ""; //描述信息
    private Long total = 0L; //数据总条数

    public static Rest ok() {
        return new Rest().msg("成功");
    }

    public static Rest fail() {
        return new Rest().status(FAIL);
    }

    public static Rest fail(Throwable e) {
        return fail().msg(e);
    }

    public static Rest fail(String msg) {
        return fail().msg(msg);
    }

    public static Rest noAuth() {
        return new Rest().status(NO_AUTHENTICATION).msg("账号已经失效，请重新登录");
    }

    public static Rest apiUnAuth() {
        return new Rest().status(API_UNAUTHORIZED).msg("你没有这个权限！");
    }

    public static Rest noExits() {
        return new Rest().status(NO_EXITS).msg("此页面/路径不存在");
    }

    public static Rest authFail() {
        return new Rest().status(AUTHENTICATION_ERROR).msg("认证失败");
    }

    public static Rest diskUnAuth() {
        return new Rest().status(DISK_UNAUTHORIZED).msg("你没有这个权限！");
    }

    public static Rest serverException() {
        return new Rest().status(SERVER_EXCEPTION).msg("服务器异常！");
    }

    public Rest msg(Throwable e) {
        this.setMsg(e.toString());
        return this;
    }

    public Rest msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public Rest data(T data) {
        this.setData(data);
        return this;
    }

    public Rest status(Integer status) {
        this.setStatus(status);
        return this;
    }

    public Rest total(Long total) {
        this.setTotal(total);
        return this;
    }

}
