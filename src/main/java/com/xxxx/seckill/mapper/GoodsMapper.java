package com.xxxx.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.seckill.pojo.Goods;
import com.xxxx.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BOBO
 * @since 2023-11-27
 */
public interface GoodsMapper extends BaseMapper<Goods> {


    List<GoodsVo> findGoodsVo();
}
