package com.lzc.crud.util;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private int code;
    private String message;
    private Map<String,Object>data = new HashMap<>();

    public static Result success(){
        return new Result(200);
    }

    public static Result success(String message){
        return new Result(200,message);
    }

    public static Result fail(){
        return new Result(400);
    }

    public static Result fail(String msg){
        return new Result(msg);
    }

    public static Result fail(int code, String msg){
        return new Result(code, msg);
    }

    public Result add(String name,Object value) {
        this.getData().put(name,value);
        return this;
    }

    public Result delete(String name) {
        this.getData().remove(name);
        return this;
    }


    public Result(){

    }

    public Result(int code){
        this.code = code;
        this.message = "";
    }

    public Result(String msg){
        message = msg;
    }

    public Result(int code, String msg){
        this.code = code;
        this.message = msg;
    }


    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

}
