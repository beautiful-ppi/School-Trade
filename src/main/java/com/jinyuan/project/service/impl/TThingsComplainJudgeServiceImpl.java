package com.jinyuan.project.service.impl;

import com.jinyuan.project.domain.TThingsComplainJudge;
import com.jinyuan.framework.web.Result;
import com.jinyuan.project.mapper.TThingsComplainJudgeMapper;
import com.jinyuan.project.service.TThingsComplainJudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@Service
public class TThingsComplainJudgeServiceImpl implements TThingsComplainJudgeService {

    @Autowired
    TThingsComplainJudgeMapper tthingsComplainJudgeMapper;


    //查看申诉商品的仲裁结果
    @Override
    public Map<String, Object> selectThingsJudge(int _thing) {

        Map<String,Object> map= tthingsComplainJudgeMapper.selectThingsJudge(_thing);
        return  map;
    }

    //查看所有申诉和投诉信息
    @Override
    @Cacheable(value = "selectAllComplainAndResist",keyGenerator = "keyGenerator")
    public List<Map<String, Object>> selectAllComplainAndResist() {

            List<Map<String,Object>> mapList= tthingsComplainJudgeMapper.selectAllComplainAndResist();
            return mapList;
    }

    //未调解的投诉和申诉信息
    @Override
    public List<Map<String, Object>> selectComplainAndResistNoAccepted() {

            List<Map<String,Object>> mapList=tthingsComplainJudgeMapper.selectComplainAndResistNoAccepted();

            return mapList;
    }

    // 接受调解的投诉和申诉信息
    @Override
    public List<Map<String, Object>> selectComplainAndResistWithAccepted() {

            List<Map<String,Object>> mapList=tthingsComplainJudgeMapper.selectComplainAndResistWithAccepted();
            return mapList;
    }

    //根据complain_id查看投诉申诉详情
    @Override
    public Map<String, Object> selectDetailComplainAndResistByComplain_id(int _id) {

            Map<String,Object> map=tthingsComplainJudgeMapper.selectDetailComplainAndResistByComplain_id(_id);
            return map;
    }

    //设置为已调解状态
    @Override
    public Result updateStateToAccepted(int _complain) {

            if(tthingsComplainJudgeMapper.selectJudgeByComplain_id(_complain).getIsAccepted()==1){

                return Result.error("处于已调解状态，无需调解");

            }else {
                int row=tthingsComplainJudgeMapper.updateStateToAccepted(_complain);
                if (row>0){
                    return Result.success("设置调解成功！");
                }
                return Result.error("设置调解失败！");
            }

    }

    //根据complain_id查看仲裁信息
    @Override
    public TThingsComplainJudge selectJudgeByComplain_id(int _complain) {
        // TODO Auto-generated method stub
        return tthingsComplainJudgeMapper.selectJudgeByComplain_id(_complain);
    }

    //对商品进行仲裁
    @Override
    public Result insertJudgeResult(int _complain, String judge, int thing_id) {

        TThingsComplainJudge tThingsComplainJudge=new TThingsComplainJudge();
        tThingsComplainJudge.set_id((int)Math.round(Math.random()*100000000));
        tThingsComplainJudge.setIsAccepted(0);
        tThingsComplainJudge.set_complain(_complain);
        tThingsComplainJudge.setJudge(judge);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tThingsComplainJudge.setJudge_date(sdf.format(date));

            int row1=tthingsComplainJudgeMapper.insertJudgeResult(tThingsComplainJudge);
            int row2=tthingsComplainJudgeMapper.updateThingsJudgeState(thing_id);
            int row3=tthingsComplainJudgeMapper.updateRequestIsJudge(thing_id);
            if (row1>0||row2>0||row3>0){
                return Result.success("商品仲裁成功",tThingsComplainJudge.get_id());
            }
            return Result.error("商品仲裁失败");

    }

    //更新售卖商品仲裁状态
    @Override
    public int updateThingsJudgeState(int _id) {

        return tthingsComplainJudgeMapper.updateThingsJudgeState(_id);
    }

    //更新需求商品仲裁状态
    @Override
    public void updateRequestIsJudge(int _id) {

        //tthingsComplainJudgeMapper.updateRequestIsJudge(_id);
    }

}
