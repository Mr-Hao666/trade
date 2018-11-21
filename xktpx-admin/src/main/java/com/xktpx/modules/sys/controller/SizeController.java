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

import com.xktpx.modules.sys.entity.SizeEntity;
import com.xktpx.modules.sys.service.SizeService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 尺码信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("sys/size")
public class SizeController {
    @Autowired
    private SizeService sizeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:size:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sizeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:size:info")
    public R info(@PathVariable("id") Integer id){
        SizeEntity size = sizeService.selectById(id);

        return R.ok().put("size", size);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:size:save")
    public R save(@RequestBody SizeEntity size){
        sizeService.insert(size);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:size:update")
    public R update(@RequestBody SizeEntity size){
        ValidatorUtils.validateEntity(size);
        sizeService.updateAllColumnById(size);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:size:delete")
    public R delete(@RequestBody Integer[] ids){
        sizeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
