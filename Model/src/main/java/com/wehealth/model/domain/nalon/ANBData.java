package com.wehealth.model.domain.nalon;

import java.util.List;

public class ANBData {

	private int Age;
	private int Gender;
	private String AcquisitionTime;
	private int SamplePerSecond;
	private float Avm;
	private List<String> LeadNameList;
	private boolean IsTimeOrder;
	private boolean IsBigEndian;
	private int DataTypeOfSample;
	private List<String> AutoDiagnosisCode;
	private List<String> AutoDiagnosisResult;
	private List<String> AutoDiagnosisDescription;
	private com.wehealth.model.domain.nalon.MeasurementValue MeasurementValue;
	
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public String getAcquisitionTime() {
		return AcquisitionTime;
	}
	public void setAcquisitionTime(String acquisitionTime) {
		AcquisitionTime = acquisitionTime;
	}
	public int getSamplePerSecond() {
		return SamplePerSecond;
	}
	public void setSamplePerSecond(int samplePerSecond) {
		SamplePerSecond = samplePerSecond;
	}
	public float getAvm() {
		return Avm;
	}
	public void setAvm(float avm) {
		Avm = avm;
	}
	public List<String> getLeadNameList() {
		return LeadNameList;
	}
	public void setLeadNameList(List<String> leadNameList) {
		LeadNameList = leadNameList;
	}
	public boolean isIsTimeOrder() {
		return IsTimeOrder;
	}
	public void setIsTimeOrder(boolean isTimeOrder) {
		IsTimeOrder = isTimeOrder;
	}
	public boolean isIsBigEndian() {
		return IsBigEndian;
	}
	public void setIsBigEndian(boolean isBigEndian) {
		IsBigEndian = isBigEndian;
	}
	public int getDataTypeOfSample() {
		return DataTypeOfSample;
	}
	public void setDataTypeOfSample(int dataTypeOfSample) {
		DataTypeOfSample = dataTypeOfSample;
	}
	public List<String> getAutoDiagnosisCode() {
		return AutoDiagnosisCode;
	}
	public void setAutoDiagnosisCode(List<String> autoDiagnosisCode) {
		AutoDiagnosisCode = autoDiagnosisCode;
	}
	public List<String> getAutoDiagnosisResult() {
		return AutoDiagnosisResult;
	}
	public void setAutoDiagnosisResult(List<String> autoDiagnosisResult) {
		AutoDiagnosisResult = autoDiagnosisResult;
	}
	public List<String> getAutoDiagnosisDescription() {
		return AutoDiagnosisDescription;
	}
	public void setAutoDiagnosisDescription(List<String> autoDiagnosisDescription) {
		AutoDiagnosisDescription = autoDiagnosisDescription;
	}
	public com.wehealth.model.domain.nalon.MeasurementValue getMeasurementValue() {
		return MeasurementValue;
	}
	public void setMeasurementValue(com.wehealth.model.domain.nalon.MeasurementValue measurementValue) {
		MeasurementValue = measurementValue;
	}	
}
