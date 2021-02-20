package com.wehealth.model.domain.model;

import com.wehealth.model.domain.enumutil.HHAccountType;
import com.wehealth.model.domain.interfaceutil.Entity;

import java.util.Date;
import java.util.Set;

public class HHAccount implements Entity {
	private Long id;
	private String registeredUserId;
	private Date start;
	private Date expiredDate;   //用户名义到期日（和缓到期日+ 推荐返还）
	private Date hhExpiredDate;  //和缓帐号到期日
	private String hhId;    //和缓主帐号ID
	private int packageId = -1;  //和缓套餐ID， 未开通为-1
	private String userToken;  // 和缓注册返回用户的用户Token
	private Set<HHFamilyMember> familyMembers;
	private HHAccountType accountType;

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getRegisteredUserId() {
		return registeredUserId;
	}

	public void setRegisteredUserId(String registeredUserId) {
		this.registeredUserId = registeredUserId;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getHhId() {
		return hhId;
	}

	public void setHhId(String hhId) {
		this.hhId = hhId;
	}

	public Date getHhExpiredDate() {
		return hhExpiredDate;
	}

	public void setHhExpiredDate(Date hhExpiredDate) {
		this.hhExpiredDate = hhExpiredDate;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public Set<HHFamilyMember> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(Set<HHFamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public HHAccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(HHAccountType accountType) {
		this.accountType = accountType;
	}
}
