package com.xxxx.seckill.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.omg.PortableInterceptor.SUCCESSFUL;

@Getter
@ToString
@AllArgsConstructor
public enum  RespBeanEnum {
//    通用
    SUCCESS(200,""),
    ERROR(500,"服务端异常"),
    //登录模块
    LOGIN_ERRROR(500210,"用户名或密码不正确"),
    MOBILE_ERRROR(500211,"手机号码不正确不正确"),
    BIND_ERROR(500212,"参数校验异常");



    private final Integer code;
    private final String message;
}
