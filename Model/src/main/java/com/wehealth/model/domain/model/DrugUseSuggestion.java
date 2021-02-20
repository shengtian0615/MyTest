package com.wehealth.model.domain.model;

import java.io.Serializable;
import java.util.Date;

public class DrugUseSuggestion implements Serializable {
	private long id;
	private String clientId;
	private int version;
	private String drugUseText;
	private Date createTime;
	private Date updateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getDrugUseText() {
		return drugUseText;
	}

	public void setDrugUseText(String drugUseText) {
		this.drugUseText = drugUseText;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
