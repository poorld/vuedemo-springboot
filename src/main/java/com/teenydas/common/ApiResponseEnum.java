package com.teenydas.common;

/**
 * @Author Administrator
 * @Date 2018-08-22.
 * @Email teenyda@gmail.com
 */
public enum ApiResponseEnum {
    SUCCESS(0,"成功"),
    FAIL(-1,"失败"),
    ERROR_PARAM(-2,"参数错误")
    ;
    private int code;
    private String name;

    ApiResponseEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
