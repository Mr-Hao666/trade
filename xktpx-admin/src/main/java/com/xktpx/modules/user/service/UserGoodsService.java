package com.xktpx.modules.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.user.entity.UserGoodsEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface UserGoodsService extends IService<UserGoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

