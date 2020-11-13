package com.xy.controller;

import com.xy.entity.MyDept;
import com.xy.entity.Myjs;
import com.xy.service.MyjsService;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addjs")
public class AddJs extends SystemBaseController{
    MyjsService myjsService = new MyjsService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp,req);
        String jsonStr = null;
        //获取参数值
        String jname = req.getParameter("js.jname");

        Myjs myjs = new Myjs();
        myjs.setJname(jname);
        if (myjsService.addlist(myjs)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }
}
