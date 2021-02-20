package com.wehealth.model.domain.model;

import java.util.Map;

public class LiBangResult {
    private String Status;
    private String Message;
    private Map<String, String> Data;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Map<String, String> getData() {
        return Data;
    }

    public void setData(Map<String, String> data) {
        Data = data;
    }
}
