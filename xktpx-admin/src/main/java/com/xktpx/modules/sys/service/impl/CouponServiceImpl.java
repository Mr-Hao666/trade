package com.xktpx.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.sys.dao.CouponDao;
import com.xktpx.modules.sys.entity.CouponEntity;
import com.xktpx.modules.sys.service.CouponService;


@Service("couponService")
public class CouponServiceImpl extends ServiceImpl<CouponDao, CouponEntity> implements CouponService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CouponEntity> page = this.selectPage(
                new Query<CouponEntity>(params).getPage(),
                new EntityWrapper<CouponEntity>()
        );

        return new PageUtils(page);
    }

}
