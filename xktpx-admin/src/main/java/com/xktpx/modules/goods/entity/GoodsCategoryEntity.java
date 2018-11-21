package com.xktpx.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品分类表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@Data
@TableName("tb_goods_category")
public class GoodsCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 分类id
	 */
	private Integer categoryId;
	/**
	 * 商品id
	 */
	private Long goodsId;

}
