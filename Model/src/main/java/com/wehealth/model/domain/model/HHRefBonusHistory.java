/**
 * Copyright (C) 2014-2015 5WeHealth Technologies. All rights reserved.
 */
package com.wehealth.model.domain.model;

import com.wehealth.model.domain.interfaceutil.CreateTimeAuditable;
import com.wehealth.model.domain.interfaceutil.Entity;

import java.util.Date;

/**
 * 推荐赠送和缓服务历史记录
 */
public class HHRefBonusHistory implements CreateTimeAuditable, Entity
{
	private Long id;
	private String purchaserCellPhone;
	private String refereeCellPhone;
	private Date createTime;
	private String operator;
	private String bonusReason;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public String getOperator()
	{
		return operator;
	}

	public String getPurchaserCellPhone() {
		return purchaserCellPhone;
	}

	public void setPurchaserCellPhone(String purchaserCellPhone) {
		this.purchaserCellPhone = purchaserCellPhone;
	}

	public String getRefereeCellPhone() {
		return refereeCellPhone;
	}

	public void setRefereeCellPhone(String refereeCellPhone) {
		this.refereeCellPhone = refereeCellPhone;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}

	public String getBonusReason()
	{
		return bonusReason;
	}

	public void setBonusReason(String bonusReason)
	{
		this.bonusReason = bonusReason;
	}
	
}
