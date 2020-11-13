package com.xy.controller;

import com.xy.entity.MyDept;
import com.xy.entity.Myarea;
import com.xy.service.MyareaService;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addarea")
public class AddArea extends SystemBaseController{
    MyareaService service = new MyareaService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp,req);
        String jsonStr = null;
        //获取参数值
        String name = req.getParameter("area.aname");
        Myarea myarea = new Myarea();
        myarea.setAname(name);
        if (service.addlist(myarea)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }
}
