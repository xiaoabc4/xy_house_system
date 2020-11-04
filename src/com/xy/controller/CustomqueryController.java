package com.xy.controller;

import com.xy.entity.Custom;
import com.xy.service.CustomService;
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

@WebServlet("/qcustom")
public class CustomqueryController extends SystemBaseController{

    CustomService customService = new CustomService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        query(req,resp);
    }

    public void query (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //定义json数据变量
        setAccessControlAllow(resp);
        String jsonStr = null;
        resultList = new ArrayList();
        Map<String, Object> pageMap = PageUtils.getPageParams(req);
        //总记录数
        int allcount  =customService.queryRecordsCount();
        int allpages = page.getAllPages(allcount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allpages);

        Object[] objects = new Object[]{};
        List<Custom> arx = customService.queryRecordsListDto(objects, pageMap, Custom.class);
        for (int i = 0; i < arx.size(); i++) {
            Custom d = arx.get(i);
            Custom dto = new Custom();
            dto.setCid(d.getCid());
            dto.setCname(d.getCname());
            dto.setCcard(d.getCcard());
            dto.setCsex(d.getCsex());
            dto.setCtel(d.getCtel());
            dto.setCtel1(d.getCtel1());


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

