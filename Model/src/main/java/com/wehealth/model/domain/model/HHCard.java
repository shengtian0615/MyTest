package com.wehealth.model.domain.model;

import com.wehealth.model.domain.enumutil.HHCardSource;
import com.wehealth.model.domain.enumutil.HHCardStatus;
import com.wehealth.model.domain.interfaceutil.Entity;


public class HHCard extends AbstractFullyAuditableEntity implements Entity {
	private Long id;
	private VideoServicePackage videoServicePck;//套餐详情
	private HHCardSource source;//套餐卡来源
	private String ownerID;//该卡拥有者
	private HHCardStatus status;//状态

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	public HHCardSource getSource() {
		return source;
	}

	public void setSource(HHCardSource source) {
		this.source = source;
	}

	public HHCardStatus getStatus() {
		return status;
	}

	public void setStatus(HHCardStatus status) {
		this.status = status;
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	public VideoServicePackage getVideoServicePck() {
		return videoServicePck;
	}

	public void setVideoServicePck(VideoServicePackage videoServicePck) {
		this.videoServicePck = videoServicePck;
	}
}
