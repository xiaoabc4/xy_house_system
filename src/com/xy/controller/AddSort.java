package com.xy.controller;

import com.xy.entity.Mysort;
import com.xy.service.MysortService;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addsort")
public class AddSort extends SystemBaseController{
    MysortService service = new MysortService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp);
        String jsonStr = null;
        //获取参数值
        String name = req.getParameter("sort.sname");
        Mysort mysort = new Mysort();
        mysort.setSname(name);
        if (service.addlist(mysort)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }

}
