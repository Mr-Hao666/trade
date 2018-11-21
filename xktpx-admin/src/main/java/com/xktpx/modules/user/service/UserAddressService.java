package com.xktpx.modules.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.user.entity.UserAddressEntity;

import java.util.Map;

/**
 * 用户地址信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface UserAddressService extends IService<UserAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

