/**
 * Copyright (C) 2014-2015 5WeHealth Technologies. All rights reserved.
 *  
 *    @author: Jingtao Yun Apr 26, 2016
 */

package com.wehealth.model.domain.model;

import com.wehealth.model.domain.enumutil.SettingType;
import com.wehealth.model.domain.interfaceutil.TimeAuditable;

import java.util.Date;

/**
 * 系统设置记录
 *
 */
public class AgencySetting implements TimeAuditable {
	private Long id;
	private String shortName;
	private String displayName;
	private SettingType type;// value的值类型
	private String value;
	private boolean enable;
	private String note;
	private Date createTime;
	private Date updateTime;
	private String clientId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public SettingType getType() {
		return type;
	}

	public void setType(SettingType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((shortName == null) ? 0 : shortName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgencySetting other = (AgencySetting) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shortName == null) {
			if (other.shortName != null)
				return false;
		} else if (!shortName.equals(other.shortName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Setting [id=" + id + ", clientId=" + clientId + ", shortName=" + shortName
				+ ", displayName=" + displayName + ", type=" + type
				+ ", value=" + value + ", enable=" + enable + ", note=" + note
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}

}
