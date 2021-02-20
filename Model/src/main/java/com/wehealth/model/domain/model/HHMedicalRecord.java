package com.wehealth.model.domain.model;

import com.wehealth.model.domain.interfaceutil.Entity;

import java.io.Serializable;

public class HHMedicalRecord implements Entity, Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long createTime;  //和和缓一致， 和缓的创建时间同时也是medical record id
	private HHMedicalRecordSummaryData medicRecordSummaryData;
	private String patientName;  
	private String hhUserToken; //和缓 中病人userToken
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public Long getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Long createTime)
	{
		this.createTime = createTime;
	}

	public HHMedicalRecordSummaryData getMedicRecordSummaryData() {
		return medicRecordSummaryData;
	}

	public void setMedicRecordSummaryData(
			HHMedicalRecordSummaryData medicRecordSummaryData) {
		this.medicRecordSummaryData = medicRecordSummaryData;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getHhUserToken() {
		return hhUserToken;
	}

	public void setHhUserToken(String hhUserToken) {
		this.hhUserToken = hhUserToken;
	}
	
}
