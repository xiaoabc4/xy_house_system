package com.xy.controller;

import com.xy.entity.Mybs;
import com.xy.entity.Myshouru;
import com.xy.service.MyshouruService;
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

@WebServlet("/myshouru")
public class MyshouruController extends SystemBaseController{
    MyshouruService service = new MyshouruService();
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
        List<Myshouru> arx = service.queryRecordsListDto(objects, pageMap, Myshouru.class);
        for (int i = 0;i<arx.size();i++){
            Myshouru d = arx.get(i);
            Myshouru myshouru = new Myshouru();
            myshouru.setSid(d.getSid());
            myshouru.setEid(d.getEid());
            myshouru.setSmoney(d.getSmoney());
            myshouru.setStm(d.getStm());
            myshouru.setStime(d.getStime());
            myshouru.setSremark(d.getSremark());
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
