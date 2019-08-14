package com.liuniukeji.springcloud.common.entity;

/**
 * @author mxx
 * @Title: ResultInfo
 * @ProjectName test
 * @Description: 异步访问返回接口数据
 * @date 2018/11/58:30
 */
public class ResultInfo {

    private static final int SUCCESS_CODE = 200;

    private static final int FAILED_CODE = 500;

    private int resultCode ;

    private String resultMessage ;

    private Object resultObject ;

    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static int getFailedCode() {
        return FAILED_CODE;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }
}
