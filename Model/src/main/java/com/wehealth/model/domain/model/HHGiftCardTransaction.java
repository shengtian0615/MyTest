package com.wehealth.model.domain.model;

import com.wehealth.model.domain.enumutil.HHGiftCardTransacStatus;
import com.wehealth.model.domain.interfaceutil.Entity;
import com.wehealth.model.domain.interfaceutil.TimeAuditable;

import java.util.Date;

import androidx.annotation.NonNull;


public class HHGiftCardTransaction implements TimeAuditable, Entity, Comparable<HHGiftCardTransaction> {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String recvCellPhone; // 只有在赠予是有值。
	private String fromUser; // 只有在推荐或赠予是有值。 值为赠予者或推荐购买者的身份证号
	private String fromUserCellphone;
	private String fromUserName;
	private HHGiftCardTransacStatus status;
	private Long hhCardId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRecvCellPhone() {
		return recvCellPhone;
	}

	public void setRecvCellPhone(String recvCellPhone) {
		this.recvCellPhone = recvCellPhone;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getFromUserCellphone() {
		return fromUserCellphone;
	}

	public void setFromUserCellphone(String fromUserCellphone) {
		this.fromUserCellphone = fromUserCellphone;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public HHGiftCardTransacStatus getStatus() {
		return status;
	}

	public void setStatus(HHGiftCardTransacStatus status) {
		this.status = status;
	}

	public Long getHhCardId() {
		return hhCardId;
	}

	public void setHhCardId(Long hhCardId) {
		this.hhCardId = hhCardId;
	}

	@Override
	public int compareTo(@NonNull HHGiftCardTransaction another) {
		return -this.createTime.compareTo(another.getCreateTime());
	}
}
