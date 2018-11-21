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

import com.xktpx.modules.sys.entity.GoodsDetailEntity;
import com.xktpx.modules.sys.service.GoodsDetailService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("sys/goodsdetail")
public class GoodsDetailController {
    @Autowired
    private GoodsDetailService goodsDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:goodsdetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:goodsdetail:info")
    public R info(@PathVariable("id") Long id){
        GoodsDetailEntity goodsDetail = goodsDetailService.selectById(id);

        return R.ok().put("goodsDetail", goodsDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:goodsdetail:save")
    public R save(@RequestBody GoodsDetailEntity goodsDetail){
        goodsDetailService.insert(goodsDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:goodsdetail:update")
    public R update(@RequestBody GoodsDetailEntity goodsDetail){
        ValidatorUtils.validateEntity(goodsDetail);
        goodsDetailService.updateAllColumnById(goodsDetail);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:goodsdetail:delete")
    public R delete(@RequestBody Long[] ids){
        goodsDetailService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
