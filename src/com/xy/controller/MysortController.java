package com.xy.controller;

import com.xy.entity.Myarea;
import com.xy.entity.Mysort;
import com.xy.service.MyareaService;
import com.xy.service.MysortService;
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
 * 房屋类型
 */
@WebServlet("/mysort")
public class MysortController extends SystemBaseController {
      MysortService mysortService = new MysortService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp,req);
        String jsonStr = null;
        resultList = new ArrayList();
        Map<String, Object> pageMap = PageUtils.getPageParams(req);
        //总记录数
        int allcount  =mysortService.queryRecordsCount();
        int allpages = page.getAllPages(allcount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allpages);

        Object[] objects = new Object[]{};
        List<Mysort> arx = mysortService.queryRecordsListDto(objects, pageMap, Mysort.class);
        for (int i = 0; i < arx.size(); i++) {
            Mysort d = arx.get(i);
            Mysort dto = new Mysort();
            dto.setSid(d.getSid());
            dto.setSname(d.getSname());
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
        System.out.println(result);
        //将数据写入流中
        resp.getWriter().write(jsonStr);
    }

}
