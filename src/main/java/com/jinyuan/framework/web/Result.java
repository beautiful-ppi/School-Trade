package com.jinyuan.framework.web;


import org.springframework.jdbc.core.ResultSetSupportingSqlParameter;

import java.util.HashMap;

/**
 * @author Aaron
 * @description :
 * @Date 2020/6/2
 */
public class Result extends HashMap<String,Object> {

    public static final String SUCCESS="success";
    public static final String MESSAGE="message";
    public static final String DATA="data";
    public static final String ID="id";

    public Result (){

    }

    public Result(int success,String msg){
        super.put(SUCCESS,success);
        super.put(MESSAGE,msg);
    }

    public Result(int success,String msg,Object data){
        super.put(SUCCESS,success);
        super.put(MESSAGE,msg);
        super.put(DATA,data);
    }

    public Result(int success,int id){
        super.put(SUCCESS,success);
        super.put(ID,id);
    }

    public Result(int success,String msg,int id){
        super.put(SUCCESS,success);
        super.put(MESSAGE,msg);
        super.put(ID,id);
    }
    /*
     * @Author: Aaron
     * @Param:
     * @Description: 操作成功返回
     *
     * @Date: 12:05 2020/6/2
     **/

    public static Result success(String msg){
        return new Result(0,msg);
    }

    public static Result success(String msg,Object data){
        return  new Result(0,msg,data);
    }
    public static Result success(int id){
        return new Result(0,id);
    }

    public static Result success(String msg,int id){
        return new Result(0,msg,id);
    }

    /*
     * @Author: Aaron
     * @Param:
     * @Description: 操作失败返回
     *
     * @Date: 12:05 2020/6/2
     **/
    public static Result error(String msg){
        return new Result(1,msg);
    }

    public static Result error(String msg,Object data){
        return  new Result(1,msg,data);
    }

}
