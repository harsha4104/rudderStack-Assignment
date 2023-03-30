package com.rudderstack.source.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class APIResponseGeneric<T> {
    public String statusCode;
    public String responseCode;
    public String message;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    public T data;
    public APIResponseGeneric.APIError error;


    public APIResponseGeneric() {
        this.statusCode = "2XX";
    }

    public APIResponseGeneric(T data) {
        this.statusCode = "2XX";
        this.responseCode = "2XX";
        this.data = data;
    }

    public APIResponseGeneric(T data, String errorMessage){
        this.statusCode = "2XX";
        this.data = data;
        this.error = new APIResponseGeneric.APIError(errorMessage);
    }

    public APIResponseGeneric(String statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.error = new APIResponseGeneric.APIError(errorMessage);
    }

    public static class APIError implements Serializable {
        private String msg = "Some error occurred, please try again later";

        public APIError() {
        }

        public APIError(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String toString() {
            return "{msg=" + this.msg + "}";
        }
    }

}
