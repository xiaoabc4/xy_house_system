package com.xy.controller;

import com.xy.entity.MyEmp;
import com.xy.service.MyempService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/login")
public class Login extends SystemBaseController{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        String name = req.getParameter("name");
        String psw = req.getParameter("psw");
        MyempService myempService = new MyempService();
        Object[] obj = new Object[]{};
        Map page = new HashMap();
        List<MyEmp> rs = myempService.queryRecordsListDto(obj,page, MyEmp.class);

        resultList = new ArrayList();
        for (int i = 0; i < rs.size(); i++) {
            MyEmp d = rs.get(i);
            MyEmp dto = new MyEmp();
            dto.setJid(d.getJid());

            dto.setPname(d.getPname());
            dto.setJname(d.getJname());

            dto.setPid(d.getPid());
            dto.setEpsw(d.getEpsw());
            dto.setEaddress(d.getEaddress());
            dto.setEflag(d.getEflag());
            dto.setEid(d.getEid());
            dto.setEname(d.getEname());
            dto.setEtel(d.getEtel());
            dto.setErealname(d.getErealname());
            dto.setEremark(d.getEremark());
            resultList.add(dto);
        }
    }

    protected  void  setAccessControlAllow(HttpServletResponse response){
        /*允许跨域的主机地址*/
        response.setHeader("Access-Control-Allow-Origin","*");
        /*允许跨域的请求 GET POST HEAD 等*/
        response.setHeader("Access-Control-Allow-Methods","*");
        /*重新预检验跨域的缓存时间*/
        response.setHeader("Access-Control-Max-Age","1800");
        /*允许跨域的请求头*/
        response.setHeader("Access-Control-Allow-Headers","*");
        /*是否携带COOKIE*/
        response.setHeader("Access-Control-Allow-Credentials","true");
    }
}
