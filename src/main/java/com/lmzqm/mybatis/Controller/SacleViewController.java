package com.lmzqm.mybatis.Controller;

import com.lmzqm.mybatis.Entity.Question;
import com.lmzqm.mybatis.Entity.ResultModel;
import com.lmzqm.mybatis.Entity.Scale;
import com.lmzqm.mybatis.Entity.ScaleRecord;
import com.lmzqm.mybatis.Enum.HttpCodeEnum;
import com.lmzqm.mybatis.Server.ScaleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lmzqm on 2017/8/29.
 */
@RestController
@RequestMapping(value = "/scales")
public class SacleViewController {

    @Autowired
    private ScaleServer scaleServer;

    @GetMapping("/")
    public ResponseEntity<?> getScaleList(){

        List<Scale> scaleList =  scaleServer.getScaleList();
        if(scaleList == null ){

            return new ResponseEntity<Object>(ResultModel.error(HttpCodeEnum.FAIL),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Object>(ResultModel.ok(scaleList), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getScaleQuestionList(@PathVariable("id") Integer id){

        List<Question> questionList =  scaleServer.getScaleQuestions(id);
        if(questionList.isEmpty()){
            return new ResponseEntity<Object>(ResultModel.error(HttpCodeEnum.FAIL),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(ResultModel.ok(questionList), HttpStatus.OK);
    }

    @GetMapping("/records/{userId}")
    public ResponseEntity<?> getScaleRecordByUserId(@PathVariable("userId") Integer userId){
        List<ScaleRecord> recordList = scaleServer.getRecordListByUserId(userId);
        if(recordList.isEmpty()){
            return new ResponseEntity<Object>(ResultModel.error(HttpCodeEnum.FAIL),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(ResultModel.ok(recordList), HttpStatus.OK);
    }

    @GetMapping("/recordsinfo/{id}")
    public ResponseEntity<?> getRecordInfoById(@PathVariable("userId") Integer userId){
        List<ScaleRecord> recordList = scaleServer.getRecordListByUserId(userId);
        if(recordList.isEmpty()){
            return new ResponseEntity<Object>(ResultModel.error(HttpCodeEnum.FAIL),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(ResultModel.ok(recordList), HttpStatus.OK);
    }


}
