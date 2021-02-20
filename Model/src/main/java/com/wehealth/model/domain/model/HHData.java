package com.wehealth.model.domain.model;

public class HHData {
    private String bp; //血氧
    private String createTime; //数据产生时间
    private String dbp; //舒张压
    private String hr; //心跳
    private String sbp; //收缩压
    private String ecgUrl; //心电数据（json）
    private String tire; //疲劳指数
    private String mpa; //压力指数

    public String getBp() {
        return bp;
    }
    public void setBp(String bp) {
        this.bp = bp;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getDbp() {
        return dbp;
    }
    public void setDbp(String dbp) {
        this.dbp = dbp;
    }
    public String getHr() {
        return hr;
    }
    public void setHr(String hr) {
        this.hr = hr;
    }
    public String getSbp() {
        return sbp;
    }
    public void setSbp(String sbp) {
        this.sbp = sbp;
    }
    public String getEcgUrl() {
        return ecgUrl;
    }
    public void setEcgUrl(String ecgUrl) {
        this.ecgUrl = ecgUrl;
    }
    public String getTire() {
        return tire;
    }
    public void setTire(String tire) {
        this.tire = tire;
    }
    public String getMpa() {
        return mpa;
    }
    public void setMpa(String mpa) {
        this.mpa = mpa;
    }
}
