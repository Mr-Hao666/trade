package com.xktpx.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.order.entity.OrderReturnsEntity;

import java.util.Map;

/**
 * 订单退货表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface OrderReturnsService extends IService<OrderReturnsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

