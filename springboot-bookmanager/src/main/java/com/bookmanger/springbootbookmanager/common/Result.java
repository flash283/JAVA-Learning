package com.bookmanger.springbootbookmanager.common;

public class Result <T> {
    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 成功（带数据）
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "成功", data);
    }

    // 成功（不带数据，例如删除成功）
    public static <T> Result<T> success() {
        return new Result<>(200, "成功", null);
    }

    // 默认失败（500）
    public static <T> Result<T> error(String msg) {
        return new Result<>(500, msg, null);
    }

    // 自定义状态码（比如 401）
    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
