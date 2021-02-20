package com.wehealth.network.inter_other;

import com.wehealth.model.domain.model.AuthToken;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface WeHealthToken {

    @Headers("Content-type:application/x-www-form-urlencoded;charset=UTF-8")
	@POST("token")
    Call<AuthToken> authorize(@Query("grant_type") String grantType, @Query("scope") String scope,
                              @Query("client_id") String username, @Query("client_secret") String password);
    @Headers("Content-type:application/x-www-form-urlencoded;charset=UTF-8")
	@POST("token")
    Call<AuthToken> refreshToken(@Header("Authorization") String authorization, @Query("grant_type") String grantType,
                                 @Query("scope") String scope, @Query("refresh_token") String refreshToken);
}
