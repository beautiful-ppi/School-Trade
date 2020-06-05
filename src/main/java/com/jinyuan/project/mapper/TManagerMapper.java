package com.jinyuan.project.mapper;

import com.jinyuan.project.domain.TManager;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
public interface TManagerMapper {
    //
    List<TManager> selectAllManagers();

    //显示管理员总数
    //Integer selectAdminUserCounts(Page page);

    //分页显示管理员
    //List<TManager> selectAdminByPage(Page page);

    //添加新的管理员
    int insertAdminastrator(TManager tManager);

    //根据account查找管理员
    TManager selectAdminastratorByAccount(@Param("account")String account);

    //登录
    TManager selectAdminastratorByAccountAndPass(@Param("account")String account,@Param("password")String password);


    //编辑管理员，修改图片
    int updateManagerWithPhoto(@Param("password")String password,@Param("name")String name,
                                @Param("mobile")String mobile,@Param("weixin")String weixin,@Param("photo")String photo,@Param("_id")int _id);

    //根据管理员id显示管理员详细信息
    TManager selectDetailManageById(@Param("_id")int _id);

    //根据_id删除用户
    int deleteManagerById(@Param("_id")int _id);
}
