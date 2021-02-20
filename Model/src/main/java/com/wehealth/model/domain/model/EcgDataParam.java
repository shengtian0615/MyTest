package com.wehealth.model.domain.model;

import java.util.Date;

public class EcgDataParam {

	private String AnalysisState;
	private String PWidth;
	private String PExist;
	private String RRInterval;
	private String HeartRate;
	private String PRInterval;
	private String QRSDuration;
	private String QTD;
	private String QTC;
	private String PAxis;
	private String QRSAxis;
	private String TAxis;
	private String RV5SV1;
	private String RV5;
	private String SV1;
	private String FNotch;
	private String FHP;
	private String FLP;
	private String WaveQuality;
	private String autoDiagnosisResult;
	private String manulDiagnosisResult;
	private String gender;
	private String Age;
	private String name;
	private Date tesTime;
	private int version;
	private int score;
	private String phone;
	private String patId;
	private int requestedDiagnosisType;
	private String registerId;
	private String serialNo;

	private short[] i;
	private short[] ii;
	private short[] iii;
	private short[] avR;
	private short[] avL;
	private short[] avF;
	private short[] v1;
	private short[] v2;
	private short[] v3;
	private short[] v4;
	private short[] v5;
	private short[] v6;

	private int [] intI;
	private int [] intII;
	private int [] intIII;
	private int [] intAvr;
	private int [] intAvl;
	private int [] intAvf;
	private int [] intV1;
	private int[] intV2;
	private int[] intV3;
	private int[] intV4;
	private int[] intV5;
	private int[] intV6;

	public int[] getIntI() {
		return intI;
	}

	public void setIntI(int[] intI) {
		this.intI = intI;
	}

	public int[] getIntII() {
		return intII;
	}

	public void setIntII(int[] intII) {
		this.intII = intII;
	}

	public int[] getIntIII() {
		return intIII;
	}

	public void setIntIII(int[] intIII) {
		this.intIII = intIII;
	}

	public int[] getIntAvr() {
		return intAvr;
	}

	public void setIntAvr(int[] intAvr) {
		this.intAvr = intAvr;
	}

	public int[] getIntAvl() {
		return intAvl;
	}

	public void setIntAvl(int[] intAvl) {
		this.intAvl = intAvl;
	}

	public int[] getIntAvf() {
		return intAvf;
	}

	public void setIntAvf(int[] intAvf) {
		this.intAvf = intAvf;
	}

	public int[] getIntV1() {
		return intV1;
	}

	public void setIntV1(int[] intV1) {
		this.intV1 = intV1;
	}

	public int[] getIntV2() {
		return intV2;
	}

	public void setIntV2(int[] intV2) {
		this.intV2 = intV2;
	}

	public int[] getIntV3() {
		return intV3;
	}

	public void setIntV3(int[] intV3) {
		this.intV3 = intV3;
	}

	public int[] getIntV4() {
		return intV4;
	}

	public void setIntV4(int[] intV4) {
		this.intV4 = intV4;
	}

	public int[] getIntV5() {
		return intV5;
	}

	public void setIntV5(int[] intV5) {
		this.intV5 = intV5;
	}

	public int[] getIntV6() {
		return intV6;
	}

	public void setIntV6(int[] intV6) {
		this.intV6 = intV6;
	}

