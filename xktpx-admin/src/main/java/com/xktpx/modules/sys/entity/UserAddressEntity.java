package com.xktpx.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户地址信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@Data
@TableName("tb_user_address")
public class UserAddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 省id
	 */
	private Integer provinceId;
	/**
	 * 市id
	 */
	private Integer cityId;
	/**
	 * 区id
	 */
	private Integer areaId;
	/**
	 * 详细地址
	 */
	private String detailAddress;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 是否默认 0:否 1:是(同一个用户只能有一个默认地址)
	 */
	private Integer isDefault;

}
