package com.jinyuan.service;

import com.jinyuan.domain.TManager;
import com.jinyuan.framework.web.Result;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TManagerService {

    //显示所有管理员数，前台实现分页
    List<TManager> selectAllManagers();
    //显示管理员总数
    //Integer selectAdminUserCounts(Page page);

    //分页显示管理员
    //List<TManager> selectAdminByPage(Page page);

    //添加新的管理员
    Result insertAdminastrator(String account, String password, String name,
                               String mobile, String weixin, MultipartFile photo, HttpServletRequest request);

    //根据account查找管理员存不存在
    TManager selectAdminastratorByAccount(@Param("account")String account);

    //登录
    TManager selectAdminastratorByAccountAndPass(String account,String password);


    //编辑管理员，修改图片
    int updateManagerWithPhoto(String password, String name,
                               String mobile, String weixin, int _id, MultipartFile photo, HttpServletRequest request);

    //根据_id删除用户
    int deleteManagerById(int _id);

    //根据管理员id显示管理员详细信息
    TManager selectDetailManageById(int _id);
}
