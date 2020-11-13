package com.xy.controller;

import com.xy.service.MyempService;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addemp")
public class AddMyemp extends SystemBaseController{
    MyempService service = new MyempService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp,req);
        //定义json数据变量
        String jsonStr = null;


        String jid =  req.getParameter("emp.myjs.jid");
        String pid =  req.getParameter("emp.mydept.pid");
        String ename =  req.getParameter("emp.ename");
        String epsw =  req.getParameter("emp.epsw");
        String erealname =  req.getParameter("emp.erealname");
        String etel =  req.getParameter("emp.etel");
        String eaddress =  req.getParameter("emp.eaddress");
        String eremark =  req.getParameter("emp.eremark");

        Map map = new HashMap();
        map.put("jid",Long.valueOf(jid));
        map.put("pid",Long.valueOf(pid));
        map.put("ename",ename);
        map.put("epsw",epsw);
        map.put("erealname",erealname);
        map.put("etel",etel);
        map.put("eaddress",eaddress);
        map.put("eremark",eremark);


        if (service.add(map)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }
}
