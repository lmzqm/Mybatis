package com.lmzqm.mybatis.Mapper;

import com.lmzqm.mybatis.Entity.Focus;
import com.lmzqm.mybatis.Entity.FocusDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lmzqm on 2017/8/11.
 */
@Mapper
public interface FocusMapper {

    List<FocusDetail> getFocusList(@Param("id") Integer id);

    List<FocusDetail> getFocusedList(@Param("id") Integer id);

    Integer addFocus(Focus focus);
}
