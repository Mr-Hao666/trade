package com.xktpx.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.order.entity.OrderLogisticsEntity;

import java.util.Map;

/**
 * 订单物流信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface OrderLogisticsService extends IService<OrderLogisticsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

