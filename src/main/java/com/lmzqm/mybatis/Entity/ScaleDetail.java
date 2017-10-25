package com.lmzqm.mybatis.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lmzqm on 2017/8/29.
 */
public class ScaleDetail implements Serializable {

    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
