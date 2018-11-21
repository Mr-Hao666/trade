package com.xktpx.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.order.entity.OrderGoodsDetailEntity;

import java.util.Map;

/**
 * 订单详情表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface OrderGoodsDetailService extends IService<OrderGoodsDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

