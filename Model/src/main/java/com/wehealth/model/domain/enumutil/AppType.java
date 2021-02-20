/**
 * Copyright (C) 2014-2015 5WeHealth Technologies. All rights reserved.
 *
 *    @author: Jingtao Yun Jul 22, 2015
 */

package com.wehealth.model.domain.enumutil;

import com.wehealth.model.domain.interfaceutil.NamedObject;

public enum AppType implements NamedObject {
	doctorApp("安卓心电专家(医生)", "nOqjgCwVxoVX9Qfx"),// android doctor app
	patientApp("安卓找心电专家(病人)", "vGhzetbZjCmzgptR"),// android patient app
	patientMgt("病人随访系统(医生)", "r2dHfA8V9acHfSDD"), // patient management system
	patientMgtPst("病人随访系统(病人)", "va0j8Im1iPWYsYRS"), // patient management system
	iosDoctorApp("IOS心电专家(医生)", "2gQsAWndfLtE5Sqp"),// ios doctor app
	iosPatientApp("IOS找心电专家(病人)", "cQZNpVY1bGg8oTMf"),
	deviceApp("安卓测心电(家用)", "1p43B2dA1a7NvlQN"),
	deviceAppCus("安卓测心电(商用)", "q1ppu6JrDUXKjjpq"),
	iosDeviceApp("IOS测心电(家用)", "YfxWaahTgcE5n0uy"),
	iosDeviceAppCus("IOS测心电(商用)", "XIgYnnDB1NMKq6Ou"),
	hqxy("华清心仪", "KCrNcwl4qpQhPgCk"),
	oss("运维系统", "f2QIXdYOsUXnONx8"),

	anHeartChatUser("安卓爱心管家(用户)", "0K7739eCXcTJZHav"),
	iosHeartChatUser("IOS爱心管家(用户)", "My9mWisCbWlO9WKG"),
	anHeartChatDoc("安卓爱心医生(医生)", "nRsuwj4vH58VDL7b"),
	iosHeartChatDoc("IOS爱心医生(医生)", "bjxvJHaZf9fnuqLf"),
	anHeartChatAssist("安卓爱心助手(医助)", "PWGl3OEQUnj2QoTg"),
	iosHeartChatAssist("IOS爱心助手(医助)", "AqdFR2QafrgabWZn"),

	anWehealthClinic("安卓五维心康（诊所）", "VCOBcpzNBTTBiOZ3"),
	anInstantCadiac("安卓及时心电", "wcbDAxZgoh7Gv2vp"),
	iosInstantCadiac("IOS及时心电", "jUkS6OxWX4be2FbT"),
	anYYVideoDoctor("安卓圆圆视频医生", "UNa4PoTcZTT1rsNw"),
	iosYYVideoDoctor("IOS圆圆视频医生", "9nNc9kqnzPg0r496"),

	deviceAppTianjinWeijiwei("安卓测心电(天津卫计委)", "2IghPdlnLLgPwSvP"),
	deviceAppVideoDoctor("安卓测心电(视频医生)", "CWKJBMUN9fxUFsxU"),

	anBedsideECG("安卓床旁测心电", "Rd8Nmdi7qW2IEbkr"),
	;

	private String text;
	private String appKey;

	private AppType(String text, String appKey) {
		this.text = text;
	}

	@Override
	public String getText() {
		return text;
	}

	public static AppType getType(String type) {
		if (type == null || "".equals(type))
			return null;
		try {
			return AppType.valueOf(type);
		} catch (Exception ex) {
			return null;
		}
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
}
