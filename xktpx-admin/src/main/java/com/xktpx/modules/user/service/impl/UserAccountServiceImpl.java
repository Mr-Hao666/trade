package com.xktpx.modules.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.user.dao.UserAccountDao;
import com.xktpx.modules.user.entity.UserAccountEntity;
import com.xktpx.modules.user.service.UserAccountService;


@Service("userAccountService")
public class UserAccountServiceImpl extends ServiceImpl<UserAccountDao, UserAccountEntity> implements UserAccountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserAccountEntity> page = this.selectPage(
                new Query<UserAccountEntity>(params).getPage(),
                new EntityWrapper<UserAccountEntity>()
        );

        return new PageUtils(page);
    }

}
