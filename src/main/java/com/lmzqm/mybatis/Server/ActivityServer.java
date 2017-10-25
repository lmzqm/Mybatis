package com.lmzqm.mybatis.Server;

import com.lmzqm.mybatis.Entity.*;
import com.lmzqm.mybatis.Enum.HttpCodeEnum;
import com.lmzqm.mybatis.Mapper.ActivityMapper;
import com.lmzqm.mybatis.Mapper.ActivityStatusMapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lmzqm on 2017/7/11.
 */
@Service
public class ActivityServer {

    private static Logger logger = LoggerFactory.getLogger(ActivityServer.class);


    @Autowired
    private ActivityStatusMapper statusMapper;

    @Autowired
    private ActivityMapper activityMapper;

    /**
     * 获取所有的活动状态
     * @return 返回所有的状态
     */
    public List<ActivityStatus> getAllActivityStatus(){

        List<ActivityStatus> status = statusMapper.selectAll();
        if(status.isEmpty()){
            return new ArrayList<>();
        }

        return status;

    }

    /**
     * 通过Id获取状态值
     * @param id 状态id
     * @return 返回状态的信息
     */
    public ActivityStatus getAtatusById(Integer id){
        ActivityStatus status = statusMapper.selectByPrimaryKey(id);
        if(status == null){
            logger.info("不存在这个状态值"+id);
        }
        return status;
    }

    /**
     * 通过Id删除状态值
     * @param id 状态id
     * @return 返回是否成功
     */
    public Integer deleteStatusById(Integer id){

        Integer index = 0;
        try {

            index = statusMapper.deleteStatusByPrimaryKey(id);
            logger.info("the return index is"+index);


        }catch (Exception e){

            logger.error("发生错误"+e.getLocalizedMessage());
            index = -1;

        }finally {

            return index;
        }



    }

    /**
     * 更新状态的描述
     * @param status 状态
     * @return 返回是否成功
     */
    public Integer updateStatusByStatus(ActivityStatus status){
        Integer index = 0;
        logger.info("the status is"+status.toString());

       Runnable runnable = ()->System.out.println("Hello world");

       Thread[] threads = new Thread[10];
       for (int i = 0;i<10;i++){
           threads[i] = new Thread(runnable);
       }

        for ( Thread t: threads ) {
            t.start();
        }

        try {

            index = statusMapper.updateStatusByPrimaryKey(status);

        }catch (Exception e){

            index = -1;

        }finally {
            return index;
        }

    }

    /**
     * 添加状态信息
     * @param status 状态信息
     * @return 返回是否成功
     */
    public Integer addStatusByStatus(ActivityStatus status){
        Integer index = 0;
        logger.info("the status is"+status.toString());

        try {

            index = statusMapper.addStatus(status);

        }catch (Exception e){

            index = -1;

        }finally {
            logger.info("the index is" + index);
            return index;
        }
    }


    /**
     * 获取所有活动开始的活动
     * @return 返回活动简单介绍
     */
    public List<SimpleActivity> getAllActiveActivity( Integer status){

//        SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-dd");
//        String date = format.format(new Date());

        try {
            List<SimpleActivity> activitys = activityMapper.selectHomeActivitys(status);
            if (activitys.isEmpty()){
                logger.info("当前没有数据");
            }
            return activitys;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * 通过id来获取活动的详情
     * @param id 活动的id
     * @return 返回活动的详情
     */
    public ActivityDetail getActivityInfoById(Integer id){

        try {
            ActivityDetail activityInfo =  activityMapper.getActivityInfoById(id);
            return activityInfo;
        }
        catch (Exception e){
            logger.error("the error id "+e.getMessage());
            return null;
        }

    }
}
