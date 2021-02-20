package com.wehealth.model.domain.enumutil;

import com.wehealth.model.domain.interfaceutil.NamedObject;

public enum MedicalExamState implements NamedObject {
    UPLOADED("已上传"),
    NOTUPLOAD("未上传"),
    NOTCOMPLETE("未完成"),
    PDFNOTUPLOAD("生成PDF未上传")
    ;

    private String text;

    private MedicalExamState(String text){
        this.text = text;
    }


    @Override
    public String getText()
    {
        return text;
    }
}
