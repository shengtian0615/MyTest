package com.wehealth.network.inter_other;

import com.wehealth.model.domain.enumutil.AppType;
import com.wehealth.model.domain.model.AppVersion;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface WeHealthVersion {

	@GET("appVersion/query/new")
    Call<AppVersion> getNewVersion(@Header("Authorization") String authorization, @Query("appType") AppType appType, @Query("versionCode") int versionCode);
}
