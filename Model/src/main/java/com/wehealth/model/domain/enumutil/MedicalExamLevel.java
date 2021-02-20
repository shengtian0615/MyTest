package com.wehealth.model.domain.enumutil;

import com.wehealth.model.domain.interfaceutil.NamedObject;

public enum MedicalExamLevel implements NamedObject {
    NOTCOMPLETE("尚未完成所有体检项目，请继续检查"),
    NOMAL("体检结果大致正常，详情点击查看报告"),
    PARTABNOMAL("体检结果部分异常，详情点击查看报告"),
    SERIOUSABNOMAL("体检结果显示有严重异常，请查看报告并及时就医")
    ;

    private String text;

    private MedicalExamLevel(String text){
        this.text = text;
    }


    @Override
    public String getText()
    {
        return text;
    }
}
