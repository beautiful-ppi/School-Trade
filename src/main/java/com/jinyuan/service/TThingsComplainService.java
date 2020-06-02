package com.jinyuan.service;

import com.jinyuan.domain.TThingsComplain;
import com.jinyuan.framework.web.Result;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface TThingsComplainService {
    //投诉
    int insertComplain(TThingsComplain tthingsComplain);

    //投诉带图片
    Result insertComplainWithPhoto(int _id, String because, String memo,
                                   MultipartFile photo, HttpServletRequest request);

    //调整商品状态为被投诉
    int updateTthingsIsComplaint(@Param("_id")int _id);

    //调整需求商品状态为被投诉状态
    int updateTRequestIsComplaint(@Param("_id")int _id);

    //查看投诉信息
    Map<String, Object> selectComplaintInfos(@Param("_thing")int _thing);
}
