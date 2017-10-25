package com.lmzqm.mybatis.Task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lmzqm on 2017/7/5.
 */

/**
 * 分析下@Scheduled注解的参数
 *
 * fixedRate = 5000 :每过5秒执行的任务，上一次开始执行时间点之后5秒再执行
 * fixedDelay = 5000 :上一次执行完毕时间点之后5秒再执行
 * @Scheduled(cron="*") 通过cron表达式定义规则
 */

@Component
public class ScheduleTask {

    /**
     * 定时任务的实现类
     */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedDelay = 5000)
//    public void reportCurrentTime(){
//        System.out.println("现在的时间："+dateFormat.format(new Date()));
//    }


    @Scheduled(cron = "0 30 15 * * ?")
    public void doSomeThing(){
        System.out.println("现在的时间："+dateFormat.format(new Date()));
    }

}
