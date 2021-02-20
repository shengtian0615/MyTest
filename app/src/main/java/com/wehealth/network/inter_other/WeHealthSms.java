package com.wehealth.network.inter_other;


import com.wehealth.model.domain.model.ResultPassHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeHealthSms {

	@GET("sms/register/doctor/{phoneNumber}")
	Call<ResultPassHelper> doctorAppRegisterVerify(@Path("phoneNumber") String phoneNumber, @Query("appType") String appType);

	@GET("sms/register/doctor/{phoneNumber}")
	Call<ResultPassHelper> doctorAppRegisterVerify(@Path("phoneNumber") String phoneNumber,
                                                   @Query("appType") String appType,
                                                   @Query("signature") String signature);
	
	@GET("sms/register/patient/{phoneNumber}")
	Call<ResultPassHelper> patientAppRegisterVerify(@Path("phoneNumber") String phoneNumber, @Query("appType") String appType);

	/**个人用户端注册
	 * @param phoneNumber  -----用户身份证号
	 * @param appType ---------应用类型
	 * @return ResultPassHelper 成功, 返回name: Result value: smsid值; 	失败，返回name: Error value: "该手机号已注册过，请更换手机号码注册"
	 */
	@GET("sms/register/patient/consumer/{phoneNumber}")
	Call<ResultPassHelper> patientAppRegisterInConsumerVerify(@Path("phoneNumber") String phoneNumber, @Query("appType") String appType);


	@GET("sms/changepd/doctor/{phoneNumber}")
	Call<ResultPassHelper> doctorAppChangePasswordVerify(@Path("phoneNumber") String phoneNumber,
                                                         @Query("operator") String operator,
                                                         @Query("appType") String appType,
                                                         @Query("signature") String signature);

	@GET("sms/changepd/doctor/{phoneNumber}")
	Call<ResultPassHelper> doctorAppChangePasswordVerify(@Path("phoneNumber") String phoneNumber,
                                                         @Query("operator") String operator, @Query("appType") String appType);
	
	@GET("sms/changepd/patient/{phoneNumber}")
	Call<ResultPassHelper> patientAppChangePasswordVerify(@Path("phoneNumber") String phoneNumber,
                                                          @Query("operator") String operator, @Query("appType") String appType);
	
	@GET("sms/verify/{smsId}")
	Call<ResultPassHelper> verifyCode(@Path("smsId") String smsId, @Query("code") String code);
	
	@GET("sms/commonPhoneCheck/{phoneNumber}")
	Call<ResultPassHelper> commonPhoneCheck(@Path("phoneNumber") String phoneNumber,
                                            @Query("operator") String operator, @Query("appType") String appType);

	/**个人用户端注册
	 * @param phoneNumber  -----用户身份证号
	 * @param appType ---------应用类型
	 * @return ResultPassHelper 成功, 返回name: Result value: smsid值; 	失败，返回name: Error value: "该手机号已注册过，请更换手机号码注册"
	 */
	@GET("sms/register/patient/consumer/{phoneNumber}")
	Call<ResultPassHelper> patientAppRegisterInConsumerVerify(@Path("phoneNumber") String phoneNumber, @Query("appType") String appType, @Query("signature") String signature);

	/**
	 * RegisterUser
	 * @param idCardNo
	 * @return
	 */
	@GET("tokenFree/registeredUser/checkIdCardNo/{idCardNo}")
	Call<ResultPassHelper> checkIDCardExists(@Path("idCardNo") String idCardNo);

	/**
	 * @param phoneNumber 病人电话
	 * @param patientId 病人ID
	 * @param doctorId 医生ID
	 * @param appType 调用接口的APP
	 * @param content 短信内容
	 * @return ResultPassHelper{name:…,value:…}
	成功, 返回name= “success”
	失败，返回 name= “failed” value = “ 出错原因”.
	 */
	@GET("sms/clinic/doctor/reminder/{phoneNumber}")
	Call<ResultPassHelper> doctorSendReminder(
            @Path("phoneNumber") String phoneNumber,
            @Query("patientId") String patientId,
            @Query("doctorId") String doctorId,
            @Query("appType") String appType,
            @Query("content") String content);

	@GET("sms/clinic/doctor/timedReminder/{phoneNumber}")
	Call<ResultPassHelper> doctorSendTimedReminder(
            @Path("phoneNumber") String phoneNumber,
            @Query("patientId") String patientId,
            @Query("doctorId") String doctorId,
            @Query("appType") String appType,
            @Query("content") String content,
            @Query("howMany") int howMany);
	/**
	 * 群发短信
	 * @param phoneNumbers
	 * @param doctorId
	 * @param appType
	 * @param content
	 * @return ResultPassHelper{name:…,value:…}
	成功, 返回name= “success”
	失败，返回 name= “failed” value = “ 出错原因”.
	 */
	@GET("sms/clinic/doctor/reminderAll")
    Call<ResultPassHelper> doctorSendReminderAll(
            @Query("phoneNumbers") List<String> phoneNumbers,
            @Query("doctorId") String doctorId,
            @Query("appType") String appType,
            @Query("content") String content);
}
