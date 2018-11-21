package com.xktpx.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单物流信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@Data
@TableName("tb_order_logistics")
public class OrderLogisticsEntity implements Serializable {
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
	 * 物流单号
	 */
	private String expressNo;
	/**
	 * 收货人姓名(更保险)
	 */
	private String consigneeRealname;
	/**
	 * 联系电话(更保险)
	 */
	private String consigneeTelphone;
	/**
	 * 收货地址
	 */
	private String consigneeAddress;
	/**
	 * 邮政编码
	 */
	private String consigneeZip;
	/**
	 * 物流方式 1:ems ...
	 */
	private Integer logisticsType;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
