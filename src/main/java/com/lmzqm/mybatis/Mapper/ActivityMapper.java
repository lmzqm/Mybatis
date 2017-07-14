package com.lmzqm.mybatis.Mapper;

import com.lmzqm.mybatis.Entity.Activity;
import com.lmzqm.mybatis.Entity.ActivityDetail;
import com.lmzqm.mybatis.Entity.SimpleActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lmzqm on 2017/7/12.
 */
@Mapper
public interface ActivityMapper {

    /**
     * 获取所有开启的活动
     * @return 活动列表
     */
    List<SimpleActivity> selectHomeActivitys(@Param("status") Integer status);

    /**
     * 获取活动的详情
     * @param id 活动id
     * @return 返回活动的详情
     */
    ActivityDetail getActivityInfoById(@Param("id") Integer id);


}
