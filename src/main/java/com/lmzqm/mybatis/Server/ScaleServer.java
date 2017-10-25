package com.lmzqm.mybatis.Server;

import com.lmzqm.mybatis.Entity.Question;
import com.lmzqm.mybatis.Entity.Scale;
import com.lmzqm.mybatis.Entity.ScaleRecord;
import com.lmzqm.mybatis.Exception.MyException;
import com.lmzqm.mybatis.Mapper.QuestionMapper;
import com.lmzqm.mybatis.Mapper.ScaleMapper;
import com.lmzqm.mybatis.Mapper.ScaleRecordMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lmzqm on 2017/8/29.
 */
@Service
public class ScaleServer {

    @Autowired
    private ScaleMapper scaleMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private ScaleRecordMapper recordMapper;

    private static final Logger logger = LoggerFactory.getLogger(ScaleServer.class);


    public List<Scale> getScaleList() {

        try {

        List<Scale> scales = scaleMapper.getScaleList();
        if (scales.isEmpty()){

            throw new MyException("所选择的数组为空");
        }
        return scales;

        }catch (Exception e){

        }

       return null;
    }

    public Integer updateScaletestPerson(Integer scaleId){

       Integer index = scaleMapper.addNewTestPersonsById(scaleId);

        return index;
    }


    public  List<Question> getScaleQuestions(Integer id){

        Scale scale =  scaleMapper.getScaleInfoById(id);
        String qs = scale.getQuestions();
        String[] qsArray =  qs.split(",");
        List<String> ar =  Arrays.asList(qsArray);

        List<Integer> list = convertList(ar, s -> Integer.parseInt(s));

        List<Question> questionList = getQuestionListByidList(list);

        return questionList;
    }

    public List<Question> getQuestionListByidList(List<Integer> list){

        List<Question> questions = questionMapper.getQuestionListByArray(list);

        if(questions.isEmpty()){


        }
        return questions;
    }

    public Integer addNewQuestion(Question question){

        try {
            Integer index = questionMapper.addNewQuestions(question);
            return  question.getQuestionId();

        }catch (Exception e){
            e.getLocalizedMessage();
        }

        return 0;

    }



    public List<ScaleRecord> getRecordListByUserId(Integer userId){

        List<ScaleRecord> records =  recordMapper.getRecordListByUserId(userId);
        if(records.isEmpty()){

        }

        return records;
    }


    public Integer addNewScaleRecord(ScaleRecord record){

        Integer index = recordMapper.addNewRecordInfo(record);
        if(index == 0){


        }
        return record.getId();
    }

    public static  <T,U> List<U> convertList(List<T> from,Function<T,U> func){

        return from.stream().map(func).collect(Collectors.toList());
//   https://stackoverflow.com/questions/23057549/lambda-expression-to-convert-array-list-of-string-to-array-list-of-integers
//        Stream.of(from).map(func).collect(Collectors.toList());
    }












}
