package com.lmzqm.mybatis.Mapper;

import com.lmzqm.mybatis.Entity.ActivityStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lmzqm on 2017/7/10.
 */
@Mapper
public interface ActivityStatusMapper {

    List<ActivityStatus> selectAll();

    ActivityStatus selectByPrimaryKey(@Param("id") Integer id);

    Integer deleteStatusByPrimaryKey(@Param("id") Integer id);

    Integer updateStatusByPrimaryKey(ActivityStatus status);

    Integer addStatus(ActivityStatus status);

}