	public String getAnalysisState() {
		return AnalysisState;
	}
	public void setAnalysisState(String analysisState) {
		AnalysisState = analysisState;
	}
	public String getPWidth() {
		return PWidth;
	}
	public void setPWidth(String pWidth) {
		PWidth = pWidth;
	}
	public String getPExist() {
		return PExist;
	}
	public void setPExist(String pExist) {
		PExist = pExist;
	}
	public String getRRInterval() {
		return RRInterval;
	}
	public void setRRInterval(String rRInterval) {
		RRInterval = rRInterval;
	}
	public String getHeartRate() {
		return HeartRate;
	}
	public void setHeartRate(String heartRate) {
		HeartRate = heartRate;
	}
	public String getPRInterval() {
		return PRInterval;
	}
	public void setPRInterval(String pRInterval) {
		PRInterval = pRInterval;
	}
	public String getQRSDuration() {
		return QRSDuration;
	}
	public void setQRSDuration(String qRSDuration) {
		QRSDuration = qRSDuration;
	}
	public String getQTD() {
		return QTD;
	}
	public void setQTD(String qTD) {
		QTD = qTD;
	}
	public String getQTC() {
		return QTC;
	}
	public void setQTC(String qTC) {
		QTC = qTC;
	}
	public String getPAxis() {
		return PAxis;
	}
	public void setPAxis(String pAxis) {
		PAxis = pAxis;
	}
	public String getQRSAxis() {
		return QRSAxis;
	}
	public void setQRSAxis(String qRSAxis) {
		QRSAxis = qRSAxis;
	}
	public String getTAxis() {
		return TAxis;
	}
	public void setTAxis(String tAxis) {
		TAxis = tAxis;
	}
	public String getRV5SV1() {
		return RV5SV1;
	}
	public void setRV5SV1(String rV5SV1) {
		RV5SV1 = rV5SV1;
	}
	public String getRV5() {
		return RV5;
	}
	public void setRV5(String rV5) {
		RV5 = rV5;
	}
	public String getSV1() {
		return SV1;
	}
	public void setSV1(String sV1) {
		SV1 = sV1;
	}
	public String getFHP() {
		return FHP;
	}
	public void setFHP(String fHP) {
		FHP = fHP;
	}
	public String getFLP() {
		return FLP;
	}
	public void setFLP(String fLP) {
		FLP = fLP;
	}
	public String getWaveQuality() {
		return WaveQuality;
	}
	public void setWaveQuality(String waveQuality) {
		WaveQuality = waveQuality;
	}
	public String getAutoDiagnosisResult() {
		return autoDiagnosisResult;
	}
	public void setAutoDiagnosisResult(String autoDiagnosisResult) {
		this.autoDiagnosisResult = autoDiagnosisResult;
	}

	public String getManulDiagnosisResult() {
		return manulDiagnosisResult;
	}

	public void setManulDiagnosisResult(String manulDiagnosisResult) {
		this.manulDiagnosisResult = manulDiagnosisResult;
	}

	public Date getTesTime() {
		return tesTime;
	}
	public void setTesTime(Date tesTime) {
		this.tesTime = tesTime;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public short[] getI() {
		return i;
	}
	public void setI(short[] i) {
		this.i = i;
	}
	public short[] getIi() {
		return ii;
	}
	public void setIi(short[] ii) {
		this.ii = ii;
	}
	public short[] getIii() {
		return iii;
	}
	public void setIii(short[] iii) {
		this.iii = iii;
	}
	public short[] getAvR() {
		return avR;
	}
	public void setAvR(short[] avR) {
		this.avR = avR;
	}
	public short[] getAvL() {
		return avL;
	}
	public void setAvL(short[] avL) {
		this.avL = avL;
	}
	public short[] getAvF() {
		return avF;
	}
	public void setAvF(short[] avF) {
		this.avF = avF;
	}
	public short[] getV1() {
		return v1;
	}
	public void setV1(short[] v1) {
		this.v1 = v1;
	}
	public short[] getV2() {
		return v2;
	}
	public void setV2(short[] v2) {
		this.v2 = v2;
	}
	public short[] getV3() {
		return v3;
	}
	public void setV3(short[] v3) {
		this.v3 = v3;
	}
	public short[] getV4() {
		return v4;
	}
	public void setV4(short[] v4) {
		this.v4 = v4;
	}
	public short[] getV5() {
		return v5;
	}
	public void setV5(short[] v5) {
		this.v5 = v5;
	}
	public short[] getV6() {
		return v6;
	}
	public void setV6(short[] v6) {
		this.v6 = v6;
	}
	public String getFNotch() {
		return FNotch;
	}
	public void setFNotch(String fNotch) {
		FNotch = fNotch;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPatId() {
		return patId;
	}

	public void setPatId(String patId) {
		this.patId = patId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRequestedDiagnosisType() {
		return requestedDiagnosisType;
	}

	public void setRequestedDiagnosisType(int requestedDiagnosisType) {
		this.requestedDiagnosisType = requestedDiagnosisType;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
}
