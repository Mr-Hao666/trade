package com.xktpx.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.sys.dao.UserMessageDao;
import com.xktpx.modules.sys.entity.UserMessageEntity;
import com.xktpx.modules.sys.service.UserMessageService;


@Service("userMessageService")
public class UserMessageServiceImpl extends ServiceImpl<UserMessageDao, UserMessageEntity> implements UserMessageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserMessageEntity> page = this.selectPage(
                new Query<UserMessageEntity>(params).getPage(),
                new EntityWrapper<UserMessageEntity>()
        );

        return new PageUtils(page);
    }

}
