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

import com.xktpx.modules.order.entity.OrderLogisticsEntity;
import com.xktpx.modules.order.service.OrderLogisticsService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 订单物流信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("order/orderlogistics")
public class OrderLogisticsController {
    @Autowired
    private OrderLogisticsService orderLogisticsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:orderlogistics:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderLogisticsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:orderlogistics:info")
    public R info(@PathVariable("id") Long id){
        OrderLogisticsEntity orderLogistics = orderLogisticsService.selectById(id);

        return R.ok().put("orderLogistics", orderLogistics);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:orderlogistics:save")
    public R save(@RequestBody OrderLogisticsEntity orderLogistics){
        orderLogisticsService.insert(orderLogistics);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:orderlogistics:update")
    public R update(@RequestBody OrderLogisticsEntity orderLogistics){
        ValidatorUtils.validateEntity(orderLogistics);
        orderLogisticsService.updateAllColumnById(orderLogistics);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:orderlogistics:delete")
    public R delete(@RequestBody Long[] ids){
        orderLogisticsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
