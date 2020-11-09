package com.xy.controller;

import com.xy.service.MybsServices;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addmybs")
public class AddMybs extends SystemBaseController{
    MybsServices service =new MybsServices();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        //定义json数据变量
        String jsonStr = null;
        String hid =  req.getParameter("bs.hid");
        String bremark =  req.getParameter("bs.bremark");

        Map map = new HashMap();
        map.put("hid",Double.valueOf(hid));
        map.put("bremark",Long.valueOf(bremark));

        if (service.add(map)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }
}
