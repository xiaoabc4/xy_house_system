package com.xy.controller;

import com.xy.utils.Pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 系统基类控制器
 *
 */

public abstract class SystemBaseController extends HttpServlet {
    protected static final long serialVersionUID = 1L;
    protected Pages page = new Pages();//分页对象
    protected int current;//当前页
    protected int mypages = Constants.PAGE_SIZE_DEFAULT;//页面默认显示·10条记录
    protected List resultList;//结果集

    /**
     * 重写doget，调用dopost
     */

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    /**
     * 定义dopost抽象方法，方便重写
     */
    @Override
    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;
}
