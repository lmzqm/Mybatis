package com.lmzqm.mybatis.Mapper;

import com.lmzqm.mybatis.Entity.ScaleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lmzqm on 2017/8/28.
 */
@Mapper
public interface ScaleTypeMapper {

    Integer addNewType(ScaleType type);

    ScaleType getTypeInfoById(@Param("id") Integer id);
}
