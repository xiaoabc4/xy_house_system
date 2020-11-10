package com.xy.controller;

import com.xy.entity.MyEmp;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 修改密码
 */
@WebServlet("/editpsw")
public class Editpsw extends SystemBaseController{
    MyempService service = new MyempService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        Cookie[] cookies = req.getCookies();
        Map map = new HashMap();
        String jsonStr = null;
        String oldpsw = req.getParameter("oldpsw");
        String newpsw = req.getParameter("psw");
        MyempService myempService = new MyempService();
        Object[] obj = new Object[]{};
        Map page = new HashMap();
        List<MyEmp> rs = myempService.queryRecordsListDto(obj, page, MyEmp.class);
        resp.setContentType("application/json;charset=utf-8");
        Cookie cookie=null;
        if(cookies != null) {
            for(int i=0; i<cookies.length; i++){
                cookie = cookies[i];

             }}

        int num =  Integer.valueOf(cookie.getValue());
        System.out.println("num="+num);
        for (int i = 0; i <rs.size(); i++) {
            if ( rs.get(i).getEid()==num&&rs.get(i).getEpsw().equals(oldpsw)) {
                map.put("eid",num);
                map.put("epsw",newpsw);
                if (service.uplist(map)){
                    jsonStr="1";
                }else {
                    jsonStr="0";
                }
                resp.setContentType("application/json;charset=utf-8");
                resp.getWriter().write(JacksonUtils.obj2json(jsonStr));
                break;
            }else{
                continue;
            }

        }



    }

}
