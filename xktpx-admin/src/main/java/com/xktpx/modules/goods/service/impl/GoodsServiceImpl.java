package com.xktpx.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.goods.dao.GoodsDao;
import com.xktpx.modules.goods.entity.GoodsEntity;
import com.xktpx.modules.goods.service.GoodsService;


@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsEntity> page = this.selectPage(
                new Query<GoodsEntity>(params).getPage(),
                new EntityWrapper<GoodsEntity>()
        );

        return new PageUtils(page);
    }

}
