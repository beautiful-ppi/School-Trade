package com.jinyuan.project.mapper;

import com.jinyuan.project.domain.TThingsComplain;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface TThingsComplainMapper {
    //投诉
    int insertComplain(TThingsComplain tthingsComplain);

    //投诉带图片
    int insertComplainWithPhoto(TThingsComplain tthingsComplain);

    //调整售卖商品状态为被投诉
    int updateTthingsIsComplaint(@Param("_id")int _id);

    //调整需求商品状态为被投诉状态
    int updateTRequestIsComplaint(@Param("_id")int _id);

    //查看投诉信息
    Map<String,Object> selectComplaintInfos(@Param("_thing")int _thing);
}
