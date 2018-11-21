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

import com.xktpx.modules.sys.entity.UserAccountEntity;
import com.xktpx.modules.sys.service.UserAccountService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 用户账户信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("sys/useraccount")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:useraccount:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userAccountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:useraccount:info")
    public R info(@PathVariable("id") Long id){
        UserAccountEntity userAccount = userAccountService.selectById(id);

        return R.ok().put("userAccount", userAccount);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:useraccount:save")
    public R save(@RequestBody UserAccountEntity userAccount){
        userAccountService.insert(userAccount);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:useraccount:update")
    public R update(@RequestBody UserAccountEntity userAccount){
        ValidatorUtils.validateEntity(userAccount);
        userAccountService.updateAllColumnById(userAccount);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:useraccount:delete")
    public R delete(@RequestBody Long[] ids){
        userAccountService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
