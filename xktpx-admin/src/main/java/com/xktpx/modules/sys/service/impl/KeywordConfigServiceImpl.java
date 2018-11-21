package com.xktpx.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.sys.dao.KeywordConfigDao;
import com.xktpx.modules.sys.entity.KeywordConfigEntity;
import com.xktpx.modules.sys.service.KeywordConfigService;


@Service("keywordConfigService")
public class KeywordConfigServiceImpl extends ServiceImpl<KeywordConfigDao, KeywordConfigEntity> implements KeywordConfigService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KeywordConfigEntity> page = this.selectPage(
                new Query<KeywordConfigEntity>(params).getPage(),
                new EntityWrapper<KeywordConfigEntity>()
        );

        return new PageUtils(page);
    }

}
