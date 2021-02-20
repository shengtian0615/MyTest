package com.wehealth.model.domain.enumutil;


import com.wehealth.model.domain.interfaceutil.NamedObject;

public enum HHGiftCardTransacStatus implements NamedObject
{
	pendingGift("转赠等待接受"),
	giftAccepted("赠品已接受"),
	giftRejected("赠品被拒收"),
	expired("赠品过期"),
	;
	
	private String text;
	
	private HHGiftCardTransacStatus(String text)
	{
		this.text = text;
	}

	@Override
	public String getText()
	{
		return text;
	}
	
	public static HHGiftCardTransacStatus getStatus(String value)
	{
		HHGiftCardTransacStatus status = null;
		try
		{
			status = HHGiftCardTransacStatus.valueOf(value);
		}
		catch(Exception ex)
		{
		}
		return status;
	}
}
