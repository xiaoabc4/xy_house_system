package com.xy.controller;

import com.xy.service.MyshouruService;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addmyshouru")
public class AddMyshouru extends SystemBaseController{
    MyshouruService service = new MyshouruService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp,req);
        //定义json数据变量
        String jsonStr = null;

        String smoney =  req.getParameter("sr.smoney");
        String stm =  req.getParameter("sr.stm");
        String sremark =  req.getParameter("sr.sremark");

        Map map = new HashMap();
        map.put("smoney",Double.valueOf(smoney));
        map.put("stm",stm);
        map.put("sremark",sremark);

        if (service.add(map)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }
}
