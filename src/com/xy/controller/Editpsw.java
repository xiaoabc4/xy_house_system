package com.xy.controller;

import com.xy.entity.MyEmp;
import com.xy.service.MyempService;
import com.xy.utils.JacksonUtils;
import com.xy.utils.MySession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/editpsw")
public class Editpsw extends SystemBaseController{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);

        MyEmp myEmp = (MyEmp) req.getSession().getAttribute(MySession.usersession);

        System.out.println(myEmp);
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
