package com.xktpx.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.goods.entity.GoodsSizeEntity;

import java.util.Map;

/**
 * 商品尺码关联表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface GoodsSizeService extends IService<GoodsSizeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

