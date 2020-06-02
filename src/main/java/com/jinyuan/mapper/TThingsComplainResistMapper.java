package com.jinyuan.mapper;

import com.jinyuan.domain.TThingsComplainResist;
import org.springframework.data.repository.query.Param;

public interface TThingsComplainResistMapper {
    //申诉
    int insertComplainResist(TThingsComplainResist tthingsComplainResist);

    // 调整售卖商品为已申诉状态
    int updateThingsIsResist(@Param("_id")int _id);

    //调整需求商品为已申诉状态
    int updateRequestIsResist(@Param("_id")int _id);
}
