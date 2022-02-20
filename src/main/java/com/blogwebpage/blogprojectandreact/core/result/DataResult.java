package com.blogwebpage.blogprojectandreact.core.result;

public class DataResult<T> extends Result {
    private T data;


    public DataResult(boolean sucecss, T data) {
        super(sucecss);
        this.data = data;
    }

    public DataResult(boolean sucecss, T data, String message) {
        super(sucecss, message);
        this.data = data;
    }

    public T getData(){return this.data;}
}
