package com.xy.controller;

import com.xy.entity.Myarea;
import com.xy.entity.Myhouse;
import com.xy.service.MyhouseService;
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

/**
 * 房屋资料
 */
@WebServlet("/myhouse")
public class MyhouseController extends SystemBaseController{
    MyhouseService myhouseService = new MyhouseService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp,req);
        String jsonStr = null;
        resultList = new ArrayList();
        Map<String, Object> pageMap = PageUtils.getPageParams(req);
        //总记录数
        int allcount  =myhouseService.queryRecordsCount();
        int allpages = page.getAllPages(allcount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allpages);
        long aid =NumberUtil.getLong(req.getParameter("aid"),0);
        long sid =NumberUtil.getLong(req.getParameter("sid"),0);
        long zt =NumberUtil.getLong(req.getParameter("zt"),0);
        System.out.println("zt="+zt);
        System.out.println("sid="+sid);
        Object[] objects = new Object[]{};
        if (sid>=1){
            objects = new Object[1];
            objects[0]=sid;
            if (aid>=1){
                objects = new Object[2];
                objects[0]=aid;
                objects[1]=sid;
            }
        }
        if (sid<1 && aid>=1){
            objects = new Object[1];
            objects[0]=aid;

        }

        List<Myhouse> arx = myhouseService.queryRecordsListDto(objects, pageMap, Myhouse.class);
        for (int i = 0; i < arx.size(); i++) {
            Myhouse d = arx.get(i);
            Myhouse dto = new Myhouse();
            dto.setAid(d.getAid());
            dto.setSid(d.getSid());
            dto.setHid(d.getHid());
            dto.setHaddress(d.getHaddress());
            dto.setSname(d.getSname());
            dto.setAname(d.getAname());
            dto.setHfh(d.getHfh());
            dto.setHhx(d.getHhx());
            dto.setHmj(d.getHmj());
            dto.setHcx(d.getHcx());
            dto.setHmoney(d.getHmoney());
            dto.setHflagnumber(d.getHflagnumber());
            dto.setAllcount(allcount);
            dto.setAllpages(allpages);
            dto.setCurrent(current);
            dto.setNext(next);
            dto.setUp(up);
            resultList.add(dto);
        }
        System.out.println(objects.length);
        resp.setContentType("application/json;charset=utf-8");
        //json数据
        jsonStr = JacksonUtils.obj2json(resultList);
        String result="jsonStr="+jsonStr;
        //将数据写入流中
        resp.getWriter().write(jsonStr);
    }

}
