package com.xktpx.modules.user.controller;

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

import com.xktpx.modules.user.entity.UserAccountEntity;
import com.xktpx.modules.user.service.UserAccountService;
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
@RequestMapping("user/useraccount")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:useraccount:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userAccountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:useraccount:info")
    public R info(@PathVariable("id") Long id){
        UserAccountEntity userAccount = userAccountService.selectById(id);

        return R.ok().put("userAccount", userAccount);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:useraccount:save")
    public R save(@RequestBody UserAccountEntity userAccount){
        userAccountService.insert(userAccount);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:useraccount:update")
    public R update(@RequestBody UserAccountEntity userAccount){
        ValidatorUtils.validateEntity(userAccount);
        userAccountService.updateAllColumnById(userAccount);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:useraccount:delete")
    public R delete(@RequestBody Long[] ids){
        userAccountService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
