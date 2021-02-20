package com.wehealth.network.inter_other;

import com.wehealth.model.domain.model.DoctorGroupMember;
import com.wehealth.model.domain.model.HeadPhoto;
import com.wehealth.model.domain.model.ResultPassHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeHealthEASEIM {

	/**
	 * 医生群组首次加载调用此方法获取所有医生昵称信息
	 * @return
	 */
	@GET("doctorGroupChat/members/all/{groupId}")
	Call<List<DoctorGroupMember>> getAllDoctorMembers(
            @Header("Authorization") String authorization,
            @Path("groupId") String groupId,
            @Query("page") Integer page,
            @Query("pageCount") Integer pageCount);
	
	/**
	 * 批量获取医生基本信息
	 * @param ids
	 * @return
	 */
	@GET("doctorGroupChat/members/lacked")
	Call<List<DoctorGroupMember>> getLackedMembers(
            @Header("Authorization") String authorization,
            @Query("ids") List<String> ids);
	
	/**
	 * 医生群组首次加载调用此方法获取所有医生小头像, 需要先获取总数量，然后再调用此方法分页获取
	 * @return
	 */
	@GET("doctorGroupChat/headPhotos/{groupId}")
	Call<List<HeadPhoto>> getAllDoctorsHeadPhoto(
            @Header("Authorization") String authorization,
            @Path("groupId") String groupId,
            @Query("page") Integer page,
            @Query("pageCount") Integer pageCount);
	
	/**
	 * 医生群组首次加载调用此方法获取所有医生小头像总数量
	 * @return
	 */
	@GET("doctorGroupChat/headPhotos/count/{groupId}")
	Call<ResultPassHelper> getDoctorsHeadPhotoCount(
            @Header("Authorization") String authorization,
            @Path("groupId") String groupId);
	
	/**
	 * 医生群组批量获取updateTime后的所有更新记录
	 * @return
	 */
	@GET("doctorGroupChat/members/updated/{groupId}")
	Call<List<DoctorGroupMember>> getNewestRecord(
            @Header("Authorization") String authorization,
            @Path("groupId") String groupId,
            @Query("updateTime") Long updateTime);
	
	/**
	 * 批量获取医生小头像，如果医生数量太大，建议分页获取
	 * @return
	 */
	@GET("doctorGroupChat/headPhotos/lacked")
    Call<List<HeadPhoto>> getLackedDoctorsHeadPhoto(
            @Header("Authorization") String authorization,
            @Query("ids") List<String> ids);
}
