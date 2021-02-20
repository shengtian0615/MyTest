package com.wehealth.model.util;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Xml;

import com.wehealth.model.domain.enumutil.ECGDataDiagnosisType;
import com.wehealth.model.domain.model.ECGData;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class FileUtil {

//	public static EcgDataParam docReportParseECGParam(String path){
//		EcgDataParam edp = null;
//		File file  = new File(path);
//		InputStream inputStream = null;
//		try {
//			inputStream = new FileInputStream(file);
//		}catch (FileNotFoundException e){
//			e.printStackTrace();
//			return null;
//		}
//		if (inputStream==null){
//			return edp;
//		}
//		ECGDataUtil.ECGDataResultHelper resultHelper = new ECGDataUtil.ECGDataResultHelper();
//		boolean isfirst = false;//判断是否是最后DMData里的心电数据
//		int version = 0;
//		try {
//			edp = new EcgDataParam();
//			XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();
//			XmlPullParser pullParser = pullFactory.newPullParser();
//			pullParser.setInput(inputStream, "UTF-8");
//			int eventType = pullParser.getEventType();
//			while (XmlPullParser.END_DOCUMENT != eventType) {
//				switch (eventType) {
//					case XmlPullParser.START_DOCUMENT:
//						break;
//					case XmlPullParser.START_TAG:
//						if ("ECG".equals(pullParser.getName())) {
//							edp.setFHP(pullParser.getAttributeValue(null, "FHP"));
//							edp.setFLP(pullParser.getAttributeValue(null, "FLP"));
//							edp.setFNotch(pullParser.getAttributeValue(null,"FNotch"));
//							String sampleRate = pullParser.getAttributeValue(null, "SAMPLERATE");
//							if (TextUtils.isEmpty(sampleRate)){
//								version = 1;
//							}
//						}
//						if ("ID".equals(pullParser.getName())){
//							String id = pullParser.nextText();
//							if (RegexUtil.phone(id)){
//								edp.setPhone(id);
//							}
//							if (IDCardValidator.isValidateIDCard(id)){
//								edp.setPatId(id);
//							}
//						}
//						if ("Name".equals(pullParser.getName())){
//							edp.setName(pullParser.nextText());
//						}
//						if ("Age".equals(pullParser.getName())) {
//							edp.setAge(pullParser.nextText());
//						}
//						if ("Gender".equals(pullParser.getName())) {
//							edp.setGender(pullParser.nextText());
//						}
//						if (version==0){
//							if ("DMData".equals(pullParser.getName())) {
//								isfirst = true;
//							}
//							if ("Ch0".equals(pullParser.getName()) && !isfirst) {// I
//								String Ch0_I= pullParser.nextText();
//								edp.setI(UnicodeStringtoByte.StringToByte(Ch0_I));
//							}
//							if ("Ch1".equals(pullParser.getName()) && !isfirst) {// II
//								String Ch1_II = pullParser.nextText();
//								edp.setIi(UnicodeStringtoByte.StringToByte(Ch1_II));
//							}
//							if ("Ch2".equals(pullParser.getName()) && !isfirst) {// III
//								String Ch2_III = pullParser.nextText();
//								edp.setIii(UnicodeStringtoByte.StringToByte(Ch2_III));
//							}
//							if ("Ch3".equals(pullParser.getName()) && !isfirst) {// avR
//								String Ch3_avR = pullParser.nextText();
//								edp.setAvR(UnicodeStringtoByte.StringToByte(Ch3_avR));
//							}
//							if ("Ch4".equals(pullParser.getName()) && !isfirst) {// avL
//								String Ch4_avL = pullParser.nextText();
//								edp.setAvL(UnicodeStringtoByte.StringToByte(Ch4_avL));
//							}
//							if ("Ch5".equals(pullParser.getName()) && !isfirst) {// avF
//								String Ch5_avF = pullParser.nextText();
//								edp.setAvF(UnicodeStringtoByte.StringToByte(Ch5_avF));
//							}
//							if ("Ch6".equals(pullParser.getName()) && !isfirst) {// v1
//								String Ch6_v1 = pullParser.nextText();
//								edp.setV1(UnicodeStringtoByte.StringToByte(Ch6_v1));
//							}
//							if ("Ch7".equals(pullParser.getName()) && !isfirst) {// v2
//								String Ch7_v2 = pullParser.nextText();
//								edp.setV2(UnicodeStringtoByte.StringToByte(Ch7_v2));
//							}
//							if ("Ch8".equals(pullParser.getName()) && !isfirst) {// v3
//								String Ch8_v3 = pullParser.nextText();
//								edp.setV3(UnicodeStringtoByte.StringToByte(Ch8_v3));
//							}
//							if ("Ch9".equals(pullParser.getName()) && !isfirst) {// v4
//								String Ch9_v4 = pullParser.nextText();
//								edp.setV4(UnicodeStringtoByte.StringToByte(Ch9_v4));
//							}
//							if ("Ch10".equals(pullParser.getName()) && !isfirst) {// v5
//								String Ch10_v5 = pullParser.nextText();
//								edp.setV5(UnicodeStringtoByte.StringToByte(Ch10_v5));
//							}
//							if ("Ch11".equals(pullParser.getName()) && !isfirst) {// v6
//								String Ch11_v6 = pullParser.nextText();
//								edp.setV6(UnicodeStringtoByte.StringToByte(Ch11_v6));
//							}
//							if ("Parameter".equals(pullParser.getName())) {
//								edp.setAnalysisState(pullParser.getAttributeValue(null, "AnalysisState"));
//								edp.setPWidth(pullParser.getAttributeValue(null, "PWidth"));
//								edp.setPExist(pullParser.getAttributeValue(null, "PExist"));
//								edp.setRRInterval(pullParser.getAttributeValue(null, "RRInterval"));
//								edp.setHeartRate(pullParser.getAttributeValue(null, "HeartRate"));
//								edp.setPRInterval(pullParser.getAttributeValue(null, "PRInterval"));
//								edp.setQRSDuration(pullParser.getAttributeValue(null, "QRSDuration"));
//								edp.setQTC(pullParser.getAttributeValue(null, "QTC"));
//								edp.setQTD(pullParser.getAttributeValue(null, "QTD"));
//								edp.setPAxis(pullParser.getAttributeValue(null, "PAxis"));
//								edp.setQRSAxis(pullParser.getAttributeValue(null, "QRSAxis"));
//								edp.setTAxis(pullParser.getAttributeValue(null, "TAxis"));
//								edp.setRV5SV1(pullParser.getAttributeValue(null, "RV5SV1"));
//								edp.setRV5(pullParser.getAttributeValue(null, "RV5"));
//								edp.setSV1(pullParser.getAttributeValue(null, "SV1"));
//							}
//						}else if (version==1){
//							if ("Ch0".equals(pullParser.getName())) {// I
//								String Ch0_I= pullParser.nextText();
//								int array[] = UnicodeStringtoByte.string2Int(Ch0_I);
//								edp.setIntI(array);
//							}
//							if ("Ch1".equals(pullParser.getName())) {// II
//								String Ch1_II = pullParser.nextText();
//								edp.setIntII(UnicodeStringtoByte.string2Int(Ch1_II));
//							}
//							if ("Ch2".equals(pullParser.getName())) {// III
//								String Ch2_III = pullParser.nextText();
//								edp.setIntIII(UnicodeStringtoByte.string2Int(Ch2_III));
//							}
//							if ("Ch3".equals(pullParser.getName())) {// avR
//								String Ch3_avR = pullParser.nextText();
//								edp.setIntAvr(UnicodeStringtoByte.string2Int(Ch3_avR));
//							}
//							if ("Ch4".equals(pullParser.getName())) {// avL
//								String Ch4_avL = pullParser.nextText();
//								edp.setIntAvl(UnicodeStringtoByte.string2Int(Ch4_avL));
//							}
//							if ("Ch5".equals(pullParser.getName())) {// avF
//								String Ch5_avF = pullParser.nextText();
//								edp.setIntAvf(UnicodeStringtoByte.string2Int(Ch5_avF));
//							}
//							if ("Ch6".equals(pullParser.getName())) {// v1
//								String Ch6_v1 = pullParser.nextText();
//								edp.setIntV1(UnicodeStringtoByte.string2Int(Ch6_v1));
//							}
//							if ("Ch7".equals(pullParser.getName())) {// v2
//								String Ch7_v2 = pullParser.nextText();
//								edp.setIntV2(UnicodeStringtoByte.string2Int(Ch7_v2));
//							}
//							if ("Ch8".equals(pullParser.getName())) {// v3
//								String Ch8_v3 = pullParser.nextText();
//								edp.setIntV3(UnicodeStringtoByte.string2Int(Ch8_v3));
//							}
//							if ("Ch9".equals(pullParser.getName())) {// v4
//								String Ch9_v4 = pullParser.nextText();
//								edp.setIntV4(UnicodeStringtoByte.string2Int(Ch9_v4));
//							}
//							if ("Ch10".equals(pullParser.getName())) {// v5
//								String Ch10_v5 = pullParser.nextText();
//								edp.setIntV5(UnicodeStringtoByte.string2Int(Ch10_v5));
//							}
//							if ("Ch11".equals(pullParser.getName())) {// v6
//								String Ch11_v6 = pullParser.nextText();
//								edp.setIntV6(UnicodeStringtoByte.string2Int(Ch11_v6));
//							}
//							if ("Parameter".equals(pullParser.getName())) {
//								edp.setHeartRate(pullParser.getAttributeValue(null, "HeartRate"));
//								edp.setPRInterval(pullParser.getAttributeValue(null, "PRInterval"));
//								edp.setQRSDuration(pullParser.getAttributeValue(null, "QRSDuration"));
//								edp.setQTC(pullParser.getAttributeValue(null, "QTC"));
//								edp.setQTD(pullParser.getAttributeValue(null, "QTD"));
//								edp.setPAxis(pullParser.getAttributeValue(null, "PAxis"));
//								edp.setQRSAxis(pullParser.getAttributeValue(null, "QRSAxis"));
//								edp.setTAxis(pullParser.getAttributeValue(null, "TAxis"));
//								edp.setRV5SV1(pullParser.getAttributeValue(null, "RV5SV1"));
//								edp.setRV5(pullParser.getAttributeValue(null, "RV5"));
//								edp.setSV1(pullParser.getAttributeValue(null, "SV1"));
//							}
//						}
//						if ("Classfly".equals(pullParser.getName())) {
//							String classCode = pullParser.getAttributeValue(null, "Code");
//							String className = pullParser.nextText();
//							resultHelper.getClassfy().put(classCode, className);
//						}
//						if ("Result".equals(pullParser.getName())) {
//							String resultCode = pullParser.getAttributeValue(null, "Code");
//							String resultName = pullParser.nextText();
//							resultHelper.getResult().put(resultCode, resultName);
//						}
//						break;
//					case XmlPullParser.END_TAG:
//						if (pullParser.getName().equals("ECG")) {
//							Log.i("FileScan", "解析完毕");
//						}
//						break;
//					default:
//						break;
//				}
//				eventType = pullParser.next();
//			}
//		}catch (XmlPullParserException | IOException e) {
//			e.printStackTrace();
//		} finally{
//			try {
//				inputStream.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		edp.setVersion(version);
//		String autoResult = ECGDataUtil.encodeResult(resultHelper);
//		edp.setAutoDiagnosisResult(autoResult);
//		return edp;
//	}

//	public static String readFDAXML(String fdaxmlPath) {
//		File file = new File(fdaxmlPath);
//		if(!file.exists()){
//			return null;
//		}
//		String str = null;
//		try {
//			FileInputStream inputStream = new FileInputStream(file);
//			int length = inputStream.available();
//			byte bytes[] = new byte[length];
//			inputStream.read(bytes);
//			inputStream.close();
//			str = new String(bytes, StandardCharsets.UTF_8);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return str;
//	}

//	/**
//	 * 获取结论的分级建议
//	 * @param context
//	 * @param
//	 * @return ResuPassHelper name：级别；value：建议
//	 */
//	public static ResultPassHelper obtainWarn2LevelMap(Context context, String result) {
//		ResultPassHelper rph = new ResultPassHelper();
//		InputStream is = null;
//		boolean is_replace = false;
//		if (result.contains("ST & T异常")) {
//			result = result.replace("ST & T异常", "");
//			is_replace = true;
//		}
//		try {
//			is = context.getAssets().open("ecgdata_th2_resultadvice.xml");
//			Map<String, String> map = parser2LevelAdvice(result, is);
//			if (map==null || map.isEmpty()) {
//				return null;
//			}
//			if (map.containsKey("三")) {//含有危险级别最高
//				rph.setName("三");
//				return rph;
//			}
//			if (map.containsKey("二")) {//含有危险级别次之
//				rph.setName("二");
//				return rph;
//			}
//			if (is_replace) {//不含有危险级别次之，但被替换了结论
//				rph.setName("二");
//				return rph;
//			}
//			if (map.containsKey("一")) {//正常心电图
//				rph.setName("一");
//				return rph;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}finally{
//			try {
//				if (is!=null) {
//					is.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}

//	/**
//	 * 解析文件
//	 * @param result 目标文件
//	 * @param is 流文件
//	 * @return Map<String, String>
//	 */
//	@SuppressLint("UseSparseArrays")
//	public static Map<String, String> parser2LevelAdvice(String result, InputStream is) {
//		Map<String, String> map = new HashMap<>();
//		try {
//			XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();
//			XmlPullParser pullParser = pullFactory.newPullParser();
//			pullParser.setInput(is, "UTF-8");
//			int eventType = pullParser.getEventType();
//			while (XmlPullParser.END_DOCUMENT != eventType) {
//				switch (eventType) {
//					case XmlPullParser.START_DOCUMENT:
//						break;
//					case XmlPullParser.START_TAG:
//						String[] r = result.split(" ");
//						for (int i = 0; i < r.length; i++) {
//							String name = pullParser.getAttributeValue(null, "name");
//							String level = pullParser.getAttributeValue(null, "level");
//							if (r[i].equals(name)) {
//								String strLevel = level;
//								map.put(strLevel, "");
//								break;
//							}
//						}
//						break;
//					case XmlPullParser.END_TAG:
//						break;
//					case XmlPullParser.END_DOCUMENT:
//						break;
//					default:
//						break;
//				}
//				eventType = pullParser.next();
//			}
//		} catch (XmlPullParserException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return map;
//	}

//	public static ResultPassHelper parse2LiBang(String data) {
//		ResultPassHelper result = new ResultPassHelper();
//		try {
//			XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();
//			XmlPullParser pullParser = pullFactory.newPullParser();
//			pullParser.setInput(new StringReader(data));
//			int eventType = pullParser.getEventType();
//			while (XmlPullParser.END_DOCUMENT != eventType) {
//				switch (eventType) {
//					case XmlPullParser.START_DOCUMENT:
//						break;
//					case XmlPullParser.START_TAG:
//						if ("DiagnosticMessage".equalsIgnoreCase(pullParser.getName())) {
//							result.setValue(pullParser.nextText());
//						}
//						if ("SeverityCode".equalsIgnoreCase(pullParser.getName())){
//							result.setName(pullParser.nextText());
//						}
////						String sc = pullParser.getName();
////						if (sc.equalsIgnoreCase("PostiveCritical")){
////							result.setStatus(3);
////						}else if (sc.equalsIgnoreCase("Normal")){
////							result.setStatus(1);
////						}else{
////							result.setStatus(2);
////						}
//						break;
//					case XmlPullParser.END_TAG:
//						if (pullParser.getName().equals("ECG")) {
//							Log.i("FileScan", "解析完毕");
//						}
//						break;
//					default:
//						break;
//				}
//				eventType = pullParser.next();
//			}
//		} catch (XmlPullParserException | IOException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	public static String saveFDAXML(Map<String, String> map){
//		String path = null;
//		String ecgSum;
//		try {
////            Map<String, String> pInfo = listMaps.get(Constant.ECG_PATIENT_INFO);
////            Map<String, String> ecgAttr = listMaps.get(Constant.ECG_ANALYSE_PARAM);
////            long timeLong = Long.valueOf(pInfo.get("ecg_checktime"));
////            String time = DateUtils.sdf_yyyyMMddHHmmss.format(new Date(timeLong));
//			File fileDir = new File(Environment.getExternalStorageDirectory()+"/ECGDATA/XML");
//			if (!fileDir.exists()) {
//				fileDir.mkdirs();
//			}
//			path = fileDir.getAbsolutePath() + File.separator + "abc" + ".xml";
//			String version = map.get("version");
//			if (version.equals("0")){
//				ecgSum = "1.075";
//			}else
//				ecgSum = "0.1075";
//			FileOutputStream fos = new FileOutputStream(path);
//			XmlSerializer serXML = Xml.newSerializer();
//			serXML.setOutput(fos, "UTF-8");
//			serXML.startDocument("UTF-8", true);
//			serXML.startTag(null, "AnnotatedECG");
//			serXML.attribute(null, "xmlns", "urn:hl7-org:v3");
//			serXML.attribute(null, "xmlns:voc", "urn:hl7-org:v3/voc");
//			serXML.attribute(null, "xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
//			serXML.attribute(null, "xsi:schemaLocation", "urn:hl7-org:v3 PORT_MT020001.xsd");
//			serXML.attribute(null, "type", "Observation");
//			serXML.attribute(null, "classCode", "OBS");
//			serXML.attribute(null, "moodCode", "EVN");
//			serXML.startTag(null, "id");
////			serXML.attribute(null, "root","1.201212100002.20190314.161057");
//			serXML.attribute(null, "extension","");
//			serXML.endTag(null,"id");
//			serXML.startTag(null, "effectiveTime");
//			serXML.startTag(null,"low");
//			serXML.attribute(null, "value",map.get("low"));
//			serXML.endTag(null, "low");
//			serXML.startTag(null,"high");
//			serXML.attribute(null, "value",map.get("high"));
//			serXML.endTag(null, "high");
//			serXML.endTag(null, "effectiveTime");
//			serXML.startTag(null, "componentOf");
//			serXML.startTag(null, "timepointEvent");
//			serXML.startTag(null, "componentOf");
//			serXML.startTag(null, "subjectAssignment");
//			serXML.startTag(null, "subject");
//			serXML.startTag(null, "trialSubject");
//			serXML.startTag(null, "id");
//			String id = map.get("ID");
//			if (TextUtils.isEmpty(id)){
//				id = "1.201212100002.20190314.161057";
//			}
//			serXML.attribute(null,"root",id);
//			serXML.endTag(null,"id");
//			serXML.startTag(null,"subjectDemographicPerson");
//			serXML.startTag(null,"name");
//			serXML.text(map.get("Name"));
//			serXML.endTag(null,"name");
//			serXML.startTag(null,"administrativeGenderCode");
//			serXML.attribute(null,"code", map.get("Gender"));
//			serXML.attribute(null,"codeSystem","2.16.840.1.113883.5.1");
//			serXML.attribute(null,"codeSystemName","AdministrativeGender");
//			serXML.endTag(null,"administrativeGenderCode");
//			serXML.startTag(null,"birthTime");
//			serXML.attribute(null,"value",map.get("Age"));
//			serXML.endTag(null,"birthTime");
//			serXML.endTag(null,"subjectDemographicPerson");
//			serXML.endTag(null,"trialSubject");
//			serXML.endTag(null, "subject");
//			serXML.startTag(null,"componentOf");
//			serXML.startTag(null,"clinicalTrial");
//			serXML.startTag(null,"id");
//			serXML.attribute(null,"root","1.201212100002.20190314.161057");
//			serXML.attribute(null, "extension","");
//			serXML.endTag(null,"id");
//			serXML.startTag(null,"location");
//			serXML.startTag(null,"trialSite");
//			serXML.startTag(null,"id");
//			serXML.attribute(null,"root","2.16.840.1.113883.3.400");
//			serXML.attribute(null, "extension","");
//			serXML.endTag(null,"id");
//			serXML.startTag(null,"responsibleParty");
//			serXML.startTag(null,"trialInvestigator");
//			serXML.startTag(null,"id");
//			serXML.attribute(null,"root","2.16.840.1.113883.3.400");
//			serXML.attribute(null, "extension","");
//			serXML.endTag(null,"id");
//			serXML.endTag(null,"trialInvestigator");
//			serXML.endTag(null,"responsibleParty");
//			serXML.endTag(null, "trialSite");
//			serXML.endTag(null,"location");
//			serXML.endTag(null, "clinicalTrial");
//			serXML.endTag(null,"componentOf");
//			serXML.endTag(null,"subjectAssignment");
//			serXML.endTag(null,"componentOf");
//			serXML.endTag(null,"timepointEvent");
//			serXML.endTag(null,"componentOf");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"series");
//			serXML.startTag(null,"author");
//			serXML.startTag(null,"seriesAuthor");
//			serXML.startTag(null,"manufacturedSeriesDevice");
//			serXML.startTag(null,"serialNumber");
//			serXML.text(map.get("serialNo"));
//			serXML.endTag(null,"serialNumber");
//			serXML.startTag(null,"manufacturerModelName");
//			serXML.text("C-12");
//			serXML.endTag(null,"manufacturerModelName");
//			serXML.endTag(null,"manufacturedSeriesDevice");
//			serXML.endTag(null,"seriesAuthor");
//			serXML.endTag(null,"author");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","RHYTHM");
//			serXML.attribute(null,"codeSystem","2.16.840.1.113883.5.4");
//			serXML.attribute(null,"codeSystemName","ActCode");
//			serXML.attribute(null,"displayName","");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"effectiveTime");
//			serXML.startTag(null,"low");
//			serXML.attribute(null,"value", map.get("low"));
//			serXML.endTag(null,"low");
//			serXML.startTag(null,"high");
//			serXML.attribute(null,"value", map.get("high"));
//			serXML.endTag(null,"high");
//			serXML.endTag(null,"effectiveTime");
//			serXML.startTag(null,"controlVariable");
//			serXML.startTag(null,"controlVariable");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_CTL_VBL_ATTR_FILTER_LOW_PASS");
//			serXML.attribute(null,"codeSystem","2.16.840.1.113883.6.24");
//			serXML.attribute(null,"codeSystemName","MDC");
//			serXML.attribute(null,"displayName","Low pass filter");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","PQ");
//			String FilterLP = map.get("FilterLP");
//			if (TextUtils.isEmpty(FilterLP)){
//				FilterLP="-";
//			}else{
//				FilterLP = FilterLP.replace("Hz","");
//			}
//			serXML.attribute(null,"value",FilterLP);
//			serXML.attribute(null,"unit","Hz");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"controlVariable");
//			serXML.endTag(null,"controlVariable");
//
//			serXML.startTag(null,"controlVariable");
//			serXML.startTag(null,"controlVariable");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_CTL_VBL_ATTR_FILTER_HIGH_PASS");
//			serXML.attribute(null,"codeSystem","2.16.840.1.113883.6.24");
//			serXML.attribute(null,"codeSystemName","MDC");
//			serXML.attribute(null,"displayName","High pass filter");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","PQ");
//			String FilterBase = map.get("FilterBase");
//			if (TextUtils.isEmpty(FilterBase)){
//				FilterBase = "-";
//			}else{
//				FilterBase = FilterBase.replace("Hz","");
//			}
//			serXML.attribute(null,"value",FilterBase);
//			serXML.attribute(null,"unit","Hz");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"controlVariable");
//			serXML.endTag(null,"controlVariable");
//
//			serXML.startTag(null,"controlVariable");
//			serXML.startTag(null,"controlVariable");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_CTL_VBL_ATTR_FILTER_NOTCH");
//			serXML.attribute(null,"codeSystem","2.16.840.1.113883.6.24");
//			serXML.attribute(null,"codeSystemName","MDC");
//			serXML.attribute(null,"displayName","Notch filter");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","PQ");
//			String FNotch = map.get("FNotch");
//			if (TextUtils.isEmpty(FNotch)){
//				FNotch = "-";
//			}else{
//				FNotch = FNotch.replace("Hz","");
//			}
//			serXML.attribute(null,"value",FNotch);
//			serXML.attribute(null,"unit","Hz");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"controlVariable");
//			serXML.endTag(null,"controlVariable");
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequenceSet");
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","TIME_ABSOLUTE");
//			serXML.attribute(null,"codeSystem","2.16.840.1.113883.5.4");
//			serXML.attribute(null,"codeSystemName","ActCode");
//			serXML.attribute(null,"displayName","");
//			serXML.endTag(null, "code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","GLIST_TS");
//			serXML.startTag(null,"head");
//			serXML.attribute(null,"value", map.get("low"));
//			serXML.endTag(null,"head");
//			serXML.startTag(null,"increment");
//			serXML.attribute(null,"value","0.002");
//			serXML.attribute(null,"unit","s");
//			serXML.endTag(null,"increment");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_I");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");// i 导数据
//			serXML.text(map.get("Ch0"));
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_II");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");// ii 导数据
//			serXML.text(map.get("Ch1"));
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_III");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");// iii 导数据
//			serXML.text(map.get("Ch2"));
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_AVR");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");
//			serXML.text(map.get("Ch3"));// AVR 导数据
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_AVL");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");
//			serXML.text(map.get("Ch4"));// AVL 导数据
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_AVF");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");
//			serXML.text(map.get("Ch5"));// AVF 导数据
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_V1");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");
//			serXML.text(map.get("Ch6"));// V1 导数据
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_V2");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");
//			serXML.text(map.get("Ch7"));// V2 导数据
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_V3");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");
//			serXML.text(map.get("Ch8"));// V3 导数据
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_V4");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");
//			serXML.text(map.get("Ch9"));// V4 导数据
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_V5");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");
//			serXML.text(map.get("Ch10"));// V5 导数据
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequence");
//			serXML.startTag(null,"code");
//			serXML.attribute(null,"code","MDC_ECG_LEAD_V6");
//			serXML.endTag(null,"code");
//			serXML.startTag(null,"value");
//			serXML.attribute(null,"xsi:type","SLIST_PQ");
//			serXML.startTag(null,"origin");
//			serXML.attribute(null,"value","0");
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"origin");
//			serXML.startTag(null,"scale");
//			serXML.attribute(null,"value",ecgSum);
//			serXML.attribute(null,"unit","uV");
//			serXML.endTag(null,"scale");
//			serXML.startTag(null,"digits");
//			serXML.text(map.get("Ch11"));// V6 导数据
//			serXML.endTag(null,"digits");
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"sequence");
//			serXML.endTag(null,"component");
//
//			serXML.endTag(null,"sequenceSet");
//			serXML.endTag(null,"component");
//			serXML.startTag(null,"derivation");
//			serXML.startTag(null,"derivedSeries");
//			serXML.startTag(null,"Code");
//			//
//			serXML.endTag(null,"Code");
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"sequenceSet");
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"Sequence");
//			serXML.startTag(null,"Code");
//			//
//			serXML.endTag(null,"Code");
//			serXML.startTag(null,"value");
//			//
//			serXML.endTag(null,"value");
//			serXML.endTag(null,"Sequence");
//			serXML.endTag(null,"component");
//			serXML.endTag(null,"sequenceSet");
//			serXML.endTag(null,"component");
//			serXML.startTag(null,"subjectOf");
//			serXML.startTag(null,"AnnotationSet");
//
//			serXML.endTag(null,"AnnotationSet");
//			serXML.startTag(null,"annotationSet");
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"annotation");
//			serXML.startTag(null, "Component");
//			serXML.startTag(null,"annotation");
//			serXML.startTag(null,"Code");
//			//
//			serXML.endTag(null,"Code");
//			serXML.startTag(null,"component");
//			serXML.startTag(null,"boundary");
//			serXML.startTag(null,"Code");
//			//
//			serXML.endTag(null,"Code");
//			serXML.endTag(null,"boundary");
//			serXML.endTag(null,"component");
//			serXML.startTag(null,"support");
//			serXML.startTag(null,"supportingROI");
//			serXML.startTag(null,"Code");
//			//
//			serXML.endTag(null,"Code");
//			serXML.endTag(null,"supportingROI");
//			serXML.endTag(null,"support");
//			serXML.endTag(null,"annotation");
//			serXML.endTag(null,"Component");
//			serXML.endTag(null,"annotation");
//			serXML.endTag(null,"component");
//			serXML.endTag(null,"annotationSet");
//			serXML.endTag(null,"subjectOf");
//			serXML.endTag(null,"derivedSeries");
//			serXML.endTag(null,"derivation");
//			serXML.endTag(null,"series");
//			serXML.endTag(null,"component");
//
//			serXML.endTag(null, "AnnotatedECG");
//			serXML.endDocument();
//			fos.flush();
//			fos.close();
//		} catch (IllegalArgumentException | IOException e) {
//			e.printStackTrace();
//		}
//		return path;
//	}

	public static String saveToXMLFile(Map<String, Map<String, String>> listMaps,
                                       Map<String, StringBuffer> ecgDataMaps){
		String path = null;
		try {
			Map<String, String> pInfo = listMaps.get(Constant.ECG_PATIENT_INFO);
			Map<String, String> ecgAttr = listMaps.get(Constant.ECG_ANALYSE_PARAM);
			long timeLong = Long.parseLong(pInfo.get("ecg_checktime"));
			String time = DateUtils.sdf_yyyyMMddHHmmss.format(new Date(timeLong));
			File fileDir = new File(Environment.getExternalStorageDirectory()+"/ECGDATA/XML");
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			path = fileDir.getAbsolutePath() + File.separator + time + ".xml";

			FileOutputStream fos = new FileOutputStream(path);
			XmlSerializer serXML = Xml.newSerializer();
			serXML.setOutput(fos, "UTF-8");
			serXML.startDocument("UTF-8", true);
			serXML.startTag(null, "ECG");
			serXML.attribute(null, "Version", "1");
			serXML.attribute(null, "LS", "12");
//			serXML.attribute(null, "SAMPLERATE", ecgAttr.get("SAMPLERATE"));
			serXML.attribute(null, "FNotch", ecgAttr.get("FilterAC"));
			serXML.attribute(null, "FHP", ecgAttr.get("FilterBase"));
			serXML.attribute(null, "FLP", ecgAttr.get("FilterLP"));
			serXML.startTag(null, "Patient");
			serXML.startTag(null, "Name");
			serXML.text(pInfo.get("Name"));
			serXML.endTag(null, "Name");
			serXML.startTag(null, "ID");
			serXML.text(pInfo.get("ID"));
			serXML.endTag(null, "ID");
			serXML.startTag(null, "Age");
			serXML.text(pInfo.get("AGE"));
			serXML.endTag(null, "Age");
			serXML.startTag(null, "Gender");
			serXML.text(pInfo.get("Gender"));
			serXML.endTag(null, "Gender");
//			serXML.startTag(null, "RecordSecond");
//			serXML.text(pInfo.get("RecordSecond"));
//			serXML.endTag(null, "RecordSecond");
			serXML.startTag(null, "CheckDateTime");
			serXML.text(DateUtils.sdf_yyyy_MM_dd_HH_mm_ss.format(new Date(timeLong)));
			serXML.endTag(null, "CheckDateTime");
			serXML.endTag(null, "Patient");
			if (ecgDataMaps!=null) {

				serXML.startTag(null, "Ch0");
				serXML.text(ecgDataMaps.get("Ch0").toString());
				serXML.endTag(null, "Ch0");
				serXML.startTag(null, "Ch1");
				serXML.text(ecgDataMaps.get("Ch1").toString());
				serXML.endTag(null, "Ch1");
				serXML.startTag(null, "Ch2");
				serXML.text(ecgDataMaps.get("Ch2").toString());
				serXML.endTag(null, "Ch2");
				serXML.startTag(null, "Ch3");
				serXML.text(ecgDataMaps.get("Ch3").toString());
				serXML.endTag(null, "Ch3");
				serXML.startTag(null, "Ch4");
				serXML.text(ecgDataMaps.get("Ch4").toString());
				serXML.endTag(null, "Ch4");
				serXML.startTag(null, "Ch5");
				serXML.text(ecgDataMaps.get("Ch5").toString());
				serXML.endTag(null, "Ch5");
				serXML.startTag(null, "Ch6");
				serXML.text(ecgDataMaps.get("Ch6").toString());
				serXML.endTag(null, "Ch6");
				serXML.startTag(null, "Ch7");
				serXML.text(ecgDataMaps.get("Ch7").toString());
				serXML.endTag(null, "Ch7");
				serXML.startTag(null, "Ch8");
				serXML.text(ecgDataMaps.get("Ch8").toString());
				serXML.endTag(null, "Ch8");
				serXML.startTag(null, "Ch9");
				serXML.text(ecgDataMaps.get("Ch9").toString());
				serXML.endTag(null, "Ch9");
				serXML.startTag(null, "Ch10");
				serXML.text(ecgDataMaps.get("Ch10").toString());
				serXML.endTag(null, "Ch10");
				serXML.startTag(null, "Ch11");
				serXML.text(ecgDataMaps.get("Ch11").toString());
				serXML.endTag(null, "Ch11");
			}
			serXML.startTag(null, "Parameter");
//			serXML.attribute(null, "AnalysisState", pms.get("AnalysisState"));
//			serXML.attribute(null, "PWidth", pms.get("PWidth"));
//			serXML.attribute(null, "PExist", pms.get("PExist"));
			serXML.attribute(null, "RRInterval", ecgAttr.get("RRInterval"));
			serXML.attribute(null, "HeartRate", ecgAttr.get("HeartRate"));
			serXML.attribute(null, "PRInterval", ecgAttr.get("PRInterval"));
			serXML.attribute(null, "QRSDuration", ecgAttr.get("QRSDuration"));
			serXML.attribute(null, "QTD", ecgAttr.get("QTD"));
			serXML.attribute(null, "QTC", ecgAttr.get("QTC"));
			serXML.attribute(null, "PAxis", ecgAttr.get("PAxis"));
			serXML.attribute(null, "QRSAxis", ecgAttr.get("QRSAxis"));
			serXML.attribute(null, "TAxis", ecgAttr.get("TAxis"));
			serXML.attribute(null, "RV5SV1", ecgAttr.get("RV5SV1"));
			serXML.attribute(null, "RV5", ecgAttr.get("RV5"));
			serXML.attribute(null, "SV1", ecgAttr.get("SV1"));
			serXML.endTag(null, "Parameter");
//			Map<String, String> dmd = listMaps.get("DMData");
//			serXML.startTag(null, "DMData");
//			serXML.attribute(null, "PStart", dmd.get("PStart"));
//			serXML.attribute(null, "PEnd", dmd.get("PEnd"));
//			serXML.attribute(null, "QRSStart", dmd.get("QRSStart"));
//			serXML.attribute(null, "QRSEnd", dmd.get("QRSEnd"));
//			serXML.attribute(null, "TEnd", dmd.get("TEnd"));
//			serXML.attribute(null, "DMDataCount", dmd.get("DMDataCount"));
//			serXML.endTag(null, "DMData");
			String result = ecgAttr.get("Auto_Result");
            serXML.startTag(null, "AnalysisResult");
			try{
			    Iterator<Map.Entry<String, String>> itClass = ECGDataUtil.decodeResult(result).getClassfy().entrySet().iterator();
			    Map.Entry<String, String> mapClass = itClass.next();
                serXML.startTag(null, "Classfly");
                serXML.attribute(null, "Code", mapClass.getKey());
                serXML.text(mapClass.getValue());
                serXML.endTag(null, "Classfly");
				for (Map.Entry<String, String> itMap : ECGDataUtil.decodeResult(result).getResult().entrySet()) {
					serXML.startTag(null, "Result");
					serXML.attribute(null, "Code", itMap.getKey());
					serXML.text(itMap.getValue());
					serXML.endTag(null, "Result");
				}
			}catch (Exception e){
				e.printStackTrace();
                serXML.startTag(null, "Classfly");
                serXML.attribute(null, "Code", "0");
                serXML.text("分析失败");
                serXML.endTag(null, "Classfly");
                serXML.startTag(null, "Result");
                serXML.attribute(null, "Code", "0");
                serXML.text("分析失败");
                serXML.endTag(null, "Result");
			}
            serXML.endTag(null, "AnalysisResult");

//			serXML.startTag(null, "WaveQuality");
//			serXML.text(analys.get("WaveQuality"));
//			serXML.endTag(null, "WaveQuality");
			serXML.endTag(null, "ECG");
			serXML.endDocument();
			fos.flush();
			fos.close();
		} catch (IllegalArgumentException | IOException | IllegalStateException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static ECGData parse2Data(String path){
		ECGData ecgData = null;
		ECGDataUtil.ECGDataResultHelper resultHelper = new ECGDataUtil.ECGDataResultHelper();
		File file  = new File(path);
		try {
			InputStream inputStream = new FileInputStream(file);
			XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();
			XmlPullParser pullParser = pullFactory.newPullParser();
			pullParser.setInput(inputStream, "UTF-8");
			int eventType = pullParser.getEventType();
			ecgData = new ECGData();
			ecgData.setVersion(1);
			while (XmlPullParser.END_DOCUMENT != eventType) {
				switch (eventType) {
					case XmlPullParser.START_DOCUMENT:
						break;
					case XmlPullParser.START_TAG:
						if ("ECG".equals(pullParser.getName())) {
							ecgData.setFnotch(pullParser.getAttributeValue(null, "FNotch"));
							ecgData.setFhp(pullParser.getAttributeValue(null, "FHP"));
							ecgData.setFlp(pullParser.getAttributeValue(null, "FLP"));
						}
						if ("Name".equals(pullParser.getName())){
							ecgData.setPatiName(pullParser.nextText());
						}
						if ("ID".equals(pullParser.getName())){
							ecgData.setPatiName(pullParser.nextText());
						}
						if ("CheckDateTime".equals(pullParser.getName())){
							String time = pullParser.nextText();
							Date date=null;
							try{
                                date = DateUtils.sdf_yyyy_MM_dd_HH_mm_ss.parse(time);
                            }catch (Exception e){
							    e.printStackTrace();
                            }
							ecgData.setTime(date);
						}
						if ("Ch0".equals(pullParser.getName())) {// I
							String Ch0_I= pullParser.nextText();
							int[] array = UnicodeStringtoByte.string2Int(Ch0_I);
							ecgData.setvI(ZipUtil.gZip(DataUtil.toByteArray(array)));
						}
						if ("Ch1".equals(pullParser.getName())) {// II
							String Ch1_II = pullParser.nextText();
							ecgData.setvII(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch1_II))));
						}
						if ("Ch2".equals(pullParser.getName())) {// III
							String Ch2_III = pullParser.nextText();
							ecgData.setvIII(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch2_III))));
						}
						if ("Ch3".equals(pullParser.getName())) {// avR
							String Ch3_avR = pullParser.nextText();
							ecgData.setaVr(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch3_avR))));
						}
						if ("Ch4".equals(pullParser.getName())) {// avL
							String Ch4_avL = pullParser.nextText();
							ecgData.setaVl(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch4_avL))));
						}
						if ("Ch5".equals(pullParser.getName())) {// avF
							String Ch5_avF = pullParser.nextText();
							ecgData.setaVf(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch5_avF))));
						}
						if ("Ch6".equals(pullParser.getName())) {// v1
							String Ch6_v1 = pullParser.nextText();
							ecgData.setV1(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch6_v1))));
						}
						if ("Ch7".equals(pullParser.getName())) {// v2
							String Ch7_v2 = pullParser.nextText();
							ecgData.setV2(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch7_v2))));
						}
						if ("Ch8".equals(pullParser.getName())) {// v3
							String Ch8_v3 = pullParser.nextText();
							ecgData.setV3(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch8_v3))));
						}
						if ("Ch9".equals(pullParser.getName())) {// v4
							String Ch9_v4 = pullParser.nextText();
							ecgData.setV4(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch9_v4))));
						}
						if ("Ch10".equals(pullParser.getName())) {// v5
							String Ch10_v5 = pullParser.nextText();
							ecgData.setV5(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch10_v5))));
						}
						if ("Ch11".equals(pullParser.getName())) {// v6
							String Ch11_v6 = pullParser.nextText();
							ecgData.setV6(ZipUtil.gZip(DataUtil.toByteArray(UnicodeStringtoByte.string2Int(Ch11_v6))));
						}
						if ("Parameter".equals(pullParser.getName())) {
							ecgData.setHeartRate(Integer.parseInt(pullParser.getAttributeValue(null, "HeartRate")));
							ecgData.setPr(Integer.parseInt(pullParser.getAttributeValue(null, "PRInterval")));
							ecgData.setQrs(Integer.parseInt(pullParser.getAttributeValue(null, "QRSDuration")));
							ecgData.setQtc(Integer.parseInt(pullParser.getAttributeValue(null, "QTC")));
							ecgData.setQt(Integer.parseInt(pullParser.getAttributeValue(null, "QTD")));
							ecgData.setPaxis(Integer.parseInt(pullParser.getAttributeValue(null, "PAxis")));
							ecgData.setQrsaxis(Integer.parseInt(pullParser.getAttributeValue(null, "QRSAxis")));
							ecgData.setTaxis(Integer.parseInt(pullParser.getAttributeValue(null, "TAxis")));
							ecgData.setRv5sv1(Double.parseDouble(pullParser.getAttributeValue(null, "RV5SV1")));
							ecgData.setRv5(Double.parseDouble(pullParser.getAttributeValue(null, "RV5")));
							ecgData.setSv1(Double.parseDouble(pullParser.getAttributeValue(null, "SV1")));
						}
						if ("Classfly".equals(pullParser.getName())) {
							String classCode = pullParser.getAttributeValue(null, "Code");
							String className = pullParser.nextText();
							resultHelper.getClassfy().put(classCode, className);
						}
						if ("Result".equals(pullParser.getName())) {
							String resultCode = pullParser.getAttributeValue(null, "Code");
							String resultName = pullParser.nextText();
							resultHelper.getResult().put(resultCode, resultName);
						}
						break;
					case XmlPullParser.END_TAG:
						if (pullParser.getName().equals("ECG")) {
							Log.i("FileScan", "解析完毕");
						}
						break;
					default:
						break;
				}
				eventType = pullParser.next();
			}
		} catch(XmlPullParserException | IOException e){
			e.printStackTrace();
		}
		resultHelper.setDiagnosisType(ECGDataDiagnosisType.auto.ordinal());
		String autoResult = ECGDataUtil.encodeResult(resultHelper);
		ecgData.setAutoDiagnosisResult(autoResult);
		return ecgData;
	}

	/**
	 * 清空文件夹或删除文件
	 * @param file
	 */
	public static void delete(File file) {
		if (file.isFile()) {  
			file.delete();  
			return;  
		}  
		if(file.isDirectory()){  
			File[] childFiles = file.listFiles();
			if (childFiles == null || childFiles.length == 0) {  
				file.delete();  
				return;  
			}

			for (File childFile : childFiles) {
				delete(childFile);
			}  
			file.delete();  
		}
	}

	/**
	 * 4.4版本以上处理选择图片Uri的问题
	 * @param context 上下文
	 * @param uri Uri
	 * @return 路径
	 */
	@SuppressLint("NewApi")
	public static String getPath(final Context context, final Uri uri) {
	    final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
	    // DocumentProvider
	    if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
	        // ExternalStorageProvider
	        if (isExternalStorageDocument(uri)) {
	            final String docId = DocumentsContract.getDocumentId(uri);
	            final String[] split = docId.split(":");
	            final String type = split[0];
	            if ("primary".equalsIgnoreCase(type)) {
	                return Environment.getExternalStorageDirectory() + "/" + split[1];
	            }
	            // TODO handle non-primary volumes
	        }
	        // DownloadsProvider
	        else if (isDownloadsDocument(uri)) {
	            final String id = DocumentsContract.getDocumentId(uri);
	            final Uri contentUri = ContentUris.withAppendedId(
	                    Uri.parse("content://downloads/public_downloads"), Long.parseLong(id));
	            return getDataColumn(context, contentUri, null, null);
	        }
	        // MediaProvider
	        else if (isMediaDocument(uri)) {
	            final String docId = DocumentsContract.getDocumentId(uri);
	            final String[] split = docId.split(":");
	            final String type = split[0];
	            Uri contentUri = null;
	            if ("image".equals(type)) {
	                contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
	            } else if ("video".equals(type)) {
	                contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
	            } else if ("audio".equals(type)) {
	                contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
	            }
	            final String selection = "_id=?";
	            final String[] selectionArgs = new String[] {
	                    split[1]
	            };
	            return getDataColumn(context, contentUri, selection, selectionArgs);
	        }
	    }
	    // MediaStore (and general)
	    else if ("content".equalsIgnoreCase(uri.getScheme())) {
	        // Return the remote address
	        if (isGooglePhotosUri(uri))
	            return uri.getLastPathSegment();
	        return getDataColumn(context, uri, null, null);
	    }
	    // File
	    else if ("file".equalsIgnoreCase(uri.getScheme())) {
	        return uri.getPath();
	    }
	    return null;
	}
	/**
	 * Get the value of the data column for this Uri. This is useful for
	 * MediaStore Uris, and other file-based ContentProviders.
	 *
	 * @param context The context.
	 * @param uri The Uri to query.
	 * @param selection (Optional) Filter used in the query.
	 * @param selectionArgs (Optional) Selection arguments used in the query.
	 * @return The value of the _data column, which is typically a file path.
	 */
	public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {
	    Cursor cursor = null;
	    final String column = "_data";
	    final String[] projection = {
	            column
	    };
	    try {
	        cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
	                null);
	        if (cursor != null && cursor.moveToFirst()) {
	            final int index = cursor.getColumnIndexOrThrow(column);
	            return cursor.getString(index);
	        }
	    } finally {
	        if (cursor != null)
	            cursor.close();
	    }
	    return null;
	}
	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is ExternalStorageProvider.
	 */
	public static boolean isExternalStorageDocument(Uri uri) {
	    return "com.android.externalstorage.documents".equals(uri.getAuthority());
	}
	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is DownloadsProvider.
	 */
	public static boolean isDownloadsDocument(Uri uri) {
	    return "com.android.providers.downloads.documents".equals(uri.getAuthority());
	}
	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is MediaProvider.
	 */
	public static boolean isMediaDocument(Uri uri) {
	    return "com.android.providers.media.documents".equals(uri.getAuthority());
	}
	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is Google Photos.
	 */
	public static boolean isGooglePhotosUri(Uri uri) {
	    return "com.google.android.apps.photos.content".equals(uri.getAuthority());
	}
}
