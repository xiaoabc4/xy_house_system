package com.xy.controller;

import com.xy.entity.MyEmp;
import com.xy.entity.Myarea;
import com.xy.service.MyempService;
import com.xy.utils.JacksonUtils;
import com.xy.utils.MySession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登入
 */
@WebServlet("/login")
public class Login extends SystemBaseController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        setAccessControlAllow(resp);
        Cookie cookie =null;
        String name = req.getParameter("name");
        String psw = req.getParameter("psw");
        MyempService myempService = new MyempService();
        Object[] obj = new Object[]{};
        Map page = new HashMap();
        List<MyEmp> rs = myempService.queryRecordsListDto(obj, page, MyEmp.class);
        resp.setContentType("application/json;charset=utf-8");
        for (int i = 0; i <rs.size(); i++) {
            if (rs.get(i).getEname().equals(name) && rs.get(i).getEpsw().equals(psw)) {
                Integer empId = (int) rs.get(i).getEid();
                cookie = new Cookie("loginCookie",String.valueOf(empId));
                cookie.setPath("/");
                cookie.setDomain("xy.com");
                cookie.setMaxAge(30 * 60 * 60);
                resp.addCookie(cookie);
                resp.getWriter().write(JacksonUtils.obj2json(empId));

            } else {
               continue;
            }

        }




    }


}