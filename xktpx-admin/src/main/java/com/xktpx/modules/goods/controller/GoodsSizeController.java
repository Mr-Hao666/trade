package com.xktpx.modules.goods.controller;

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

import com.xktpx.modules.goods.entity.GoodsSizeEntity;
import com.xktpx.modules.goods.service.GoodsSizeService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 商品尺码关联表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("goods/goodssize")
public class GoodsSizeController {
    @Autowired
    private GoodsSizeService goodsSizeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodssize:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsSizeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("goods:goodssize:info")
    public R info(@PathVariable("id") Long id){
        GoodsSizeEntity goodsSize = goodsSizeService.selectById(id);

        return R.ok().put("goodsSize", goodsSize);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodssize:save")
    public R save(@RequestBody GoodsSizeEntity goodsSize){
        goodsSizeService.insert(goodsSize);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodssize:update")
    public R update(@RequestBody GoodsSizeEntity goodsSize){
        ValidatorUtils.validateEntity(goodsSize);
        goodsSizeService.updateAllColumnById(goodsSize);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodssize:delete")
    public R delete(@RequestBody Long[] ids){
        goodsSizeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
