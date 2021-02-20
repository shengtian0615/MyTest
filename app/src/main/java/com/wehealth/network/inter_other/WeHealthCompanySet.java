package com.wehealth.network.inter_other;

import com.wehealth.model.domain.model.CompanySetting;
import com.wehealth.model.domain.model.ResultPassHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeHealthCompanySet {

	@GET("companySetting/query/shortName/{shortName}")
	Call<CompanySetting> getByShortName(@Header("Authorization") String authorization, @Path("shortName") String shortName);
	
	@GET("companySetting/query/shortNames")
	Call<List<CompanySetting>> getByShortNames(@Header("Authorization") String authorization, @Query("shortNames") List<String> shortNames);
	
	/**
	 * Name: serviceType, Value: serviceName=serviceFee. such as "紧急复核=20"
	 * serviceType复核类型: emergency, regular, free
	 * serivceName可能由两部分组成通过加号分隔， 例如 "首选医生复核+24小时复核"
	 * @return such as {name:regular,value:首选医生复核+24小时复核=20}
	 */
	@GET("companySetting/feeService")
    Call<List<ResultPassHelper>> getChargeService(@Header("Authorization") String authorization);
}
