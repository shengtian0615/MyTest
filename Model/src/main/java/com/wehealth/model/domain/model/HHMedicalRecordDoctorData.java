package com.wehealth.model.domain.model;

import java.io.Serializable;

public class HHMedicalRecordDoctorData implements Serializable {
	private String dept; // "病理科",
	private String doctorId; // HH doctor id "D2017081615094714624",
	private String name; // "家庭医生a"

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
