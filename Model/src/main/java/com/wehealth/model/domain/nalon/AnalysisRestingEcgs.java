package com.wehealth.model.domain.nalon;

import java.util.List;

public class AnalysisRestingEcgs {

	private int diagnoseResultLevel;
	private MeasuredValue measuredValue;
	private List<BeatInfo> beatInfos;
	private List<DiagnoseResult> diagnoseResults;
	
	
	public int getDiagnoseResultLevel() {
		return diagnoseResultLevel;
	}
	public void setDiagnoseResultLevel(int diagnoseResultLevel) {
		this.diagnoseResultLevel = diagnoseResultLevel;
	}
	public MeasuredValue getMeasuredValue() {
		return measuredValue;
	}
	public void setMeasuredValue(MeasuredValue measuredValue) {
		this.measuredValue = measuredValue;
	}
	public List<BeatInfo> getBeatInfos() {
		return beatInfos;
	}
	public void setBeatInfos(List<BeatInfo> beatInfos) {
		this.beatInfos = beatInfos;
	}
	public List<DiagnoseResult> getDiagnoseResults() {
		return diagnoseResults;
	}
	public void setDiagnoseResults(List<DiagnoseResult> diagnoseResults) {
		this.diagnoseResults = diagnoseResults;
	}

}
