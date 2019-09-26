package com.ank.cms.model.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResultInfo<T> {
    private String code;
    private String msg;
    private T result;

    public static final String codeSuccessfully = "000000";
    public static final String codeFailure = "000001";
    public static final String notLoginError = "100001";

    public ResultInfo() {
        super();
    }

    /**
     * 初始化返回信息
     *
     * @param code
     * @param msg
     * @param result
     */
    public ResultInfo(String code, String msg, T result) {
        super();
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    /**
     * 初始化返回信息
     *
     * @param result
     */
    public ResultInfo(T result) {
        super();
        this.code = ResultInfo.codeSuccessfully;
        this.msg = "";
        this.result = result;
    }

    /**
     * @param result 成功需要返回的对象
     * @return 直接返回resultInfo对象
     */
    public static <T> ResultInfo<T> success(T result) {
        return new ResultInfo(result);
    }

    /**
     * @param result 成功需要返回的对象  msg传递给前台的信息
     * @return 直接返回resultInfo对象
     */
    public static <T> ResultInfo<T> success(T result, String msg) {
        return new ResultInfo(codeSuccessfully, msg, result);
    }

    /**
     * @param msg 失败返回前台的结果
     * @return 直接返回resultInfo对象
     */
    public static <T> ResultInfo<T> error(String msg) {
        return new ResultInfo(codeFailure, msg, null);
    }

    /**
     * 判断返回是否成功
     */
    @JsonIgnore
    public static boolean isSuccess(ResultInfo resultInfo) {
        return null != resultInfo && ResultInfo.codeSuccessfully.equals(resultInfo.getCode());
    }

    @JsonIgnore
    public static boolean isSuccessAndDataNotNull(ResultInfo resultInfo) {
        return isSuccess(resultInfo) && null != resultInfo.getResult();
    }

    public void setCode(String value) {
        this.code = value;
    }

    public String getCode() {
        return this.code;
    }

    public void setMsg(String value) {
        this.msg = value;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setResult(T value) {
        this.result = value;
    }

    public T getResult() {
        return this.result;
    }
}