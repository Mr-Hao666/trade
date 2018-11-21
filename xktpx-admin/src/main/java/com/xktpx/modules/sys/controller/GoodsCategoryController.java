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

import com.xktpx.modules.sys.entity.GoodsCategoryEntity;
import com.xktpx.modules.sys.service.GoodsCategoryService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 商品分类表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("sys/goodscategory")
public class GoodsCategoryController {
    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:goodscategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:goodscategory:info")
    public R info(@PathVariable("id") Long id){
        GoodsCategoryEntity goodsCategory = goodsCategoryService.selectById(id);

        return R.ok().put("goodsCategory", goodsCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:goodscategory:save")
    public R save(@RequestBody GoodsCategoryEntity goodsCategory){
        goodsCategoryService.insert(goodsCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:goodscategory:update")
    public R update(@RequestBody GoodsCategoryEntity goodsCategory){
        ValidatorUtils.validateEntity(goodsCategory);
        goodsCategoryService.updateAllColumnById(goodsCategory);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:goodscategory:delete")
    public R delete(@RequestBody Long[] ids){
        goodsCategoryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
