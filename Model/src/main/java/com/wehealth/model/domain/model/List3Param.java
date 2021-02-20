package com.wehealth.model.domain.model;

public class List3Param {
    private int code;
    private int p_code;
    private String name;

    public List3Param setProps(int c, int pc, String n) {
        this.code = c;
        this.p_code = pc;
        this.name = n;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getP_code() {
        return p_code;
    }

    public void setP_code(int p_code) {
        this.p_code = p_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "List3Param{" +
                "code=" + code +
                ", p_code=" + p_code +
                ", name='" + name+'}';
    }
}
