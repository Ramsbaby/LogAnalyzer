package com.ramsbaby.parser.common.type;

/**
 * @author RAMSBABY
 * @date 2021-07-21 오전 1:55
 */

public enum StatusCode {
    ERROR(10), SUCCESS(200), NOT_FOUND(404);

    private int status;

    StatusCode(int status){
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}
