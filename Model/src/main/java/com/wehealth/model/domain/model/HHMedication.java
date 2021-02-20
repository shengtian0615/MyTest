package com.wehealth.model.domain.model;

import java.io.Serializable;

public class HHMedication implements Serializable {
	private Long id;
	private int count;
	private String name; // "阿司匹林",
	private String remark; // "一天一次",
	private boolean rx; // false,
	private String unit; // "盒"

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isRx() {
		return rx;
	}

	public void setRx(boolean rx) {
		this.rx = rx;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
