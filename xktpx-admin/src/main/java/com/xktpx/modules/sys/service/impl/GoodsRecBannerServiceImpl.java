package com.xktpx.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.sys.dao.GoodsRecBannerDao;
import com.xktpx.modules.sys.entity.GoodsRecBannerEntity;
import com.xktpx.modules.sys.service.GoodsRecBannerService;


@Service("goodsRecBannerService")
public class GoodsRecBannerServiceImpl extends ServiceImpl<GoodsRecBannerDao, GoodsRecBannerEntity> implements GoodsRecBannerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsRecBannerEntity> page = this.selectPage(
                new Query<GoodsRecBannerEntity>(params).getPage(),
                new EntityWrapper<GoodsRecBannerEntity>()
        );

        return new PageUtils(page);
    }

}
