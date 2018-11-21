package com.xktpx.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.sys.entity.UserAccountEntity;

import java.util.Map;

/**
 * 用户账户信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface UserAccountService extends IService<UserAccountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

