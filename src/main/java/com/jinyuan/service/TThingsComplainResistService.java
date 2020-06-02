package com.jinyuan.service;

import com.jinyuan.framework.web.Result;
import org.springframework.data.repository.query.Param;

public interface TThingsComplainResistService {
    //申诉
    Result insertComplainResist(int _complain, String resist, int _thing);

    //调整售卖商品为已申诉状态
    int updateThingsIsResist(@Param("_id")int _id);

    //调整需求商品为已申诉状态
    int updateRequestIsResist(@Param("_id")int _id);
}
