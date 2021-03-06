package com.xktpx.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.order.dao.OrderReturnsDao;
import com.xktpx.modules.order.entity.OrderReturnsEntity;
import com.xktpx.modules.order.service.OrderReturnsService;


@Service("orderReturnsService")
public class OrderReturnsServiceImpl extends ServiceImpl<OrderReturnsDao, OrderReturnsEntity> implements OrderReturnsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderReturnsEntity> page = this.selectPage(
                new Query<OrderReturnsEntity>(params).getPage(),
                new EntityWrapper<OrderReturnsEntity>()
        );

        return new PageUtils(page);
    }

}
