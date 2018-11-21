package com.xktpx.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.sys.dao.TokenDao;
import com.xktpx.modules.sys.entity.TokenEntity;
import com.xktpx.modules.sys.service.TokenService;


@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TokenEntity> page = this.selectPage(
                new Query<TokenEntity>(params).getPage(),
                new EntityWrapper<TokenEntity>()
        );

        return new PageUtils(page);
    }

}
