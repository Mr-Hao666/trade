package com.xktpx.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.sys.dao.GoodsSizeDao;
import com.xktpx.modules.sys.entity.GoodsSizeEntity;
import com.xktpx.modules.sys.service.GoodsSizeService;


@Service("goodsSizeService")
public class GoodsSizeServiceImpl extends ServiceImpl<GoodsSizeDao, GoodsSizeEntity> implements GoodsSizeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsSizeEntity> page = this.selectPage(
                new Query<GoodsSizeEntity>(params).getPage(),
                new EntityWrapper<GoodsSizeEntity>()
        );

        return new PageUtils(page);
    }

}
