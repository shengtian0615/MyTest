package com.wehealth.network.inter_other;

import com.wehealth.model.domain.model.Bonus;
import com.wehealth.model.domain.model.OrderAddress;
import com.wehealth.model.domain.model.ResultPassHelper;
import com.wehealth.model.domain.model.ServiceItem;
import com.wehealth.model.domain.model.ServicePackage;
import com.wehealth.model.domain.model.UserServicePackage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeHealthBonus {

	/**
	 * 查找在有效期内的，还有剩余次数的卡券
	 * @param forUserId, regUser idCardNo
	 * @param bonusType
	 * 
	 * @return
	 */
	@GET("bonus/query/available/{forUserId}")
	Call<List<Bonus>> queryAvailableBonus(
            @Header("Authorization") String authorization,
            @Path("forUserId") String forUserId,
            @Query("bonusType") String bonusType);
	
	/**
	 * 1. Query "can use": forUserId, expired=false, usedUp=false;
	 * 2. Query "usedUp": forUserId, usedUp=true;
	 * 3. Query "expired": forUserId, expired= true, usedUp=false;
	 * 
	 * @param forUserId, RegisteredUser idCardNo
	 * @param type, BonusType
	 * @param bonusReason, BonusReason reasonId
	 * @param expireBefore, expired before this time
	 * @param expired, true means currentTime > expireTime
	 * @param usedUp, true means times = 0
	 * @param page
	 * @param pageCount
	 * @return
	 */
	@GET("bonus/query")
	Call<List<Bonus>> queryBonus(
            @Header("Authorization") String authorization,
            @Query("forUserId") String forUserId,
            @Query("type") String type,
            @Query("bonusReason") String bonusReason,
            @Query("expireBefore") Long expireBefore,
            @Query("expired") Boolean expired,
            @Query("usedUp") Boolean usedUp,
            @Query("page") Integer page,
            @Query("pageCount") Integer pageCount);
	
	@GET("servicePackage/pac/available")
	Call<List<ServicePackage>> queryAvailableServicePackage(@Header("Authorization") String authorization);
	
	@GET("servicePackage/items/{packageId}")
	Call<List<ServiceItem>> queryPackageItems(
            @Header("Authorization") String authorization,
            @Path("packageId") String packageId);
	
	@GET("servicePackage/up/{regUserIdCardNo}")
	Call<List<UserServicePackage>> getPackage(
            @Header("Authorization") String authorization,
            @Path("regUserIdCardNo") String forUserId,
            @Query("expired") Boolean expired);
	
	@POST("servicePackage/package/buy")
	Call<ResultPassHelper> buyPackage(
            @Header("Authorization") String authorization,
            @Body UserServicePackage userPac);
	
	/**
	 * @param address
	 * @return success:new id, error_occur/failed:error_msg/failed_msg
	 */
	@POST("orderRelated/address")
	Call<ResultPassHelper> createOrderAddress(
            @Header("Authorization") String authorization,
            @Body OrderAddress address);
	
	@PUT("orderRelated/address")
	Call<ResultPassHelper> updateOrderAddress(
            @Header("Authorization") String authorization,
            @Body OrderAddress address);
	
	@GET("orderRelated/address/{userId}")
	Call<List<OrderAddress>> getUserAddresses(
            @Header("Authorization") String authorization,
            @Path("userId") String userId);
	
	@GET("orderRelated/address/def/{userId}")
	Call<OrderAddress> getUserDefaultAddress(
            @Header("Authorization") String authorization,
            @Path("userId") String userId);
	@DELETE("orderRelated/address/{id}")
	Call<ResultPassHelper> deleteUserAddress(
            @Header("Authorization") String authorization,
            @Path("id") Long id);
}
