package com.xy.controller;

import com.xy.entity.Mybiao;
import com.xy.entity.Mybs;
import com.xy.service.MybsServices;
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

@WebServlet("/mybs")
public class MybsController extends SystemBaseController{
    MybsServices service = new MybsServices();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp,req);
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
        List<Mybs> arx = service.queryRecordsListDto(objects, pageMap,Mybs.class);
        for (int i = 0;i<arx.size();i++){
            Mybs d = arx.get(i);
            Mybs mybs = new Mybs();
            mybs.setBid(d.getBid());
            mybs.setHaddress(d.getHaddress());
            mybs.setHfh(d.getHfh());
            mybs.setBremark(d.getBremark());
            mybs.setMtime(d.getMtime());
            mybs.setErealname(d.getErealname());
            mybs.setAllcount(allcount);
            mybs.setAllpages(allpages);
            mybs.setCurrent(current);
            mybs.setNext(next);
            mybs.setUp(up);
            resultList.add(mybs);
        }
        resp.setContentType("application/json;charset=utf-8");
        //json数据
        jsonStr = JacksonUtils.obj2json(resultList);
        //将数据写入流中
        resp.getWriter().write(jsonStr);
    }
}
