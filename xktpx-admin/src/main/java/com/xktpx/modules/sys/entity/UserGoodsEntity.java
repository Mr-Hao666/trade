package com.xktpx.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@Data
@TableName("tb_user_goods")
public class UserGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Date saleTime;
	/**
	 * 性别：0男，1女，2不限
	 */
	private Integer sex;
	/**
	 * 货号
	 */
	private Integer number;
	/**
	 * 
	 */
	private String picture;
	/**
	 * 
	 */
	private String brand;
	/**
	 * 
	 */
	private String salesVolume;
	/**
	 * 
	 */
	private String classification;
	/**
	 * 
	 */
	private Integer goodsId;
	/**
	 * 
	 */
	private String color;
	/**
	 * 
	 */
	private Double size;
	/**
	 * 
	 */
	private Date createdTime;
	/**
	 * 
	 */
	private Date updatedTime;

}
