package com.xktpx.modules.order.controller;

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

import com.xktpx.modules.order.entity.OrderGoodsDetailEntity;
import com.xktpx.modules.order.service.OrderGoodsDetailService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 订单详情表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("order/ordergoodsdetail")
public class OrderGoodsDetailController {
    @Autowired
    private OrderGoodsDetailService orderGoodsDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:ordergoodsdetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderGoodsDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:ordergoodsdetail:info")
    public R info(@PathVariable("id") Long id){
        OrderGoodsDetailEntity orderGoodsDetail = orderGoodsDetailService.selectById(id);

        return R.ok().put("orderGoodsDetail", orderGoodsDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:ordergoodsdetail:save")
    public R save(@RequestBody OrderGoodsDetailEntity orderGoodsDetail){
        orderGoodsDetailService.insert(orderGoodsDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:ordergoodsdetail:update")
    public R update(@RequestBody OrderGoodsDetailEntity orderGoodsDetail){
        ValidatorUtils.validateEntity(orderGoodsDetail);
        orderGoodsDetailService.updateAllColumnById(orderGoodsDetail);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:ordergoodsdetail:delete")
    public R delete(@RequestBody Long[] ids){
        orderGoodsDetailService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
