package com.xktpx.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.sys.entity.UserMessageEntity;

import java.util.Map;

/**
 * 用户消息信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface UserMessageService extends IService<UserMessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

