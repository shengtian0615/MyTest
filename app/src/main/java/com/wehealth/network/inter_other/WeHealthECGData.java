package com.wehealth.network.inter_other;

import com.wehealth.model.domain.model.ECGData;
import com.wehealth.model.domain.model.ECGDataPassHelper;
import com.wehealth.model.domain.model.ECGDevice;
import com.wehealth.model.domain.model.LiBangParameter;
import com.wehealth.model.domain.model.LiBangResult;
import com.wehealth.model.domain.model.ResultPassHelper;
import com.wehealth.model.domain.model.ThirdPartyCheckResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeHealthECGData {
	/**
	 * 获取最近一个心电数据数
	 * 说明：idCard必传，其他4项如果不需要可以不传，或者传-1。
		获取具有身份证号idCard的病人的最近一次心电数据，结果可能来自商业版
	 * @return
	 */
	@GET("ecgData/lastest/idCard/{idCard}")
    Call<ECGData> getLastestECGDataByIdCard(@Header("Authorization") String authorization,
                                            @Path("idCard") String idCard,
                                            @Query("start") long start,//@DefaultValue("-1")
                                            @Query("end") long end,//@DefaultValue("-1")
                                            @Query("page") int page,//@DefaultValue("-1")
                                            @Query("count") int count);//@DefaultValue("-1")

    @PUT("ecgData/update/{dataId}")
    Call<ResultPassHelper> updateAutoDiagResult(@Header("Authorization") String authorization,
//                                                @Query("idEncoded") Boolean idEncoded,
                                                @Path("dataId") Long id, @Body ECGData result);

    @GET("ecgData/manualResult/thirdPartyCheckResult/{dataId}")
    Call<ThirdPartyCheckResult> getDoctorSign(@Header("Authorization") String authorization,
                                              @Path("dataId") String dataId);

    @POST("api/ecgservice/calautodiagnosresult")
    Call<LiBangResult> obtainLiBangResult(@Header("Authorization") String authorization, @Body LiBangParameter liBangParam);
	
	/**获取某病人的心电档案
	 * @param idCard 参数说明：idCard必传，其他4项如果不需要可以不传，或者传-1。
	 * @param start
	 * @param end
	 * @param page
	 * @param count
	 * @return 获取具有身份证号idCard的病人的心电数据，默认获取已经关联了真实身份证的病人的心电数据。两种身份的数据一起按时间降序排列。
	 */
	@GET("ecgData/idCard/{idCard}")
    Call<List<ECGDataPassHelper>> getECGDataByIdCard(@Header("Authorization") String authorization,
                                                     @Path("idCard") String idCard,
                                                     @Query("start") long start,
                                                     @Query("end") long end,
                                                     @Query("page") int page,
                                                     @Query("count") int count);
	
	@GET("ecgData/helper/{id}")
    Call<ECGDataPassHelper> getHelperById(@Header("Authorization") String authorization, @Path("id") Long id);
    
	@GET("ecgData/idCard/{idCardNo}")
    Call<ECGDataList> getECGData(@Header("Authorization") String authorization, @Path("idCardNo") String idCardNo, @Query("start") long start, @Query("end") long end, @Query("page") int page, @Query("count") int count);
   
    @GET("ecgData/id/{id}")
    Call<ECGData> getECGDataById(@Header("Authorization") String authorization, @Path("id") long id);
    
    @POST("ecgData")
    Call<ResultPassHelper> createECGData(@Header("Authorization") String authorization, @Body ECGData data);
    
//    @FormUrlEncoded
    @POST("ecgData/manualResult/accept/{idCardNo}")
    Call<String> acceptManualDiagnosisTask(@Header("Authorization") String authorization, @Path("idCardNo") String idCardNo,
                                           @Field("ecgDataId") long ecgDataId, @Field("accept") boolean accept, @Field("level") String docLevel);

    @POST("ecgData/manualResult/upload/{idCardNo}")
    Call<ResultPassHelper> uploadManualDiagnosisResult(@Header("Authorization") String authorization, @Path("idCardNo") String idCardNo, @Query("ecgDataId") long ecgDataId, @Query("code") String code, @Query("comment") String comment);

    @GET("ecgData/manualResult/regularCheck/{dataId}")
    Call<ResultPassHelper> requestRegularCheck(@Header("Authorization") String authorization, @Path("dataId") String id);
    
    @GET("ecgData/manualResult/regularCheck/{dataId}")
    Call<ResultPassHelper> requestRegularCheck(@Header("Authorization") String authorization, @Path("dataId") String id, @Query("bonusId") Long bonusId);
    
    @GET("ecgData/manualResult/freeCheck/{dataId}")
    Call<ResultPassHelper> requestFreeCheck(@Header("Authorization") String authorization, @Path("dataId") String id, @Query("bonusId") Long bonusId, @Query("symptoms") String symptoms);//
  
    @GET("ecgData/manualResult/freeCheck/{dataId}")
    Call<ResultPassHelper> requestFreeCheck(@Header("Authorization") String authorization, @Path("dataId") String id, @Query("bonusId") Long bonusId, @Query("symptoms") String symptoms, @Query("idEncoded") Boolean isEncoded);//最后一个参数  true表示商业版的id

    @GET("ecgData/manualResult/thirdPartyCheck/{dataId}")
    Call<ResultPassHelper> requestThirdPartyCheck(@Header("Authorization") String authorization, @Path("dataId") String id,
                                                  @Query("bonusId") Long bonusId, @Query("symptoms") String symptoms, @Query("idEncoded") Boolean idEncoded);

//    @FormUrlEncoded
    @POST("ecgData/manualResult/freeCheck/accept/{idCardNo}")
    Call<String> acceptFreeDiagnosisTask(@Header("Authorization") String authorization, @Path("idCardNo") String idCard, @Field("ecgDataId") long ecgDataId);
    
    @POST("ecgData/manualResult/freeCheck/upload/{idCardNo}")
    Call<ResultPassHelper> uploadFreeCheckResult(@Header("Authorization") String authorization, @Path("idCardNo") String idCard, @Query("ecgDataId") Long ecgDataId, @Query("code") String code, @Query("comment") String comment);
    
    @POST("ecgData/manualResult/regularCheck/upload/{idCardNo}")
    Call<ResultPassHelper> uploadRegularCheckResult(@Header("Authorization") String authorization, @Path("idCardNo") String idCard, @Query("ecgDataId") long ecgDataId, @Query("code") String code, @Query("comment") String comment);
    
    @GET("ecgData/idCard/{idCard}")
    Call<List<ECGDataPassHelper>> getECGDataHelperByIdCard(@Header("Authorization") String authorization, @Path("idCard") String idCard, @Query("start") long start, @Query("end") long end, @Query("page") int page, @Query("count") int count);

    @GET("ecgDevice/get")
    Call<ECGDevice> getECGDevice(@Header("Authorization") String authorization, @Query("serialNo") String serialNo, @Query("imei") String imei);
    
    @GET("ecgDevice/checkSerial/{serialNo}")
    Call<ResultPassHelper> checkSerial(@Header("Authorization") String authorization, @Path("serialNo") String serialNo);
    
    @GET("ecgData/personal/check/{dataId}")
    Call<ResultPassHelper> personalEcgCheck(@Header("Authorization") String authorization, @Path("dataId") String id, @Query("symptoms") String symptoms);

    /**
     * 解绑设备
     * @param idCardNo
     * @param reason
     * @param operator
     * @return
     */
    @GET("registeredUser/unbinddevice")
    Call<ResultPassHelper> unbindDevice(@Header("Authorization") String authorization,
                                        @Query("idCardNo") String idCardNo,
                                        @Query("reason") String reason,
                                        @Query("operator") String operator);

    @GET("ecgData/manualResult/thirdPartyCheck/paid/{dataId}")
    Call<ResultPassHelper> requestThirdPartyCheckAfterPay(@Header("Authorization") String authorization,
                                                          @Path("dataId") String id,
                                                          @Query("symptoms") String symptoms,
                                                          @Query("idEncoded") Boolean idEncoded);
}