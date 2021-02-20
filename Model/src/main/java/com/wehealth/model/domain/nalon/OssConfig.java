package com.wehealth.model.domain.nalon;

public class OssConfig {

	private String ossCallbackUrl;
	private String filePathPrefix;
	private String ossCallbackBody;
	private String ossEndpoint;
	private String ossBucket;
	private StsToken stsToken;
	
	
	public String getOssCallbackUrl() {
		return ossCallbackUrl;
	}
	public void setOssCallbackUrl(String ossCallbackUrl) {
		this.ossCallbackUrl = ossCallbackUrl;
	}
	public String getFilePathPrefix() {
		return filePathPrefix;
	}
	public void setFilePathPrefix(String filePathPrefix) {
		this.filePathPrefix = filePathPrefix;
	}
	public String getOssCallbackBody() {
		return ossCallbackBody;
	}
	public void setOssCallbackBody(String ossCallbackBody) {
		this.ossCallbackBody = ossCallbackBody;
	}
	public String getOssEndpoint() {
		return ossEndpoint;
	}
	public void setOssEndpoint(String ossEndpoint) {
		this.ossEndpoint = ossEndpoint;
	}
	public String getOssBucket() {
		return ossBucket;
	}
	public void setOssBucket(String ossBucket) {
		this.ossBucket = ossBucket;
	}
	public StsToken getStsToken() {
		return stsToken;
	}
	public void setStsToken(StsToken stsToken) {
		this.stsToken = stsToken;
	}
}
