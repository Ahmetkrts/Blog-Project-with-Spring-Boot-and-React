package com.blogwebpage.blogprojectandreact.core.result;

public class Result {

    private boolean success;
    private String message;

    public Result(boolean sucecss) {
        this.success = sucecss;
    }

    public Result(boolean sucecss, String message) {
        this(sucecss);
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }
}
