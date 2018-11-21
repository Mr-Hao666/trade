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

import com.xktpx.modules.sys.entity.UserAccountDatailLogEntity;
import com.xktpx.modules.sys.service.UserAccountDatailLogService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 账户明细日志表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("sys/useraccountdataillog")
public class UserAccountDatailLogController {
    @Autowired
    private UserAccountDatailLogService userAccountDatailLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:useraccountdataillog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userAccountDatailLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:useraccountdataillog:info")
    public R info(@PathVariable("id") Long id){
        UserAccountDatailLogEntity userAccountDatailLog = userAccountDatailLogService.selectById(id);

        return R.ok().put("userAccountDatailLog", userAccountDatailLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:useraccountdataillog:save")
    public R save(@RequestBody UserAccountDatailLogEntity userAccountDatailLog){
        userAccountDatailLogService.insert(userAccountDatailLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:useraccountdataillog:update")
    public R update(@RequestBody UserAccountDatailLogEntity userAccountDatailLog){
        ValidatorUtils.validateEntity(userAccountDatailLog);
        userAccountDatailLogService.updateAllColumnById(userAccountDatailLog);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:useraccountdataillog:delete")
    public R delete(@RequestBody Long[] ids){
        userAccountDatailLogService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
