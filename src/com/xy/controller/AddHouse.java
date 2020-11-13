package com.xy.controller;

import com.xy.entity.MyDept;
import com.xy.entity.Myhouse;
import com.xy.service.MyhouseService;
import com.xy.utils.JacksonUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/addhouse")
public class AddHouse extends SystemBaseController{
    MyhouseService service =new MyhouseService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp,req);
        String jsonStr = null;
        //获取参数值
        int sid = Integer.parseInt(req.getParameter("house.sid"));
        int aid = Integer.parseInt(req.getParameter("house.aid"));
        int hmoney = Integer.parseInt(req.getParameter("house.hmoney"));



        String haddress = req.getParameter("house.haddress");
        String hfh = req.getParameter("house.hfh");
        String hhx = req.getParameter("house.hhx");
        String hmj = req.getParameter("house.hmj");
        String hcx = req.getParameter("house.hcx");


        Myhouse myhouse = new Myhouse();
        myhouse.setSid(sid);
        myhouse.setAid(aid);
        myhouse.setHmoney(hmoney);
        myhouse.setHaddress(haddress);
        myhouse.setHfh(hfh);
        myhouse.setHhx(hhx);
        myhouse.setHmj(hmj);
        myhouse.setHcx(hcx);



        if (service.addlist(myhouse)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }

}
