package com.wehealth.model.domain.model;

public class ThirdPartyCheckResult {
	private Long id;
	private Long ecgNo;
	private String diagnosis; // 诊断结论,
	private String reportMaintitle; // 报告医院名称,
	private String reportDoctorName; // 医生姓名
	private String reportDoctorId; // 医生ID
	private String reportDatetime; // 报告生成时间
	private byte[] docSignature;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEcgNo() {
		return ecgNo;
	}

	public void setEcgNo(Long ecgNo) {
		this.ecgNo = ecgNo;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getReportMaintitle() {
		return reportMaintitle;
	}

	public void setReportMaintitle(String reportMaintitle) {
		this.reportMaintitle = reportMaintitle;
	}

	public String getReportDoctorName() {
		return reportDoctorName;
	}

	public void setReportDoctorName(String reportDoctorName) {
		this.reportDoctorName = reportDoctorName;
	}

	public String getReportDoctorId() {
		return reportDoctorId;
	}

	public void setReportDoctorId(String reportDoctorId) {
		this.reportDoctorId = reportDoctorId;
	}

	public String getReportDatetime() {
		return reportDatetime;
	}

	public void setReportDatetime(String reportDatetime) {
		this.reportDatetime = reportDatetime;
	}

	public byte[] getDocSignature() {
		return docSignature;
	}

	public void setDocSignature(byte[] docSignature) {
		this.docSignature = docSignature;
	}

}
