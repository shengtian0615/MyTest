package com.wehealth.model.domain.nalon;

public class UploadConfig {

	private int fileServiceType;
	private OssConfig ossConfig;

	public int getFileServiceType() {
		return fileServiceType;
	}
	public void setFileServiceType(int fileServiceType) {
		this.fileServiceType = fileServiceType;
	}
	public OssConfig getOssConfig() {
		return ossConfig;
	}
	public void setOssConfig(OssConfig ossConfig) {
		this.ossConfig = ossConfig;
	}
}
