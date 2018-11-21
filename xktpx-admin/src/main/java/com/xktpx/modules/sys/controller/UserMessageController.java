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

import com.xktpx.modules.sys.entity.UserMessageEntity;
import com.xktpx.modules.sys.service.UserMessageService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 用户消息信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("sys/usermessage")
public class UserMessageController {
    @Autowired
    private UserMessageService userMessageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:usermessage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userMessageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:usermessage:info")
    public R info(@PathVariable("id") Long id){
        UserMessageEntity userMessage = userMessageService.selectById(id);

        return R.ok().put("userMessage", userMessage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:usermessage:save")
    public R save(@RequestBody UserMessageEntity userMessage){
        userMessageService.insert(userMessage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:usermessage:update")
    public R update(@RequestBody UserMessageEntity userMessage){
        ValidatorUtils.validateEntity(userMessage);
        userMessageService.updateAllColumnById(userMessage);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:usermessage:delete")
    public R delete(@RequestBody Long[] ids){
        userMessageService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
