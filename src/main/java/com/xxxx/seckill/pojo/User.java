package com.xxxx.seckill.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author BOBO
 * @since 2023-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，手机号码
     */
    private Long id;

    private String nicknime;

    /**
     * md5(md5(pass明文+固定salt)+salt)
     */
    private String password;

    private String salt;

    /**
     * 头像
     */
    private String head;

    /**
     * 注册时间
     */
    private Date registerDate;

    /**
     * 最后登录时间
     */
    private Date lostLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;


}
