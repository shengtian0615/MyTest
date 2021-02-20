package com.wehealth.network.inter_other;

import com.wehealth.model.domain.model.CompanyServiceFee;
import com.wehealth.model.domain.model.ResultPassHelper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;


public interface WeHealthCompany {
    @GET("company/servicefee")
    Call<CompanyServiceFee> getCompanyServiceFee(@Header("Authorization") String authorization);
    
    @GET("clientSoftwareInfo/upload")
	Call<ResultPassHelper> uploadInfo(
            @Header("Authorization") String authorization,
            @Query("type") String type,
            @Query("clientId") String clientId,
            @Query("versionName") String versionName,
            @Query("deviceInfo") String deviceInfo);
}

