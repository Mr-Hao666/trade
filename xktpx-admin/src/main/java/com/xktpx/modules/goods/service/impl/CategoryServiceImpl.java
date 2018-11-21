package com.xktpx.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.goods.dao.CategoryDao;
import com.xktpx.modules.goods.entity.CategoryEntity;
import com.xktpx.modules.goods.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CategoryEntity> page = this.selectPage(
                new Query<CategoryEntity>(params).getPage(),
                new EntityWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

}
