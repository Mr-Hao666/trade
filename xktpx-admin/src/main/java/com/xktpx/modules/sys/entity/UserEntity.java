package com.xktpx.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@Data
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 身份证号码
	 */
	private String idCardNo;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 登录密码
	 */
	private String loginPwd;
	/**
	 * 头像id
	 */
	private Long avatarId;
	/**
	 * 性别 0:未知 1:男 2:女
	 */
	private Integer gender;
	/**
	 * open_id(保留字段)
	 */
	private String openId;
	/**
	 * token(保留字段)
	 */
	private String token;
	/**
	 * 是否实名认证 0:未认证 1:认证成功 2:认证失败
	 */
	private Integer realNameAuthorized;
	/**
	 * 最近登录时间
	 */
	private Date latestLoginTime;
	/**
	 * 最近登录ip
	 */
	private String latestLoginIp;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 状态 1:正常 2:禁用 3:删除
	 */
	private Integer curState;

}
