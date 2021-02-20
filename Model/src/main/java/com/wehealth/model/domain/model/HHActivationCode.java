package com.wehealth.model.domain.model;

import com.wehealth.model.domain.enumutil.HHActivationCodeStatus;
import com.wehealth.model.domain.interfaceutil.Entity;

public class HHActivationCode extends AbstractTimeAuditable implements Entity {
	private Long id;
	private String actCode;
	private String usedBy;   // user's id
	private String note;
	private HHActivationCodeStatus status;
	private String purchaserPhone;
	private String purchaserName;
	
	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getActCode() {
		return actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode;
	}

	public String getUsedBy() {
		return usedBy;
	}

	public void setUsedBy(String usedBy) {
		this.usedBy = usedBy;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public HHActivationCodeStatus getStatus() {
		return status;
	}

	public void setStatus(HHActivationCodeStatus status) {
		this.status = status;
	}

	public String getPurchaserPhone() {
		return purchaserPhone;
	}

	public void setPurchaserPhone(String purchaserPhone) {
		this.purchaserPhone = purchaserPhone;
	}

	public String getPurchaserName() {
		return purchaserName;
	}

	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}

	
}
