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

import com.xktpx.modules.goods.entity.GoodsRecBannerEntity;
import com.xktpx.modules.goods.service.GoodsRecBannerService;
import com.xktpx.common.utils.PageUtils;
import com.xktpx.common.utils.R;



/**
 * 商品推荐banner表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@RestController
@RequestMapping("goods/goodsrecbanner")
public class GoodsRecBannerController {
    @Autowired
    private GoodsRecBannerService goodsRecBannerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsrecbanner:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsRecBannerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("goods:goodsrecbanner:info")
    public R info(@PathVariable("id") Integer id){
        GoodsRecBannerEntity goodsRecBanner = goodsRecBannerService.selectById(id);

        return R.ok().put("goodsRecBanner", goodsRecBanner);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsrecbanner:save")
    public R save(@RequestBody GoodsRecBannerEntity goodsRecBanner){
        goodsRecBannerService.insert(goodsRecBanner);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsrecbanner:update")
    public R update(@RequestBody GoodsRecBannerEntity goodsRecBanner){
        ValidatorUtils.validateEntity(goodsRecBanner);
        goodsRecBannerService.updateAllColumnById(goodsRecBanner);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsrecbanner:delete")
    public R delete(@RequestBody Integer[] ids){
        goodsRecBannerService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
