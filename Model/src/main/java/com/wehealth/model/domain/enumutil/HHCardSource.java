package com.wehealth.model.domain.enumutil;

import com.wehealth.model.domain.interfaceutil.NamedObject;

public enum HHCardSource implements NamedObject
{
	purchase("购买"),
	gift("转赠"),
	referral("推荐奖励");
	
	private String text;
	
	private HHCardSource(String text)
	{
		this.text = text;
	}
	
	
	@Override
	public String getText() 	
	{
		return text;
	}
	
	public static HHCardSource getType(String type)
	{
		try
		{
			return HHCardSource.valueOf(type);
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	
}
