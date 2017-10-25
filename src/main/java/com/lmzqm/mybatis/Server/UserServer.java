package com.lmzqm.mybatis.Server;

import com.lmzqm.mybatis.Entity.Focus;
import com.lmzqm.mybatis.Entity.FocusDetail;
import com.lmzqm.mybatis.Mapper.FocusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lmzqm on 2017/8/11.
 */
@Service
public class UserServer {

    @Autowired
    private FocusMapper focusMapper;

    public List<FocusDetail> getFocusDetailList(Integer id){
       List<FocusDetail> list =  focusMapper.getFocusList(id);
       if (list.isEmpty()){

       }
       return list;
    }

    public List<FocusDetail> getFocusedDetailList(Integer id){
        List<FocusDetail> list =  focusMapper.getFocusedList(id);
        if (list.isEmpty()){

        }
        return list;
    }

    /**
     * 添加关注的操作
     * @param focus 关注的信息
     * @return 关注id
     */
    public Integer addFocusAction(Focus focus){
        Integer act = focusMapper.addFocus(focus);
        if(act == 0){
            return  0;
        }

        return  focus.getId();

    }

    /**
     * 取消关注
     * @param focus 关注信息
     * @return 关注是否成功
     */
    public Integer removeFocusAction(Focus focus){

        return 1;

    }



}
