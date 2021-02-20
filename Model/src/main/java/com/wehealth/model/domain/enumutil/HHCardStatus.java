package com.wehealth.model.domain.enumutil;

import com.wehealth.model.domain.interfaceutil.NamedObject;

public enum HHCardStatus implements NamedObject
{
	used("已使用"),
	unUsed("未使用"),
	locked("锁定")
	;
	
	private String text;
	
	private HHCardStatus(String text)
	{
		this.text = text;
	}

	@Override
	public String getText()
	{
		return text;
	}
	
	public static HHCardStatus getStatus(String value)
	{
		HHCardStatus status = null;
		try
		{
			status = HHCardStatus.valueOf(value);
		}
		catch(Exception ex)
		{
		}
		return status;
	}
}
