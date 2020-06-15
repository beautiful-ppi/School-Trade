package com.jinyuan.framework.ExceptionHandler;

import com.alibaba.fastjson.JSONObject;
import com.jinyuan.framework.utils.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Aaron
 * @description :全局错误异常抛出
 * @Date 2020/6/1
 */
@ControllerAdvice
public class GloabllExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public JSONObject hanlderException(Exception e){
        e.printStackTrace();
        //抛出异常信息给前端
        JSONObject jsonObject=new JSONObject();
        //jsonObject.put("success",0);
        jsonObject.put("Code",HttpStatus.ERROR);
        jsonObject.put("message",e.getMessage()==null?"服务器发生错误！":e.getMessage());
        return jsonObject;
    }
}
