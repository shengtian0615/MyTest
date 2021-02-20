package com.wehealth.model.domain.model;

public class HHResult {
    private int status;
    private String message;

    public HHResult setProps(int name, String value) {
        this.status = name;
        this.message = value;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "status=" + status + "&message=" + message;
    }
}
