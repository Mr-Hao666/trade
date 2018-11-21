package com.xktpx.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@Data
@TableName("tb_order_goods_detail")
public class OrderGoodsDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 商品名称(防止商品信息被删除)
	 */
	private String goodsName;
	/**
	 * 商品价格(防止商品信息被删除)
	 */
	private BigDecimal goodsPrice;
	/**
	 * 购买数量
	 */
	private Integer number;
	/**
	 * 小计金额
	 */
	private BigDecimal subtotal;
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * 更新时间
	 */
	private Date updatedTime;

}
