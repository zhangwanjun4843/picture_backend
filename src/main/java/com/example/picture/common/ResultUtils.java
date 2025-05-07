package com.example.picture.common;

import com.example.picture.exception.ErrorCode;

public class ResultUtils {
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    public static BaseResponse<?> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    public static BaseResponse<?> error(int code, String msg) {
        return new BaseResponse<>(code, null, msg);
    }

    public static BaseResponse<?> error(ErrorCode errorCode, String msg) {
        return new BaseResponse<>(errorCode.getCode(), null, msg);
    }

}
