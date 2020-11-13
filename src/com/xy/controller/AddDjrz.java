package com.xy.controller;


import com.xy.service.DjrzService;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/adddjrz")
public class AddDjrz extends SystemBaseController{
    DjrzService service = new DjrzService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp,req);
        //定义json数据变量
        String jsonStr = null;
        String cid =  req.getParameter("cid");
        String hid =  req.getParameter("hid");
        String myj =  req.getParameter("myj");
        String myzj =  req.getParameter("myzj");
        String time =  req.getParameter("time");
        String doc =  req.getParameter("doc");

        Map map = new HashMap();
        map.put("cid",Long.valueOf(cid));
        map.put("hid",Long.valueOf(hid));
        map.put("myj",Double.valueOf(myj));
        map.put("myzj",Double.valueOf(myzj));
        map.put("time",time);

        if (service.add(map)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }
}
