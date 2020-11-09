package com.xy.controller;

import com.xy.dao.SystemDao;
import com.xy.entity.MyDept;
import com.xy.entity.Mydj;
import com.xy.entity.Pagedto;
import com.xy.service.DjrzService;
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
@WebServlet("/mydj")
public class DjrzController extends SystemBaseController {
    DjrzService service = new DjrzService();
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
        List<Mydj> arx = service.queryRecordsListDto(objects, pageMap,Mydj.class);
        for (int i = 0; i < arx.size(); i++) {
            Mydj d = arx.get(i);
            Mydj mydj = new Mydj();
            mydj.setMid(d.getMid());
            mydj.setHaddress(d.getHaddress());
            mydj.setHfh(d.getHfh());
            mydj.setCname(d.getCname());
            mydj.setCtel(d.getCtel());
            mydj.setErealname(d.getErealname());
            mydj.setMdate(d.getMdate());
            mydj.setMyj(d.getMyj());
            mydj.setMyzj(d.getMyzj());
            mydj.setMflag(d.getMflag());
            mydj.setMbegintime(d.getMbegintime());
            mydj.setAllcount(allcount);
            mydj.setAllpages(allpages);
            mydj.setCurrent(current);
            mydj.setNext(next);
            mydj.setUp(up);
            resultList.add(mydj);
        }
        resp.setContentType("application/json;charset=utf-8");
        //json数据
        jsonStr = JacksonUtils.obj2json(resultList);
        String result="jsonStr="+jsonStr;
        //将数据写入流中
        resp.getWriter().write(jsonStr);
    }
}
