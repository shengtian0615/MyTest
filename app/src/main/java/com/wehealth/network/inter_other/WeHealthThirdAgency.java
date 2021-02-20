package com.wehealth.network.inter_other;

import com.wehealth.model.domain.model.AgencySetting;
import com.wehealth.model.domain.model.BMIData;
import com.wehealth.model.domain.model.BloodOxygenData;
import com.wehealth.model.domain.model.BloodPressure;
import com.wehealth.model.domain.model.BloodSugar;
import com.wehealth.model.domain.model.CholesterolData;
import com.wehealth.model.domain.model.DrugUseSuggestion;
import com.wehealth.model.domain.model.ECGData;
import com.wehealth.model.domain.model.MedicalExaminationData;
import com.wehealth.model.domain.model.RegisteredUser;
import com.wehealth.model.domain.model.ResultPassHelper;
import com.wehealth.model.domain.model.ThirdAgency;
import com.wehealth.model.domain.model.ThirdAgencyPatient;
import com.wehealth.model.domain.model.UricAcidData;
import com.wehealth.model.domain.model.WHRData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeHealthThirdAgency {

	/**
	 * 输入项： 名称、用户名、密码、地址、描述
		提供一个负责人的联系方式，放在紧急联系人里：姓名，手机号，地址
	 * 
	 * keep tuid in idCardNo.
	 * @param cid, agency id.
	 * @param user
	 * @return "error_occur":"error msg", "failed":"fail error", "success":null
	 */
	@POST("agencyApi/user")
    Call<ResultPassHelper> createAgencyUser(
            @Header("Authorization") String authorization,
            @Body RegisteredUser user,
            @Query("cid") String cid,
            @Query("equipSerialNo") String equipSerialNo);
	
	/**
	 * 商业版If pass pid, check whether create new AgencyPatient.
	 * @param ecgData
	 * @param pid
	 * @return "error_occur":"errorMsg", "failed":"reason","success":"data id"
	 */
	@POST("agencyApi/ecg")
	Call<ResultPassHelper> agencyCreateECGData(
            @Header("Authorization") String authorization,
            @Body ECGData ecgData,
            @Query("pid") String pid,
            @Query("pName") String pName,
            @Query("pAge") Integer pAge,
            @Query("isMale") Boolean isMal);

	@POST("agencyApi/bloodPressure")
	Call<ResultPassHelper> agencyCreateBloodPressure(
			@Header("Authorization") String authorization,
			@Query("regId") String regId,
			@Query("devSN") String devSN,
			@Query("pid") String pid,
			@Query("pName") String pName,
			@Query("pAge") Integer pAge,
			@Query("isMale") Boolean isMale,
			@Query("cellPhone") String cellPhone,
			@Body BloodPressure pressure);
	
	/**
	 * 诊所版 创建ECG数据
	 * @param ecgData --- ECG数据
	 * @param pid--- 病人身份证
	 * @param cellPhone --- 病人电话
	 * @param pName--- 病人姓名
	 * @param pAge---- 病人年龄
	 * @param isMale---病人性别
	 * @return  返回值:ResultPassHelper {name:…,value:…}
		成功, 返回name= “success” 
		失败，返回 name= “failed” value = “ 出错原因”.
	 */
	@POST("agencyApi/clinic/ecg")
	Call<ResultPassHelper> clinicCreateECGData(
            @Header("Authorization") String authorization,
            @Body ECGData ecgData,
            @Query("pid") String pid,
            @Query("cellPhone") String cellPhone,
            @Query("pName") String pName,
            @Query("pAge") Integer pAge,
            @Query("isMale") Boolean isMale);
	
	@POST("agencyApi/patient")
	Call<ResultPassHelper> createPatient(
            @Header("Authorization") String authorization,
            @Body ThirdAgencyPatient p);
	
	@GET("thirdAgency/find/{clientId}")
	Call<ThirdAgency> find(
            @Header("Authorization") String authorization,
            @Path("clientId") String clientId);
	
	/**
	 * @param user
	 * @param realIdCardNo, nullable, if have means add realIdCardNo
	 * @return
	 */
	@PUT("agencyApi/user")
	Call<ResultPassHelper> updateAgencyRegisteredUser(@Header("Authorization") String authorization, @Body RegisteredUser user, @Query("realIdCardNo") String realIdCardNo, @Query("bindDevice") Boolean bindDevice);
	
	/**
	 * ThirdAgencyUser tries to login with username and deviceSerial
	 * 
	 * @param username
	 * @param deviceSerial
	 * @return success:null or error_occur:error_msg, success can login
	 */
	@GET("agencyApi/login")
	Call<ResultPassHelper> login(@Header("Authorization") String authorization, @Query("username") String username, @Query("deviceSerial") String deviceSerial);

	/**
	 * 根据名字获取和缓视频医生的URL里的参数
	 * @param name
	 * @return
	 */
	@GET("thirdAgency/byName")
	Call<List<ThirdAgency>> query(@Header("Authorization") String authorization, @Query("name") String name);

	/**
	 * 根据shortName获取设置
	 * @param shortName
	 * @return
	 */
	@GET("thirdAgency/setting/query/shortName/{shortName}")
	Call<AgencySetting> getSettingByShortName(
			@Header("Authorization") String authorization,
			@Path("shortName") String shortName);

	/**
	 * 查询
	 *
	 * @param shortName
	 * @param displayName
	 * @param page
	 * @param pageCount
	 * @return
	 */
	@GET("thirdAgency/setting/query")
	Call<List<AgencySetting>> querySetting(
            @Header("Authorization") String authorization,
            @Query("shortName") String shortName,
            @Query("displayName") String displayName,
            @Query("page") Integer page, @Query("pageCount") Integer pageCount);

	/**获得机构用药
	 *
	 * @param agencyId  -----机构ID
	 * @return 成功, 返回DrugUseSuggestion
	 *     失败，返回 null
	 */
	@GET("thirdAgency/drugUseSuggestion/{agencyId}")
	Call<DrugUseSuggestion> getDrugUseSuggestion(@Header("Authorization") String authorization, @Path("agencyId") String agencyId);

	/**判断当前版本的机构用药建议是否需要更新

	 * @param agencyId  -----机构ID
	 * @param version —版本号
	 * @return ResultPassHelper
	 *         成功, 返回name= ValidatorConstant.SUCCESS,  value= “true”或”false”
	 *         失败，返回 name= ValidatorConstant.ERROR_OCCUR value = “ 出错原因”.
	 */
	@GET("thirdAgency/drugUseSuggestion/checkUpdate/{agencyId}")
	Call<ResultPassHelper> checkIfNeedUpdate(@Header("Authorization") String authorization,
                                             @Path("agencyId") String agencyId,
                                             @Query("version") Integer version);

	/** 创建体检数据
	 *
	 * @ regId --- 注册用户ID
	 * @ devSN --- 设备序列号
	 * @ pid --- 病人身份证
	 * @ pName --- 病人姓名
	 * @ pAge ---- 病人年龄
	 * @ isMale ---病人性别
	 * @ cellPhone --- 病人电话
	 * @ inpatientArea --- 病区
	 * @ ward --- 病房
	 * @ hospitalBedNo --- 病床号
	 * @ medicalData ---- 体检数据， 其中ECG数据在测心电时就立刻上传，在此数据中放入上传后返回的ID， 其余检测项在此一同上传。
	 * @return 成功, 返回name= “success”
	 * 	失败，返回 name= “failed” value = “ 出错原因”.
	 */
	@POST("agencyApi/medicalExamData")
	Call<MedicalExaminationData> agencyCreateMedicalExamData(
			@Header("Authorization") String authorization,
			@Query("regId") String regId,
			@Query("devSN") String devSN,
			@Query("pid") String pid,
			@Query("pName") String pName,
			@Query("pAge") Integer pAge,
			@Query("isMale") Boolean isMale,
			@Query("cellPhone") String cellPhone,
			@Query("inpatientArea") String inpatientArea,
			@Query("ward") String ward,
			@Query("hospitalBedNo") String hospitalBedNo,
			@Body MedicalExaminationData medicalData);

	@PUT("agencyApi/medicalExamData")
	Call<ResultPassHelper> agencyUpdateMedicalExamData(
			@Header("Authorization") String authorization,
			@Body MedicalExaminationData medicalData);

	@POST("agencyApi/bloodPressure")
	Call<BloodPressure> agencyCreateBloodPressure(
			@Header("Authorization") String authorization,
			@Query("regId") String regId,
			@Query("devSN") String devSN,
			@Query("pid") String pid,
			@Query("pName") String pName,
			@Query("pAge") Integer pAge,
			@Query("isMale") Boolean isMale,
			@Query("cellPhone") String cellPhone,
			@Query("inpatientArea") String inpatientArea,
			@Query("ward") String ward,
			@Query("hospitalBedNo") String hospitalBedNo,
			@Body BloodPressure pressure);

	@POST("agencyApi/bmiData")
	Call<BMIData> agencyCreateBMIData(
			@Header("Authorization") String authorization,
			@Query("regId") String regId,
			@Query("devSN") String devSN,
			@Query("pid") String pid,
			@Query("pName") String pName,
			@Query("pAge") Integer pAge,
			@Query("isMale") Boolean isMale,
			@Query("cellPhone") String cellPhone,
			@Query("inpatientArea") String inpatientArea,
			@Query("ward") String ward,
			@Query("hospitalBedNo") String hospitalBedNo,
			@Body BMIData bmiData);

	@POST("agencyApi/bloodSugar")
	Call<BloodSugar> agencyCreateBloodSugar(
			@Header("Authorization") String authorization,
			@Query("regId") String regId,
			@Query("devSN") String devSN,
			@Query("pid") String pid,
			@Query("pName") String pName,
			@Query("pAge") Integer pAge,
			@Query("isMale") Boolean isMale,
			@Query("cellPhone") String cellPhone,
			@Query("inpatientArea") String inpatientArea,
			@Query("ward") String ward,
			@Query("hospitalBedNo") String hospitalBedNo,
			@Body BloodSugar bloodSugar);

	@POST("agencyApi/cholesterolData")
	Call<CholesterolData> agencyCreateCholesterolData(
			@Header("Authorization") String authorization,
			@Query("regId") String regId,
			@Query("devSN") String devSN,
			@Query("pid") String pid,
			@Query("pName") String pName,
			@Query("pAge") Integer pAge,
			@Query("isMale") Boolean isMale,
			@Query("cellPhone") String cellPhone,
			@Query("inpatientArea") String inpatientArea,
			@Query("ward") String ward,
			@Query("hospitalBedNo") String hospitalBedNo,
			@Body CholesterolData cholesterolData);

	@POST("agencyApi/uricAcidData")
	Call<UricAcidData> agencyCreateUricAcidData(
            @Header("Authorization") String authorization,
            @Query("regId") String regId,
            @Query("devSN") String devSN, @Query("pid") String pid,
            @Query("pName") String pName,
            @Query("pAge") Integer pAge,
            @Query("isMale") Boolean isMale,
            @Query("cellPhone") String cellPhone,
            @Query("inpatientArea") String inpatientArea,
            @Query("ward") String ward,
            @Query("hospitalBedNo") String hospitalBedNo,
            @Body UricAcidData uricAcidData);

	@POST("agencyApi/WHRData")
	Call<WHRData> agencyCreateWHRData(
            @Header("Authorization") String authorization, @Query("regId") String regId,
            @Query("devSN") String devSN, @Query("pid") String pid,
            @Query("pName") String pName,
            @Query("pAge") Integer pAge,
            @Query("isMale") Boolean isMale,
            @Query("cellPhone") String cellPhone,
            @Query("inpatientArea") String inpatientArea,
            @Query("ward") String ward,
            @Query("hospitalBedNo") String hospitalBedNo,
            @Body WHRData whrData);

	@POST("agencyApi/bloodOxygenData")
	Call<BloodOxygenData> agencyCreateBloodOxygenData(@Header("Authorization") String authorization, @Query("regId") String regId,
                                                      @Query("devSN") String devSN, @Query("pid") String pid,
                                                      @Query("pName") String pName,
                                                      @Query("pAge") Integer pAge,
                                                      @Query("isMale") Boolean isMale,
                                                      @Query("cellPhone") String cellPhone,
                                                      @Query("inpatientArea") String inpatientArea,
                                                      @Query("ward") String ward,
                                                      @Query("hospitalBedNo") String hospitalBedNo,
                                                      @Body BloodOxygenData bloodOxygenData);
}
