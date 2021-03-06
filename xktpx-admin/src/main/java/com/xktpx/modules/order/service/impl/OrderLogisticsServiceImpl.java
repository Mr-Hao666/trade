package com.xktpx.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.order.dao.OrderLogisticsDao;
import com.xktpx.modules.order.entity.OrderLogisticsEntity;
import com.xktpx.modules.order.service.OrderLogisticsService;


@Service("orderLogisticsService")
public class OrderLogisticsServiceImpl extends ServiceImpl<OrderLogisticsDao, OrderLogisticsEntity> implements OrderLogisticsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderLogisticsEntity> page = this.selectPage(
                new Query<OrderLogisticsEntity>(params).getPage(),
                new EntityWrapper<OrderLogisticsEntity>()
        );

        return new PageUtils(page);
    }

}
