package com.xktpx.modules.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.user.dao.UserGoodsDao;
import com.xktpx.modules.user.entity.UserGoodsEntity;
import com.xktpx.modules.user.service.UserGoodsService;


@Service("userGoodsService")
public class UserGoodsServiceImpl extends ServiceImpl<UserGoodsDao, UserGoodsEntity> implements UserGoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserGoodsEntity> page = this.selectPage(
                new Query<UserGoodsEntity>(params).getPage(),
                new EntityWrapper<UserGoodsEntity>()
        );

        return new PageUtils(page);
    }

}
