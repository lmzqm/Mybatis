package com.lmzqm.mybatis.RequestWarpper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Map;

/**
 * Created by lmzqm on 2017/8/3.
 */
public class SafeTextRequestWarpper extends HttpServletRequestWrapper {

    public SafeTextRequestWarpper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        return super.getParameter(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return super.getParameterMap();
    }
}
