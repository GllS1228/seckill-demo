package com.xxxx.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.seckill.exception.GlobalException;
import com.xxxx.seckill.mapper.UserMapper;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IUserService;
import com.xxxx.seckill.utils.CookieUtil;
import com.xxxx.seckill.utils.MD5util;
import com.xxxx.seckill.utils.UUIDUtil;
import com.xxxx.seckill.vo.LoginVo;
import com.xxxx.seckill.vo.RespBean;
import com.xxxx.seckill.vo.RespBeanEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BOBO
 * @since 2023-10-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;


//    登录
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
//        if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
//            return RespBean.error(RespBeanEnum.LOGIN_ERRROR);
//        }
//        if (!ValidatorUtil.isMobile(mobile)){
//            return RespBean.error(RespBeanEnum.MOBILE_ERRROR);
//
//
//        }
        User user = userMapper.selectById(mobile);
        if (null==user){
          throw new GlobalException(RespBeanEnum.LOGIN_ERRROR);

        }
        if (!MD5util.formPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.LOGIN_ERRROR);
        }
        //生产coookie
        String ticket = UUIDUtil.uuid();
        redisTemplate.opsForValue().set("user" + ticket, user);
//        request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);


        return RespBean.success();
    }

    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(userTicket)) {
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        if (user != null) {
            CookieUtil.setCookie(request, response, "userTicket", userTicket);
        }
        return user;
    }

}
