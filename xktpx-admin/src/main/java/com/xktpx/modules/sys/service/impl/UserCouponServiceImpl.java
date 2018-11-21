package com.xktpx.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.sys.dao.UserCouponDao;
import com.xktpx.modules.sys.entity.UserCouponEntity;
import com.xktpx.modules.sys.service.UserCouponService;


@Service("userCouponService")
public class UserCouponServiceImpl extends ServiceImpl<UserCouponDao, UserCouponEntity> implements UserCouponService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserCouponEntity> page = this.selectPage(
                new Query<UserCouponEntity>(params).getPage(),
                new EntityWrapper<UserCouponEntity>()
        );

        return new PageUtils(page);
    }

}
