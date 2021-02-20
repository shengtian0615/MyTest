package com.wehealth.model.domain.model;

import com.wehealth.model.domain.interfaceutil.Entity;

public class HHFamilyMember implements Entity {
	private Long id;
	private String hhUserToken;
	private String idCardNo; 
	private String hhPrimaryId;
	private String hhUuid;
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getHhUserToken() {
		return hhUserToken;
	}

	public void setHhUserToken(String hhUserToken) {
		this.hhUserToken = hhUserToken;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	
	public String getHhPrimaryId() {
		return hhPrimaryId;
	}

	public void setHhPrimaryId(String hhPrimaryId) {
		this.hhPrimaryId = hhPrimaryId;
	}

	public String getHhUuid() {
		return hhUuid;
	}

	public void setHhUuid(String hhUuid) {
		this.hhUuid = hhUuid;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;
		HHFamilyMember obj2 = (HHFamilyMember) obj;
		if(this.idCardNo.equals(obj2.getIdCardNo())) return true;
		return false;
	}
 
	public int hashCode() {
		int tmp = 0;
		tmp = (id + idCardNo).hashCode();
		return tmp;
	}

	
	
}