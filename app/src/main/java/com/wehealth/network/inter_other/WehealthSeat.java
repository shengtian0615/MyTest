package com.wehealth.network.inter_other;

import com.wehealth.model.domain.model.ResultPassHelper;
import com.wehealth.model.domain.model.Seating;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface WehealthSeat {

	/**
	 * 获取所有座席
	 * @param authorization
	 * @param agencyId 如果医助属于机构，则需要传此参数，获取机构专属座席。
	 * @return
	 */
	@GET("seating/query")
    Call<List<Seating>> query(@Header("Authorization") String authorization, @Query("agencyId") String agencyId);
	
	/**
	 * 
	 * @param authorization
	 * @param hid 坐席的id
	 * @param idCardNo 医助的idCardNo，不能为空
	 * @return {success:null}, {error_occur:error_message}
	 */
	@GET("seating/login")
	Call<ResultPassHelper> login(@Header("Authorization") String authorization, @Query("hid") Long hid, @Query("idCardNo") String idCardNo);
	
	/**
	 * 坐席下线
	 * @param authorization
	 * @param hid 坐席的id
	 * @param idCardNo 医助的idCardNo，可以为空。
	 * @return {success:null}, {error_occur:error_message}
	 */
	@GET("seating/logout")
    Call<ResultPassHelper> logout(@Header("Authorization") String authorization, @Query("hid") Long hid, @Query("idCardNo") String idCardNo);
}
