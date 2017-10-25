package com.lmzqm.mybatis.Mapper;

import com.lmzqm.mybatis.Entity.Scale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lmzqm on 2017/8/28.
 */
@Mapper
public interface ScaleMapper {

    Scale getScaleInfoById(@Param("id") Integer id);

    Integer addNewScaleInfo(Scale scale);

    List<Scale> getScaleList();

    Integer addNewTestPersonsById(@Param("id") Integer id);


}
