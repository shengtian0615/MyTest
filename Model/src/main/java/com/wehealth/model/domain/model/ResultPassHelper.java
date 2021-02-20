/**
 * Copyright (C) 2014-2015 5WeHealth Technologies. All rights reserved.
 *  
 *    @author: Jingtao Yun Jul 23, 2015
 */

package com.wehealth.model.domain.model;

public class ResultPassHelper {
	private String name;
	private String value;

	public ResultPassHelper(){	}

	public ResultPassHelper(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public ResultPassHelper(Object name, Object value) {
		if(name != null)
			setName(String.valueOf(name));
		if(value != null)
			setValue(String.valueOf(value));
	}

	public ResultPassHelper setProps(String name, String value) {
		this.name = name;
		this.value = value;
		return this;
	}

	public ResultPassHelper onlyName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String toString() {
		return "name=" + name + "&result=" + value;
	}
}
