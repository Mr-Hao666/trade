package com.xktpx.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.goods.entity.GoodsRecBannerEntity;

import java.util.Map;

/**
 * 商品推荐banner表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface GoodsRecBannerService extends IService<GoodsRecBannerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

