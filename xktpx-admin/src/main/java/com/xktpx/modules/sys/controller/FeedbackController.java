package com.xktpx.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.xktpx.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xktpx.modules.sys.entity.FeedbackEntity;
import com.xktpx.modules.sys.service.FeedbackService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 意见反馈表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("sys/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:feedback:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = feedbackService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:feedback:info")
    public R info(@PathVariable("id") Long id){
        FeedbackEntity feedback = feedbackService.selectById(id);

        return R.ok().put("feedback", feedback);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:feedback:save")
    public R save(@RequestBody FeedbackEntity feedback){
        feedbackService.insert(feedback);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:feedback:update")
    public R update(@RequestBody FeedbackEntity feedback){
        ValidatorUtils.validateEntity(feedback);
        feedbackService.updateAllColumnById(feedback);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:feedback:delete")
    public R delete(@RequestBody Long[] ids){
        feedbackService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
