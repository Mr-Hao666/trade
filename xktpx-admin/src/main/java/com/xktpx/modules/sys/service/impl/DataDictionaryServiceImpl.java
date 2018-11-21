package com.xktpx.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.sys.dao.DataDictionaryDao;
import com.xktpx.modules.sys.entity.DataDictionaryEntity;
import com.xktpx.modules.sys.service.DataDictionaryService;


@Service("dataDictionaryService")
public class DataDictionaryServiceImpl extends ServiceImpl<DataDictionaryDao, DataDictionaryEntity> implements DataDictionaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DataDictionaryEntity> page = this.selectPage(
                new Query<DataDictionaryEntity>(params).getPage(),
                new EntityWrapper<DataDictionaryEntity>()
        );

        return new PageUtils(page);
    }

}
