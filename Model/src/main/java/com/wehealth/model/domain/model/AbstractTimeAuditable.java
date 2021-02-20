/**
 * Copyright (C) 2014-2015 5WeHealth Technologies. All rights reserved.
 *  
 *    @author: Jingtao Yun May 31, 2016
 */

package com.wehealth.model.domain.model;

import com.wehealth.model.domain.interfaceutil.TimeAuditable;

import java.util.Date;

/**
 * 可填充时间的抽象基类
 */
public class AbstractTimeAuditable implements TimeAuditable
{
	private Date createTime;
	private Date updateTime;

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}
}
