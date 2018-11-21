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

import com.xktpx.modules.user.entity.UserAddressEntity;
import com.xktpx.modules.user.service.UserAddressService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 用户地址信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("user/useraddress")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:useraddress:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:useraddress:info")
    public R info(@PathVariable("id") Long id){
        UserAddressEntity userAddress = userAddressService.selectById(id);

        return R.ok().put("userAddress", userAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:useraddress:save")
    public R save(@RequestBody UserAddressEntity userAddress){
        userAddressService.insert(userAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:useraddress:update")
    public R update(@RequestBody UserAddressEntity userAddress){
        ValidatorUtils.validateEntity(userAddress);
        userAddressService.updateAllColumnById(userAddress);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:useraddress:delete")
    public R delete(@RequestBody Long[] ids){
        userAddressService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
