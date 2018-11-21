package com.xktpx.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.sys.entity.UserAccountDatailLogEntity;

import java.util.Map;

/**
 * 账户明细日志表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface UserAccountDatailLogService extends IService<UserAccountDatailLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

