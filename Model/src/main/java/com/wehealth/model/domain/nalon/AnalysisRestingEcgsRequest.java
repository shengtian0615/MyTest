package com.wehealth.model.domain.nalon;

public class AnalysisRestingEcgsRequest {

	private String key;
	private String fileUrl;
	private int fileFormatType;
	private AnalysisRestingEcgsRequestPatient patient;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public int getFileFormatType() {
		return fileFormatType;
	}
	public void setFileFormatType(int fileFormatType) {
		this.fileFormatType = fileFormatType;
	}

	public AnalysisRestingEcgsRequestPatient getPatient() {
		return patient;
	}

	public void setPatient(AnalysisRestingEcgsRequestPatient patient) {
		this.patient = patient;
	}
}
