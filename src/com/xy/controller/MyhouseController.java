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

@WebServlet("/myhouse")
public class MyhouseController extends SystemBaseController{
    MyhouseService myhouseService = new MyhouseService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义json数据变量
        setAccessControlAllow(resp);
        String jsonStr = null;
        resultList = new ArrayList();
        Map<String, Object> pageMap = PageUtils.getPageParams(req);
        //总记录数
        int allcount  =myhouseService.queryRecordsCount();
        int allpages = page.getAllPages(allcount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allpages);

        Object[] objects = new Object[]{};
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

            /**
             *  private  long aid;
             *     private  long sid;
             *     private  long hid;
             *     private  String haddress;
             *     private  String sname;
             *     private  String aname;
             *     private  String hfh;
             *     private  String hhx;
             *     private  String hmj;
             *     private  String hcx;
             *     private  float hmoney;
             *     private  long hflagnumber; //1代表正在出租0---没有出租
             *
             */
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
    protected  void  setAccessControlAllow(HttpServletResponse response){
        /*允许跨域的主机地址*/
        response.setHeader("Access-Control-Allow-Origin","*");
        /*允许跨域的请求 GET POST HEAD 等*/
        response.setHeader("Access-Control-Allow-Methods","*");
        /*重新预检验跨域的缓存时间*/
        response.setHeader("Access-Control-Max-Age","1800");
        /*允许跨域的请求头*/
        response.setHeader("Access-Control-Allow-Headers","*");
        /*是否携带COOKIE*/
        response.setHeader("Access-Control-Allow-Credentials","true");
    }
}
