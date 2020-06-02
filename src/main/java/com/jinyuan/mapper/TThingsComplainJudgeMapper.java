package com.jinyuan.mapper;

import com.jinyuan.domain.TThingsComplainJudge;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TThingsComplainJudgeMapper {
    //更新需求商品仲裁状态
    int updateRequestIsJudge(@Param("_id")int _id);

    //更新售卖商品仲裁状态
    int updateThingsJudgeState(@Param("_id")int _id);

    //对商品进行仲裁
    int insertJudgeResult(TThingsComplainJudge tThingsComplainJudge);

    //根据complain_id查看仲裁信息
    TThingsComplainJudge selectJudgeByComplain_id(@Param("_complain")int _complain);

    //查看申诉商品的仲裁结果
    Map<String,Object> selectThingsJudge(@Param("_thing")int _thing);

    //查看所有投诉和申诉信息
    List<Map<String,Object>> selectAllComplainAndResist();

    //未调解的投诉和申诉信息
    List<Map<String,Object>> selectComplainAndResistNoAccepted();

    //接受调解的投诉和申诉信息
    List<Map<String,Object>> selectComplainAndResistWithAccepted();

    //根据complain_id查看投诉申诉详情
    Map<String,Object> selectDetailComplainAndResistByComplain_id(@Param("_id")int _id);

    //设置为已调解状态
    int updateStateToAccepted(@Param("_complain")int _complain);
}
