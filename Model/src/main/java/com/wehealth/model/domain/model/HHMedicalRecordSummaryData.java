package com.wehealth.model.domain.model;

import java.io.Serializable;
import java.util.Set;

public class HHMedicalRecordSummaryData implements Serializable {
	private String allergy;// "过敏史"
	private String diagnose; // "当前诊断",
	private String diseaseDescn; // "发热出现的时间n最高体温n孩子精神情况n是否伴有头痛、耳朵痛/揪耳朵、恶心、呕吐/喷射状n是否有持续性哭闹、腹泻、皮肤皮疹及出血点、惊厥等症状n自行用药情况，用药后体温下降情况n食物及药物过敏史n预防接种史n出牙情况----现病史",
	private String famHis; // "家族史",
	private String mainSuit; // "发烧两天--主诉",
	private HHMedicalRecordDoctorData medicalRecordDoctorData;
	private Set<HHMedication> medications;
	private String pastHis; //"既往史",
	private String restSuggest; // "休息建议",
	private String summary; // "1、体温＜38.5，宝宝精神饮食良好情况，可观察多喝水密切监测及精神情况保证入量即可。n2、体温≥38.5可考虑口服退热药物对乙酰氨基酚干混悬剂（草莓味）和布洛芬混悬剂（甜橙味）具体剂量如下:n3、如出现持续高热不退，反复惊厥，精神萎靡嗜睡等情况建议立即就诊。---总结",
	private String tags; // "感冒"

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getDiseaseDescn() {
		return diseaseDescn;
	}

	public void setDiseaseDescn(String diseaseDescn) {
		this.diseaseDescn = diseaseDescn;
	}

	public String getFamHis() {
		return famHis;
	}

	public void setFamHis(String famHis) {
		this.famHis = famHis;
	}

	public String getMainSuit() {
		return mainSuit;
	}

	public void setMainSuit(String mainSuit) {
		this.mainSuit = mainSuit;
	}

	public HHMedicalRecordDoctorData getMedicalRecordDoctorData() {
		return medicalRecordDoctorData;
	}

	public void setMedicalRecordDoctorData(
			HHMedicalRecordDoctorData medicalRecordDoctorData) {
		this.medicalRecordDoctorData = medicalRecordDoctorData;
	}

	public Set<HHMedication> getMedications() {
		return medications;
	}

	public void setMedications(Set<HHMedication> medications) {
		this.medications = medications;
	}

	public String getPastHis() {
		return pastHis;
	}

	public void setPastHis(String pastHis) {
		this.pastHis = pastHis;
	}

	public String getRestSuggest() {
		return restSuggest;
	}

	public void setRestSuggest(String restSuggest) {
		this.restSuggest = restSuggest;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	
}
