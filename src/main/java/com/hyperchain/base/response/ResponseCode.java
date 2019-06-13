package com.hyperchain.base.response;


public enum ResponseCode {

    SUCCESS(true, "000000", "成功"),
    USER_NOT_EXIT(true, "000001", "用户不存在"),
    DEFAULT_FAIL(false, "999999", "系统异常");
    private Boolean isSuccess;
    private String code;
    private String msg;


    ResponseCode(Boolean isSuccess, String code, String msg) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
