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

import com.xktpx.modules.sys.entity.CouponEntity;
import com.xktpx.modules.sys.service.CouponService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 优惠券表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("sys/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:coupon:info")
    public R info(@PathVariable("id") Long id){
        CouponEntity coupon = couponService.selectById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
        couponService.insert(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
        ValidatorUtils.validateEntity(coupon);
        couponService.updateAllColumnById(coupon);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:coupon:delete")
    public R delete(@RequestBody Long[] ids){
        couponService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
