package com.wehealth.model.domain.enumutil;

import com.wehealth.model.domain.interfaceutil.NamedObject;

public enum HHPackageType implements NamedObject {
	season("季卡", 101),
	annual("年卡", 100);
	
	private String text;
	private int value;
	
	private HHPackageType(String text, int value) {
		this.text = text;
		this.value = value;
	}
	
	
	@Override
	public String getText()
	{
		return text;
	}
	
	public static HHPackageType getType(String type) {
		try {
			return HHPackageType.valueOf(type);
		}catch(Exception ex) {
			return null;
		}
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}
	
	
}
