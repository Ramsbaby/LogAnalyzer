package com.ramsbaby.parser.common.type;

import lombok.Getter;

/**
 * @author : ramsbaby
 * @name : StatusCode.java
 * @date : 2021-07-21 오전 3:12
 **/

@Getter
public enum StatusCode {
    ERROR(10), SUCCESS(200), NOT_FOUND(404);

    private int status;

    StatusCode(int status) {
        this.status = status;
    }

    public static StatusCode valueOf(int code) {
        switch (code) {
            case 10:
                return ERROR;
            case 200:
                return SUCCESS;
            case 404:
                return NOT_FOUND;
        }

        return null;
    }
}
