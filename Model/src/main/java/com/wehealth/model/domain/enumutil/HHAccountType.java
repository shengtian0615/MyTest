package com.wehealth.model.domain.enumutil;


import com.wehealth.model.domain.interfaceutil.NamedObject;

public enum HHAccountType implements NamedObject
{
	dtp("DTP", 100),
	yuanyuan("圆圆视频医生", 101);
	
	private String text;
	private int value;
	
	private HHAccountType(String text, int value)
	{
		this.text = text;
		this.value = value;
	}
	
	
	@Override
	public String getText()
	{
		return text;
	}
	
	public static HHAccountType getType(String type)
	{
		try
		{
			return HHAccountType.valueOf(type);
		}
		catch(Exception ex)
		{
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
