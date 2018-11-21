package com.xktpx.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.order.dao.OrderGoodsDetailDao;
import com.xktpx.modules.order.entity.OrderGoodsDetailEntity;
import com.xktpx.modules.order.service.OrderGoodsDetailService;


@Service("orderGoodsDetailService")
public class OrderGoodsDetailServiceImpl extends ServiceImpl<OrderGoodsDetailDao, OrderGoodsDetailEntity> implements OrderGoodsDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderGoodsDetailEntity> page = this.selectPage(
                new Query<OrderGoodsDetailEntity>(params).getPage(),
                new EntityWrapper<OrderGoodsDetailEntity>()
        );

        return new PageUtils(page);
    }

}
