package com.jinyuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.jinyuan.domain.TManager;
import com.jinyuan.framework.annotation.PassToken;
import com.jinyuan.framework.token.TokenService;
import com.jinyuan.framework.web.Result;
import com.jinyuan.service.impl.TManegerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin
public class TManagerController {
    @Autowired
    TManegerServiceImpl tManagerServiceImpl;
    @Autowired
    TokenService tokenService;


    //分页显示管理员信息
    @RequestMapping(value="selectAdminByPage")//produces="text/json;charset=UTF-8"
    @PassToken
    public Result selectAdminByPage() {

        List<TManager> tManagerList=tManagerServiceImpl.selectAllManagers();

        return Result.success("管理员信息",tManagerList);
    }

    /**
     * 根据当前页获取开始行
     * @param currentPage
     * @param pageSize
     * @return
     */

    public int getStartRowBycurrentPage(int currentPage,int pageSize){

        int startRow=0;

        if (currentPage==1) {

            return startRow=0;
        }

        startRow=(currentPage-1)*pageSize;

        return startRow;

    }

    //根据管理员id显示管理员详细信息
    @RequestMapping(value="selectDetailManageById/{_id}")
    public Result selectDetailManageById(@PathVariable("_id")int _id){
        TManager tManager=tManagerServiceImpl.selectDetailManageById(_id);

        return Result.success("显示管理员详细信息",tManager);
    }

    //根据_id删除管理员
    @RequestMapping(value="deleteManagerById/{_id}")
    public Result deleteManagerById(@PathVariable("_id")int _id) {

        int row=tManagerServiceImpl.deleteManagerById(_id);
        if (row>0){
            return Result.success("删除管理员成功！");
        }
        return Result.error("删除管理员失败！");
    }

    //修改管理员信息
    @RequestMapping(value="updateManager")
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
    public String ManagerLogout(){

        return null;
    }



    //添加新的管理员
    @RequestMapping(value="insertAdminastrator")
    public Result insertAdminastrator(@RequestParam("account")String account,@RequestParam("password")String password,
                                      @RequestParam("name")String name,@RequestParam("mobile")String mobile,
                                      @RequestParam("weixin")String weixin,@RequestParam(required=false,value="photo") MultipartFile photo,
                                      HttpServletRequest request){

        return tManagerServiceImpl.insertAdminastrator(account, password, name, mobile, weixin, photo,request);
    }
}
