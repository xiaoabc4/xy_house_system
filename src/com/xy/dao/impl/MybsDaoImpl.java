package com.xy.dao.impl;

import com.xy.dao.SystemDao;
import com.xy.entity.Mybiao;
import com.xy.entity.Mybs;
import com.xy.utils.JdbcUtils;

import java.util.Map;

public class MybsDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;

    public String getAddsql(){
        return addsql="insert into mybs(BID,HID,MTIME,BREMARK,EID)" + "values(null,?,now(),?,1)";
    }

    public static String getQueryAllsql() {
        queryAllsql="SELECT B.*,H.HADDRESS,H.HFH,E.EREALNAME FROM MYBS B,MYHOUSE H,MYEMP E WHERE B.HID=H.HID AND B.EID=E.EID ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from mybs ";
        return queryAllsqlCount;
    }

    public boolean add(Map map) {

        int length = 2;
        Object[] objects = new Object[length];
        objects[0] = map.get("hid");
        objects[1] = map.get("bremark");

        return JdbcUtils.update(getAddsql(),objects);
    }
}
