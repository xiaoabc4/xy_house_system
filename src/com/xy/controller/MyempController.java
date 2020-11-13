package com.xy.controller;

import com.xy.entity.MyEmp;
import com.xy.entity.Myjs;
import com.xy.service.MyempService;
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
 * 员工管理
 */
@WebServlet("/myemp")
public class MyempController extends SystemBaseController{
    MyempService myempService = new MyempService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp,req);
        String jsonStr = null;
        resultList = new ArrayList();
        Map<String, Object> pageMap = PageUtils.getPageParams(req);
        //总记录数
        int allcount  =myempService.queryRecordsCount();
        int allpages = page.getAllPages(allcount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allpages);

        Object[] objects = new Object[]{};
        List<MyEmp> arx = myempService.queryRecordsListDto(objects, pageMap, MyEmp.class);
        for (int i = 0; i < arx.size(); i++) {
            MyEmp d = arx.get(i);
            MyEmp dto = new MyEmp();
            dto.setJid(d.getJid());

            dto.setPname(d.getPname());
            dto.setJname(d.getJname());

            dto.setPid(d.getPid());
            dto.setEpsw(d.getEpsw());
            dto.setEaddress(d.getEaddress());
            dto.setEflag(d.getEflag());
            dto.setEid(d.getEid());
            dto.setEname(d.getEname());
            dto.setEtel(d.getEtel());
            dto.setErealname(d.getErealname());
            dto.setEremark(d.getEremark());

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
