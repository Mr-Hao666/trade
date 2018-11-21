package com.xktpx.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 账户明细日志表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 10:59:48
 */
@Data
@TableName("tb_user_account_datail_log")
public class UserAccountDatailLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 账户id
	 */
	private Long accountId;
	/**
	 * 变动类型 1:退换至微信 2:定金退回 3:支付保证金 4:微信转账...
	 */
	private Integer changeType;
	/**
	 * 变动金额
	 */
	private BigDecimal changeMoney;
	/**
	 * 变动前金额
	 */
	private BigDecimal beforeChangeMoney;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 状态 0:有效 1:无效
	 */
	private Integer state;

}
