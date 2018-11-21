package com.xktpx.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.sys.dao.GoodsDetailDao;
import com.xktpx.modules.sys.entity.GoodsDetailEntity;
import com.xktpx.modules.sys.service.GoodsDetailService;


@Service("goodsDetailService")
public class GoodsDetailServiceImpl extends ServiceImpl<GoodsDetailDao, GoodsDetailEntity> implements GoodsDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsDetailEntity> page = this.selectPage(
                new Query<GoodsDetailEntity>(params).getPage(),
                new EntityWrapper<GoodsDetailEntity>()
        );

        return new PageUtils(page);
    }

}
