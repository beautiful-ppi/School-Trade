package com.jinyuan.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.jinyuan.framework.annotation.ManagerLoginToken;
import com.jinyuan.project.domain.TManager;
import com.jinyuan.framework.token.TokenService;
import com.jinyuan.framework.web.Result;
import com.jinyuan.project.service.impl.TManegerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@RestController
@CrossOrigin()
public class TManagerController {
    @Autowired
    TManegerServiceImpl tManagerServiceImpl;
    @Autowired
    TokenService tokenService;

    private static final Logger log= LoggerFactory.getLogger(TManagerController.class);

    //分页显示管理员信息
    @RequestMapping(value="selectAdminByPage")//produces="text/json;charset=UTF-8"
    //@ManagerLogin
    public Result selectAdminByPage(@RequestParam(value = "pageNo" ,required=false)int pageNo,@RequestParam(value = "pageSize" ,required=false)int pageSize) {

        List<TManager> tManagerList=tManagerServiceImpl.selectAllManagers(pageNo,pageSize);

        return Result.success("管理员信息",tManagerList);
    }


    //根据管理员id显示管理员详细信息
    @RequestMapping(value="selectDetailManageById/{_id}")
    //@ManagerLoginToken
    public Result selectDetailManageById(@PathVariable("_id")int _id){
        TManager tManager=tManagerServiceImpl.selectDetailManageById(_id);

        return Result.success("显示管理员详细信息",tManager);
    }

    //根据_id删除管理员
    @RequestMapping(value="deleteManagerById/{_id}")
    @ManagerLoginToken
    public Result deleteManagerById(@PathVariable("_id")int _id) {

        //判断是否是超级管理员
        if (_id==123456789){
            return Result.error("admin超级管理员不可以删除");
        }
        int row=tManagerServiceImpl.deleteManagerById(_id);
        if (row>0){
            return Result.success("删除管理员成功！");
        }
        return Result.error("删除管理员失败！");
    }

    //修改管理员信息
    @RequestMapping(value="updateManager")
    @ManagerLoginToken
    public Result updateManager(@RequestParam("_id")int _id, @RequestParam(required=false,value="photo")MultipartFile photo,
                                @RequestParam("password")String password, @RequestParam("name")String name, @RequestParam("mobile")String mobile, @RequestParam("weixin")String weixin, HttpServletRequest request) throws IOException{

        int row=tManagerServiceImpl.updateManagerWithPhoto(password, name, mobile, weixin, _id, photo,request);
        if (row>0){
            return Result.success("管理员修改成功！");
        }
        return Result.error("管理员修改失败！");
    }


    //管理员登录
    @RequestMapping(value="selectAdminastratorByAccountAndPass")
    @ResponseBody
    public JSONObject selectAdminastratorByAccountAndPass(@RequestParam("account")String account,@RequestParam("password")String password) {

        JSONObject jsonObject=new JSONObject();

        log.debug("管理员登录账号密码----",account+password);

        TManager tManager=tManagerServiceImpl.selectAdminastratorByAccountAndPass(account, password);
        if (tManager==null){
            jsonObject.put("success",1);
            jsonObject.put("message","用户名或者账号错误，请重新输入！");
            return jsonObject;
        }else {
            if (tManager.getState()!=1){
                jsonObject.put("success",1);
                jsonObject.put("message","由于不诚信行为,此账号已被禁用!");
                return jsonObject;
            }

            String token= tokenService.getTokenManager(tManager);
            jsonObject.put("success",0);
            jsonObject.put("mtoken", token);
            jsonObject.put("managername", tManager.getAccount());
            return jsonObject;
        }
    }

    //管理员注销
    @RequestMapping("/ManagerLogout")
    public Result ManagerLogout(HttpServletRequest request){
        String token = request.getHeader("token");
        if (token==null){
            return Result.error("无token！");
        }
        if (!tokenService.deleteToken(token)){
            return Result.success("注销失败！token未删除！");
        }
        return Result.success("注销成功！");
    }



    //添加新的管理员
    @RequestMapping(value="insertAdminastrator")
    @ManagerLoginToken
    public Result insertAdminastrator(@RequestParam("account")String account,@RequestParam("password")String password,
                                      @RequestParam("name")String name,@RequestParam("mobile")String mobile,
                                      @RequestParam("weixin")String weixin,@RequestParam(required=false,value="photo") MultipartFile photo,
                                      HttpServletRequest request){

        return tManagerServiceImpl.insertAdminastrator(account, password, name, mobile, weixin, photo,request);
    }
}
