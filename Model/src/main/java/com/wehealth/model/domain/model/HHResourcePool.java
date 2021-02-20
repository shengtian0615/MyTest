package com.wehealth.model.domain.model;


import com.wehealth.model.domain.interfaceutil.Entity;

public class HHResourcePool extends AbstractTimeAuditable implements Entity {
	private Long id;
	private int packageId;
	private int maxCount;
	private int usedCount;
	
	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	@Override
	public Long getId() {
		return id;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}

	
	
}
