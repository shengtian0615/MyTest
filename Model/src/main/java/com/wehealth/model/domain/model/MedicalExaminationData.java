/**
 * Copyright (C) 2014-2015 5WeHealth Technologies. All rights reserved.
 */

package com.wehealth.model.domain.model;

import com.wehealth.model.domain.enumutil.MedicalExamLevel;
import com.wehealth.model.domain.enumutil.MedicalExamState;
import com.wehealth.model.domain.interfaceutil.TimeAuditable;

import java.io.Serializable;
import java.util.Date;


public class MedicalExaminationData implements TimeAuditable, Serializable {
	private Long id;
	private Long localId;
	private Date createTime;
	private Date updateTime;
	//身份证号
	private String patientId;
	private String patiName;
	private int patiAge;
	private int patiGender;
	private String patiLocaId;

	private BloodPressure bloodPresure;
	private BloodSugar bloodGlucose;
	private BMIData bmi;
	private CholesterolData cho;
	private UricAcidData ua;
	private WHRData whr;
	private float bodyTemperature = 0 ;
	private BloodOxygenData sao2;
	private String note;
	private Date testTime;
	private long ecgId = -1;
	private MedicalExamState uploadState;
	private MedicalExamLevel meLevel;
	private String agencyId;

	public Long getLocalId() {
		return localId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	public MedicalExamState getUploadState() {
		return uploadState;
	}

	public void setUploadState(MedicalExamState uploadState) {
		this.uploadState = uploadState;
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

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getPatiLocaId() {
		return patiLocaId;
	}

	public void setPatiLocaId(String patiLocaId) {
		this.patiLocaId = patiLocaId;
	}

	public String getPatientId()
	{
		return patientId;
	}

	public void setPatientId(String patientId)
	{
		this.patientId = patientId;
	}

	public String getPatiName() {
		return patiName;
	}

	public void setPatiName(String patiName) {
		this.patiName = patiName;
	}

	public int getPatiAge() {
		return patiAge;
	}

	public void setPatiAge(int patiAge) {
		this.patiAge = patiAge;
	}

	public int getPatiGender() {
		return patiGender;
	}

	public void setPatiGender(int patiGender) {
		this.patiGender = patiGender;
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

	public BloodPressure getBloodPresure() {
		return bloodPresure;
	}

	public void setBloodPresure(BloodPressure bloodPresure) {
		this.bloodPresure = bloodPresure;
	}

	public BloodSugar getBloodGlucose() {
		return bloodGlucose;
	}

	public void setBloodGlucose(BloodSugar bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
	}

	public BMIData getBmi() {
		return bmi;
	}

	public void setBmi(BMIData bmi) {
		this.bmi = bmi;
	}

	public CholesterolData getCho() {
		return cho;
	}

	public void setCho(CholesterolData cho) {
		this.cho = cho;
	}

	public UricAcidData getUa() {
		return ua;
	}

	public void setUa(UricAcidData ua) {
		this.ua = ua;
	}

	public WHRData getWhr() {
		return whr;
	}

	public void setWhr(WHRData whr) {
		this.whr = whr;
	}

	public float getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(float bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public BloodOxygenData getSao2() {
		return sao2;
	}

	public void setSao2(BloodOxygenData sao2) {
		this.sao2 = sao2;
	}

	public long getEcgId() {
		return ecgId;
	}

	public void setEcgId(long ecgId) {
		this.ecgId = ecgId;
	}

	public MedicalExamLevel getMeLevel() {
		return meLevel;
	}

	public void setMeLevel(MedicalExamLevel meLevel) {
		this.meLevel = meLevel;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}
}
