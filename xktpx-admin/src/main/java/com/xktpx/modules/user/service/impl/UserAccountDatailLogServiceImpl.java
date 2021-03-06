package com.xktpx.modules.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.user.dao.UserAccountDatailLogDao;
import com.xktpx.modules.user.entity.UserAccountDatailLogEntity;
import com.xktpx.modules.user.service.UserAccountDatailLogService;


@Service("userAccountDatailLogService")
public class UserAccountDatailLogServiceImpl extends ServiceImpl<UserAccountDatailLogDao, UserAccountDatailLogEntity> implements UserAccountDatailLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserAccountDatailLogEntity> page = this.selectPage(
                new Query<UserAccountDatailLogEntity>(params).getPage(),
                new EntityWrapper<UserAccountDatailLogEntity>()
        );

        return new PageUtils(page);
    }

}
