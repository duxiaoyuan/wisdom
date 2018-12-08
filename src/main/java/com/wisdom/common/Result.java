package com.wisdom.common;

/**
 * @author lib 2018/12/6
 */
public class Result {
    private boolean success;
    private Object data;

    public Result(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
