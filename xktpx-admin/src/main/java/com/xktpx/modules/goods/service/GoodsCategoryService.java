package com.xktpx.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.goods.entity.GoodsCategoryEntity;

import java.util.Map;

/**
 * 商品分类表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface GoodsCategoryService extends IService<GoodsCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

