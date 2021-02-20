package com.wehealth.model.domain.model;

import java.io.Serializable;

public class PatientNick implements Serializable {
    private String nick;
    private String idCardNo;
    private String name;
    private String registerIdCardNo;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterIdCardNo() {
        return registerIdCardNo;
    }

    public void setRegisterIdCardNo(String registerIdCardNo) {
        this.registerIdCardNo = registerIdCardNo;
    }

}
