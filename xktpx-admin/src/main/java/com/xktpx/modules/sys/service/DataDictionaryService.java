package com.xktpx.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.modules.sys.entity.DataDictionaryEntity;

import java.util.Map;

/**
 * 数据字典表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
public interface DataDictionaryService extends IService<DataDictionaryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

