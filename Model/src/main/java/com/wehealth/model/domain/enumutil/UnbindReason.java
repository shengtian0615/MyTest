/**
 * Copyright (C) 2014-2015 5WeHealth Technologies. All rights reserved.
 *  
 *    @author: Jingtao Yun Dec 21, 2015
 */

package com.wehealth.model.domain.enumutil;

import com.wehealth.model.domain.interfaceutil.NamedObject;

/**
 * 用户解绑设务原因
 * @author  Hongyu Wang
 */
public enum UnbindReason implements NamedObject
{
	user_dont_rent("用户不租了"), 
	user_change_device("用户更换设备"), 
	device_change_user("设备更换用户"), 
	device_broken("设备坏了"), 
	refund("退货"),
	no_reason("其他");

	private String reason;

	private UnbindReason(String reason)
	{
		this.reason = reason;
	}

	@Override
	public String getText()
	{
		return reason;
	}

	public static UnbindReason getReason(String value)
	{
		UnbindReason reason = null;
		try
		{
			reason = UnbindReason.valueOf(value);
		}
		catch (Exception ex)
		{
			// do nothing
		}
		return reason;
	}
}
