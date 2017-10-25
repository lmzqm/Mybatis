package com.lmzqm.mybatis.Mapper;

import com.lmzqm.mybatis.Entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by lmzqm on 2017/8/28.
 */
@Mapper
public interface QuestionMapper {

    /**
     * 通过主键来获取题目的相关信息
     * @param id 题目的ID
     * @return 返回的问题的信息
     */
    Question selectQuestionById(@Param("id") Integer id);

    /**
     * 添加新的问题
     * @param question 问题的信息
     * @return 问题的Id
     */
    Integer addNewQuestions(Question question);

    /**
     * 通过问题的id列表获取问题的详细信息
     * @param list
     * @return
     */
    List<Question> getQuestionListByArray(List list);
}
