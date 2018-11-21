package com.xktpx.modules.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.Query;

import com.xktpx.modules.user.dao.FeedbackDao;
import com.xktpx.modules.user.entity.FeedbackEntity;
import com.xktpx.modules.user.service.FeedbackService;


@Service("feedbackService")
public class FeedbackServiceImpl extends ServiceImpl<FeedbackDao, FeedbackEntity> implements FeedbackService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FeedbackEntity> page = this.selectPage(
                new Query<FeedbackEntity>(params).getPage(),
                new EntityWrapper<FeedbackEntity>()
        );

        return new PageUtils(page);
    }

}
