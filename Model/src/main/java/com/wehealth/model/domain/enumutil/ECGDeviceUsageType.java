/**
 * Copyright (C) 2014-2015 5WeHealth Technologies. All rights reserved.
 *  
 *    @author: Jingtao Yun Apr 29, 2016
 */

package com.wehealth.model.domain.enumutil;


import com.wehealth.model.domain.interfaceutil.NamedObject;

/**
 * 设备生命周期状态
 * 
 */
public enum ECGDeviceUsageType implements NamedObject {
	demo("样机"), terminal("终端"), ;

	private String text;

	private ECGDeviceUsageType(String text) {
		this.text = text;
	}

	@Override
	public String getText() {
		return text;
	}

	public static ECGDeviceUsageType getStatus(String value) {
		ECGDeviceUsageType status = null;
		try {
			status = ECGDeviceUsageType.valueOf(value);
		} catch (Exception ex) {
		}
		return status;
	}
}
