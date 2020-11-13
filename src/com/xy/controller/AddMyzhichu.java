package com.xy.controller;

import com.xy.service.MyzhichuService;
import com.xy.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addmyzhichu")
public class AddMyzhichu extends SystemBaseController{
    MyzhichuService service = new MyzhichuService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp,req);
        //定义json数据变量
        String jsonStr = null;

        String zmoney =  req.getParameter("zc.zmoney");
        String ztm =  req.getParameter("zc.ztm");
        String zremark =  req.getParameter("zc.zremark");

        Map map = new HashMap();
        map.put("zmoney",zmoney);
        map.put("ztm",ztm);
        map.put("zremark",zremark);

        if (service.add(map)){
            jsonStr="1";
        }else {
            jsonStr="0";
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }

}
