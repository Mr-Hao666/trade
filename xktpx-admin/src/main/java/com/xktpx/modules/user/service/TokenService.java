package com.xktpx.modules.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.user.entity.TokenEntity;

import java.util.Map;

/**
 * 用户Token
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface TokenService extends IService<TokenEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

