package com.xy.controller;

import com.xy.entity.Myshouru;
import com.xy.entity.Myzhichu;
import com.xy.service.MyzhichuService;
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

@WebServlet("/myzhichu")
public class MyzhichuController extends SystemBaseController{
    MyzhichuService service = new MyzhichuService();
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
        List<Myzhichu> arx = service.queryRecordsListDto(objects, pageMap, Myzhichu.class);
        for (int i = 0;i<arx.size();i++){
            Myzhichu d = arx.get(i);
            Myzhichu myshouru = new Myzhichu();
            myshouru.setZid(d.getZid());
            myshouru.setEid(d.getEid());
            myshouru.setZmoney(d.getZmoney());
            myshouru.setZtm(d.getZtm());
            myshouru.setZtime(d.getZtime());
            myshouru.setZremark(d.getZremark());
            myshouru.setErealname(d.getErealname());


            myshouru.setAllcount(allcount);
            myshouru.setAllpages(allpages);
            myshouru.setCurrent(current);
            myshouru.setNext(next);
            myshouru.setUp(up);
            resultList.add(myshouru);
        }
        resp.setContentType("application/json;charset=utf-8");
        //json数据
        jsonStr = JacksonUtils.obj2json(resultList);
        //将数据写入流中
        resp.getWriter().write(jsonStr);
    }
}
