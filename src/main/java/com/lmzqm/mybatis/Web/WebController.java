package com.lmzqm.mybatis.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lmzqm on 2017/6/28.
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @GetMapping("/component")
    public String getComponent(){
        return "componey";
    }

    @GetMapping("/error")
    public void getError() throws Exception {
        throw new Exception("错误信息");
    }

}
