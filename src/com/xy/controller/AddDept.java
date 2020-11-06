package com.xy.controller;

import com.xy.dao.impl.DeptServiceImpl;
import com.xy.entity.Custom;
import com.xy.entity.MyDept;
import com.xy.service.CustomService;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/adddept")
public class AddDept extends SystemBaseController{
    DeptServiceImpl service = new DeptServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp);
        String jsonStr = null;
        //获取参数值
        String pname = req.getParameter("dept.pname");
        String premark = req.getParameter("dept.premark");
        MyDept myDept = new MyDept();
        myDept.setPname(pname);
        myDept.setPremark(premark);

        if (service.addlist(myDept)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }
    }

