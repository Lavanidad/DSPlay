package com.deepspring.dsplay.common.exception;

/**
 * Created by Anonym on 2017/3/25.
 */

public class ApiException extends BaseException {

    public ApiException(int code, String displayMessage) {
        super(code, displayMessage);
    }
}
