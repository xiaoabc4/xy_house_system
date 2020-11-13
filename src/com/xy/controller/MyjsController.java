package com.xy.controller;

import com.xy.entity.MyDept;
import com.xy.entity.Myjs;
import com.xy.service.MyjsService;
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
 * 岗位信息
 * */
@WebServlet("/myjs")
public class MyjsController extends SystemBaseController{
    MyjsService myjsService =  new MyjsService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp,req);
        String jsonStr = null;
        resultList = new ArrayList();
        Map<String, Object> pageMap = PageUtils.getPageParams(req);
        //总记录数
        int allcount  =myjsService.queryRecordsCount();
        int allpages = page.getAllPages(allcount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allpages);

        Object[] objects = new Object[]{};
        List<Myjs> arx = myjsService.queryRecordsListDto(objects, pageMap,Myjs.class);
        for (int i = 0; i < arx.size(); i++) {
            Myjs d = arx.get(i);
            Myjs dto = new Myjs();
            dto.setJid(d.getJid());
            dto.setJname(d.getJname());
            dto.setAllcount(allcount);
            dto.setAllpages(allpages);
            dto.setCurrent(current);
            dto.setNext(next);
            dto.setUp(up);
            resultList.add(dto);
        }
        resp.setContentType("application/json;charset=utf-8");
        //json数据
        jsonStr = JacksonUtils.obj2json(resultList);
        String result="jsonStr="+jsonStr;
        //将数据写入流中
        resp.getWriter().write(jsonStr);
    }

}
