package com.xy.controller;

import com.xy.entity.Custom;
import com.xy.service.CustomService;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登记客户
 */
@WebServlet("/custom")
public class CustomController extends SystemBaseController{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp);
        String jsonStr = null;
        CustomService customService = new CustomService();
        //获取参数值
        String cname = req.getParameter("cus.cname");
        String csex = req.getParameter("cus.csex");
        String ctel = req.getParameter("cus.ctel");
        String ccard = req.getParameter("cus.ccard");
        String ctel1 = req.getParameter("cus.ctel1");

        System.out.println(cname);

        Custom custom = new Custom();
        custom.setCcard(ccard);
        custom.setCname(cname);
        custom.setCtel(ctel);
        custom.setCtel1(ctel1);
        custom.setCsex(csex);
        System.out.println(custom);
        if (customService.addCustom(custom)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }
}
