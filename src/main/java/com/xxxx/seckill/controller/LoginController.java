package com.xxxx.seckill.controller;


import com.xxxx.seckill.vo.LoginVo;
import com.xxxx.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {



    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }


//    登录功能
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo loginVo){

        log.info("{}",loginVo);
        return null;


    }
}
