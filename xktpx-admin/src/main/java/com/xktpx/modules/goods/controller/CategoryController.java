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

import com.xktpx.modules.goods.entity.CategoryEntity;
import com.xktpx.modules.goods.service.CategoryService;
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
@RequestMapping("goods/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("goods:category:info")
    public R info(@PathVariable("id") Integer id){
        CategoryEntity category = categoryService.selectById(id);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:category:save")
    public R save(@RequestBody CategoryEntity category){
        categoryService.insert(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:category:update")
    public R update(@RequestBody CategoryEntity category){
        ValidatorUtils.validateEntity(category);
        categoryService.updateAllColumnById(category);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:category:delete")
    public R delete(@RequestBody Integer[] ids){
        categoryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
