package com.lmzqm.mybatis.Controller;

import com.lmzqm.mybatis.Entity.*;
import com.lmzqm.mybatis.Enum.HttpCodeEnum;
import com.lmzqm.mybatis.Server.ActivityServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lmzqm on 2017/7/11.
 */
@RestController
@RequestMapping(value = "/activity")
public class ActivityViewController {

    @Autowired
    private ActivityServer activityServer;

    @GetMapping("/status")
    ErrorInfo<Object> getAllActivityStatus(){

        HttpCodeEnum code = HttpCodeEnum.SUCCESS;

        ErrorInfo<Object> errorInfo = new ErrorInfo<>();

        List<ActivityStatus> status =  activityServer.getAllActivityStatus();
        if (status.isEmpty()){
            code = HttpCodeEnum.FAIL;
        }
        errorInfo.setCode(code.getCode());
        errorInfo.setMessage(code.getDesc());
        errorInfo.setData(status);
        return errorInfo;
    }

    @GetMapping("/status/{id}")
    ErrorInfo<Object> getStatusById(@PathVariable("id") Integer id){
        HttpCodeEnum code = HttpCodeEnum.SUCCESS;
        ErrorInfo<Object> errorInfo = new ErrorInfo<>();

        ActivityStatus status = activityServer.getAtatusById(id);
        if (status == null){
            code = HttpCodeEnum.FAIL;
            errorInfo.setData(new HashMap<>());
        }else{

            errorInfo.setData(status);
        }

        errorInfo.setCode(code.getCode());
        errorInfo.setMessage(code.getDesc());

        return errorInfo;
    }

    @GetMapping("/status/delete/{id}")
    ErrorInfo<Object> deleteStatusById(@PathVariable("id") Integer id){

        HttpCodeEnum code = HttpCodeEnum.SUCCESS;
        ErrorInfo<Object> errorInfo = new ErrorInfo<>();

        Integer index = activityServer.deleteStatusById(id);
        if(index == -1){
            code = HttpCodeEnum.UNFIND;
        }
        errorInfo.setCode(code.getCode());
        errorInfo.setMessage(code.getDesc());
        return errorInfo;

    }

    @GetMapping("/status/update")
    public ResponseEntity<?> updateActivityStatus(@ModelAttribute ActivityStatus status){


        if(status.getId() == null){
            return new ResponseEntity<>(ResultModel.error(HttpCodeEnum.FAIL), HttpStatus.BAD_REQUEST);
        }



        Integer index = activityServer.updateStatusByStatus(status);
        if(index == -1){

            return new ResponseEntity<>(ResultModel.error(HttpCodeEnum.FAIL),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(),HttpStatus.OK);

    }

    @GetMapping("/status/add")
    public ResponseEntity<?> addActivityStatus(@ModelAttribute ActivityStatus status){


        if(status.getDesc() == null){

            return new ResponseEntity<>(ResultModel.error(HttpCodeEnum.FAIL), HttpStatus.BAD_REQUEST);
        }

        Integer index = activityServer.addStatusByStatus(status);
        if( index == -1 ){

            return new ResponseEntity<>(ResultModel.error(HttpCodeEnum.FAIL),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(),HttpStatus.OK);

    }

    @GetMapping("/home/{status}")
    public ResponseEntity<?> getHomeActivitysByStatus(@PathVariable("status") Integer status){

        if(status == null || status == 0){
            status = 1;
        }

        List<SimpleActivity> list =  activityServer.getAllActiveActivity(status);

        return new ResponseEntity<Object>(ResultModel.ok(list),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActivityInfoById(@PathVariable("id") Integer id){

        ActivityDetail info = activityServer.getActivityInfoById(id);
        if (info == null){
            return new ResponseEntity<>(ResultModel.error(HttpCodeEnum.UNFIND),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(ResultModel.ok(info),HttpStatus.OK);
    }




}
