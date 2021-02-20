package com.wehealth.model.util;

import android.text.TextUtils;

import com.wehealth.model.domain.model.ResultPassHelper;

import org.json.JSONObject;

public class ParseRetrofitError {
    public static ResultPassHelper parse(String errorJson) {
        ResultPassHelper rph = new ResultPassHelper();
        rph.setName(Constant.ERROR);
        rph.setValue(Constant.CONNECT_WORK_TIMEOUT);
        if (TextUtils.isEmpty(errorJson)){
            return rph;
        }
        try{
            JSONObject jsonObject = new JSONObject(errorJson);
            String value = jsonObject.getString("error");
            rph.setName(Constant.ERROR);
            if (value.equals(Constant.INVALID_CLIENT)){
                rph.setValue(Constant.INVALID_CLIENT);
            }else if(value.equals(Constant.UNAUTHORIZED_CLIENT)){
                rph.setValue(Constant.UNAUTHORIZED_CLIENT);
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return rph;
    }
}
