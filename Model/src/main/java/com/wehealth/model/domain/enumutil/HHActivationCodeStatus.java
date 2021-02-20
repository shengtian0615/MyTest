package com.wehealth.model.domain.enumutil;

import com.wehealth.model.domain.interfaceutil.NamedObject;

public enum HHActivationCodeStatus implements NamedObject
{
	used("已使用"),
	unUsed("未使用"),
	;
	
	private String text;
	
	private HHActivationCodeStatus(String text)
	{
		this.text = text;
	}

	@Override
	public String getText()
	{
		return text;
	}
	
	public static HHActivationCodeStatus getStatus(String value)
	{
		HHActivationCodeStatus status = null;
		try
		{
			status = HHActivationCodeStatus.valueOf(value);
		}
		catch(Exception ex)
		{
		}
		return status;
	}
}
