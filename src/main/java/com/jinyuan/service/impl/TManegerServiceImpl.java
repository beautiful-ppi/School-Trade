package com.jinyuan.service.impl;

import com.jinyuan.domain.TManager;
import com.jinyuan.framework.web.Result;
import com.jinyuan.mapper.TManagerMapper;
import com.jinyuan.service.TManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@Service
public class TManegerServiceImpl implements TManagerService {

    @Autowired
    TManagerMapper tmanagerMapper;


    //添加新的管理员
    @Override
    public Result insertAdminastrator(String account, String password, String name,
                                      String mobile, String weixin, MultipartFile photo, HttpServletRequest request) {

        TManager tManager=new TManager();
        //tManager.set_id((int)Math.round(Math.random()*100000000));
        tManager.setAccount(account);
        tManager.setPassword(password);
        tManager.setName(name);
        tManager.setMobile(mobile);
        tManager.setWeixin(weixin);
        tManager.setLevel(2);
        tManager.setState(1);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        tManager.setCreate_date(sdf.format(date));



        try {
            if(photo!=null){
                //图片不为空
                InputStream input=photo.getInputStream();
                OutputStream out=new FileOutputStream(request.getSession().getServletContext().getRealPath("/images/"+photo.getOriginalFilename()));
                byte[] bs=new byte[1024];
                int len=-1;

                while((len=input.read(bs))!=-1) {
                    out.write(bs, 0, len);
                }
                tManager.setPhoto(photo.getOriginalFilename());
            }

        }catch(Exception e) {
            e.getLocalizedMessage();
        }


        //判断是否存在账号
        if(tmanagerMapper.selectAdminastratorByAccount(account)!=null) {
            return Result.error("账号已存在！");
        }

        int row=tmanagerMapper.insertAdminastrator(tManager);
        if (row>0){
            return Result.success("新增管理员成功！",tManager.get_id());
        }
        return Result.error("新增管理员成功！");

    }

    //根据account查找管理员存不存在
    @Override
    public TManager selectAdminastratorByAccount(String account) {
        return tmanagerMapper.selectAdminastratorByAccount(account);
    }

    //登录
    @Override
    public TManager selectAdminastratorByAccountAndPass(String account, String password) {


        TManager  tManager  =tmanagerMapper.selectAdminastratorByAccountAndPass(account, password);

        return tManager;

    }




    //编辑管理员,修改图片
    @Override
    public int updateManagerWithPhoto(String password, String name,
                                      String mobile, String weixin, int _id, MultipartFile photo, HttpServletRequest request) {

        String photoName="";
        //保存图片
        if (photo!=null){
            photoName=photo.getOriginalFilename();

            try {
                //处理图片数据流
/*                InputStream input= null;
                input = photo.getInputStream();
                OutputStream out=new FileOutputStream(request.getSession().getServletContext().getRealPath("/images/"+photo.getOriginalFilename()));
                byte[] bs=new byte[1024];
                int len=-1;

                while((len=input.read(bs))!=-1) {
                    out.write(bs, 0, len);
                }
                input.close();
                out.flush();
                out.close();*/
                photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/images/"+photo.getOriginalFilename())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int row=tmanagerMapper.updateManagerWithPhoto(password, name, mobile, weixin, photoName, _id);
        return row;
    }

    //根据_id删除用户
    @Override
    public int deleteManagerById(int _id) {

        return tmanagerMapper.deleteManagerById(_id);
    }

    //根据管理员id显示管理员详细信息
    @Override
    public TManager selectDetailManageById(int _id) {
            TManager tManager=tmanagerMapper.selectDetailManageById(_id);
        return tManager;
    }




    //显示所有管理员数，前台实现分页
    @Override
    public List<TManager> selectAllManagers() {

        List<TManager> tManagerList= tmanagerMapper.selectAllManagers();

        return tManagerList;

    }
}
