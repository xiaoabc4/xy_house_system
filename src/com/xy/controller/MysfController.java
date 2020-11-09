package com.xy.controller;

import com.xy.entity.Mydj;
import com.xy.entity.Mysf;
import com.xy.service.MysfService;
import com.xy.utils.JacksonUtils;
import com.xy.utils.NumberUtil;
import com.xy.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/mysf")
public class MysfController extends SystemBaseController{
    MysfService service = new MysfService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp);
        String jsonStr = null;
        resultList = new ArrayList();
        Map<String, Object> pageMap = PageUtils.getPageParams(req);
        //总记录数
        int allcount  =service.queryRecordsCount();
        int allpages = page.getAllPages(allcount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allpages);

        Object[] objects = new Object[]{};
        List<Mysf> arx = service.queryRecordsListDto(objects, pageMap,Mysf.class);
        for (int i = 0; i < arx.size(); i++) {
            Mysf d = arx.get(i);
            Mysf mysf = new Mysf();
            mysf.setMid(d.getMid());
            mysf.setHaddress(d.getHaddress());
            mysf.setHfh(d.getHfh());
            mysf.setCname(d.getCname());
            mysf.setCtel(d.getCtel());
            mysf.setMdate(d.getMdate());
            mysf.setMbegintime(d.getMbegintime());
            mysf.setAllcount(allcount);
            mysf.setAllpages(allpages);
            mysf.setCurrent(current);
            mysf.setNext(next);
            mysf.setUp(up);
            resultList.add(mysf);
        }
        resp.setContentType("application/json;charset=utf-8");
        //json数据
        jsonStr = JacksonUtils.obj2json(resultList);
        //将数据写入流中
        resp.getWriter().write(jsonStr);
    }
}
