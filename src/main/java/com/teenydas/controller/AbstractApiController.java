package com.teenydas.controller;

import com.teenydas.common.ApiResponseObject;

/**
 * @Author Administrator
 * @Date 2018-08-22.
 * @Email teenyda@gmail.com
 */
public abstract class AbstractApiController {
    public ApiResponseObject responseJSON(int code, String errorMsg, Object resData) {
        ApiResponseObject apiResponseObject = new ApiResponseObject();
        apiResponseObject.setErrorCode(code);
        apiResponseObject.setErrorMsg(errorMsg);
        apiResponseObject.setData(resData);
        return apiResponseObject;
    }
}
