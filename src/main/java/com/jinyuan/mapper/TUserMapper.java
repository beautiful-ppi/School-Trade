package com.jinyuan.mapper;



import com.jinyuan.domain.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/26
 */
//@Mapper
public interface TUserMapper {
    //查找每个月份注册用户数量
    Map<String,Object> selectUserCountsByMonth(@Param("value1")int value1,
                                               @Param("value2")int value2, @Param("value3")int value3, @Param("value4")int value4,
                                               @Param("value5")int value5, @Param("value6")int value6, @Param("value7")int value7,
                                               @Param("value8")int value8, @Param("value9")int value9, @Param("value10")int value10,
                                               @Param("value11")int value11, @Param("value12")int value12);

    //所有不诚信用户 分页交给前台
    List<TUser> selectUnhonestUsers();

    //条件查询不诚信用户
    List<TUser> selectUnhonesUsersByCondition(String queryCondition);

    //查询所有用户分页交给前台
    List<TUser> selectAllUsers();

    //条件查询
    List<TUser> selectUsersByCondition(String queryCondition);

    //不诚信交易详情信息
    Map<String,Object> selectUnhonestTradeDetail(@Param("_id")int _id);

    //查看不诚信用户类型
    List<Map<String,Object>> selectDetailUnhonestUser(@Param("request_provider")int request_provider,@Param("_owner")int _owner);

    //条件查询不诚信用户
    //List<Map<String,Object>> selectUnhonestUserByCondition(Page page);

    //分页显示不诚信用户
    //List<Map<String,Object>> selectUnhonestUser(Page page);

    //所有不诚信用户信息
    //Integer selectTotalUnhonestUser(Page page);

    //根据条件显示用户信息
    //List<TUser> selectUserWithPageByCondition(Page page);

    //查找总用户数
    //Integer selectAllUserCounts(Page page);

    //分页显示用户信息
    //List<TUser> selectUserByPage(Page page);

    //重置密码
    int resetPassword(@Param("_id")int _id);

    //启用用户
    int startUser(@Param("_id")int _id);

    //禁用用户
    int forbiddenUser(@Param("_id")int _id);

    //根据_id查找详情信息
    TUser selectUserDetailInfo(@Param("_id")int _id);

    //根据账号或姓名查询用户
    List<TUser> selectUserByAccountAndName(@Param("name")String name,@Param("account")String account);

    //修改个人信息不带图片
    int updatePersonalInfoNoPhoto(@Param("name")String name,@Param("mobile")String mobile,
                                   @Param("weixin")String weixin,@Param("department")String department,
                                   @Param("_class")String _class,@Param("_id")int _id);

    //修改个人信息带图片
    int updatePersonalInfoWithPhoto(@Param("name")String name,@Param("mobile")String mobile,
                                     @Param("weixin")String weixin,@Param("department")String department,
                                     @Param("_class")String _class,@Param("photo")String photo,@Param("_id")int _id);


    //登录
    TUser selectUserByAccountAndPassword(@Param("account")String account,@Param("password")String password);

    //查找所有用户
    List<TUser> selectAllUser();

    //注册
    int insertUserWithPhoto(TUser tuser);

    //判断用户是否已经存在
    TUser selectUserByAccount(@Param("account")String account);

    //查看我的交易
    List<Map<String,Object>> selectMyTrade();

    //查看个人信息
    Map<String,Object> selectPersonInformation(@Param("_user1")int _user1,@Param("_user2")int _user2,@Param("_id")int _id);
}
