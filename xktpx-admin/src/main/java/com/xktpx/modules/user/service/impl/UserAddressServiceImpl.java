package com.xktpx.modules.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.user.dao.UserAddressDao;
import com.xktpx.modules.user.entity.UserAddressEntity;
import com.xktpx.modules.user.service.UserAddressService;


@Service("userAddressService")
public class UserAddressServiceImpl extends ServiceImpl<UserAddressDao, UserAddressEntity> implements UserAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserAddressEntity> page = this.selectPage(
                new Query<UserAddressEntity>(params).getPage(),
                new EntityWrapper<UserAddressEntity>()
        );

        return new PageUtils(page);
    }

}
