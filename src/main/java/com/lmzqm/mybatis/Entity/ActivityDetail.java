package com.lmzqm.mybatis.Entity;

import java.util.List;

/**
 * Created by lmzqm on 2017/7/13.
 */
public class ActivityDetail extends Activity {

    private ActivityStatus activityStatus;

    private List<User> users;


    public ActivityStatus getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(ActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
