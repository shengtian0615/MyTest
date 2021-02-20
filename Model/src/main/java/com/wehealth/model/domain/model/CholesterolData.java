/**
 * Copyright (C) 2014-2015 5WeHealth Technologies. All rights reserved.
 */

package com.wehealth.model.domain.model;

import com.wehealth.model.domain.interfaceutil.TimeAuditable;

import java.io.Serializable;
import java.util.Date;

public class CholesterolData implements TimeAuditable, Serializable {
	private Long id;
	private Date createTime;
	private Date updateTime;
	//病人身份证号
	private String patientId;
	private float cholValue;  //mmol/L
	private String note;
	private Date testTime;
	private Long meId;
	private String agencyId;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getMeId() {
		return meId;
	}

	public void setMeId(Long meId) {
		this.meId = meId;
	}

	public String getPatientId()
	{
		return patientId;
	}

	public void setPatientId(String patientId)
	{
		this.patientId = patientId;
	}

	@Override
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	@Override
	public Date getCreateTime()
	{
		return createTime;
	}

	@Override
	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	@Override
	public Date getUpdateTime()
	{
		return updateTime;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Date getTestTime()
	{
		return testTime;
	}

	public void setTestTime(Date testTime)
	{
		this.testTime = testTime;
	}

	public float getCholValue() {
		return cholValue;
	}

	public void setCholValue(float cholValue) {
		this.cholValue = cholValue;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}
}
