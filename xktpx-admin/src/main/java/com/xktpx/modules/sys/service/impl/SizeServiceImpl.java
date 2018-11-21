package com.xktpx.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.sys.dao.SizeDao;
import com.xktpx.modules.sys.entity.SizeEntity;
import com.xktpx.modules.sys.service.SizeService;


@Service("sizeService")
public class SizeServiceImpl extends ServiceImpl<SizeDao, SizeEntity> implements SizeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SizeEntity> page = this.selectPage(
                new Query<SizeEntity>(params).getPage(),
                new EntityWrapper<SizeEntity>()
        );

        return new PageUtils(page);
    }

}
