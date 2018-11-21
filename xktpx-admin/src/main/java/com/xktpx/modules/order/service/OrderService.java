package com.xktpx.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

