package com.lmzqm.mybatis.Mapper;

import com.lmzqm.mybatis.Entity.ScaleRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lmzqm on 2017/8/28.
 */
@Mapper
public interface ScaleRecordMapper {

    ScaleRecord selectRecordById(@Param("id") Integer id);

    Integer addNewRecordInfo(ScaleRecord record);

    List<ScaleRecord> getRecordListByUserId(@Param("userId") Integer userId);
}
