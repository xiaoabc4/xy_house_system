package com.xy.controller;

import com.xy.entity.Mybiao;
import com.xy.entity.Mydj;
import com.xy.service.MybiaoService;
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

@WebServlet("/mybiao")
public class MybiaoController extends SystemBaseController{
    MybiaoService service = new MybiaoService();
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
        List<Mybiao> arx = service.queryRecordsListDto(objects, pageMap,Mybiao.class);
        for (int i = 0;i<arx.size();i++){
            Mybiao d = arx.get(i);
            Mybiao mybiao = new Mybiao();
            mybiao.setBid(d.getBid());
            mybiao.setHaddress(d.getHaddress());
            mybiao.setHfh(d.getHfh());
            mybiao.setDkd(d.getDkd());
            mybiao.setSkd(d.getSkd());
            mybiao.setMkd(d.getMkd());
            mybiao.setMtime(d.getMtime());
            mybiao.setErealname(d.getErealname());
            mybiao.setAllcount(allcount);
            mybiao.setAllpages(allpages);
            mybiao.setCurrent(current);
            mybiao.setNext(next);
            mybiao.setUp(up);
            resultList.add(mybiao);
        }
        resp.setContentType("application/json;charset=utf-8");
        //json数据
        jsonStr = JacksonUtils.obj2json(resultList);
        //将数据写入流中
        resp.getWriter().write(jsonStr);
    }
}
