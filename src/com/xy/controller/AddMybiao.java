package com.xy.controller;

import com.xy.service.MybiaoService;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addmybiao")
public class AddMybiao extends SystemBaseController{
    MybiaoService service = new MybiaoService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp,req);
        //定义json数据变量
        String jsonStr = null;
        String skd =  req.getParameter("biao.skd");
        String dkd =  req.getParameter("biao.dkd");
        String mkd =  req.getParameter("biao.mkd");
        String hid =  req.getParameter("biao.hid");


        Map map = new HashMap();
        map.put("hid",Double.valueOf(hid));
        map.put("dkd",Long.valueOf(dkd));
        map.put("skd",Long.valueOf(skd));
        map.put("mkd",Double.valueOf(mkd));


        if (service.add(map)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }
}
