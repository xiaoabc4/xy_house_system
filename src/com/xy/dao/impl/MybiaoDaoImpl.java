package com.xy.dao.impl;

import com.xy.dao.SystemDao;
import com.xy.utils.JdbcUtils;

import java.util.Map;

public class MybiaoDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;

    public String getAddsql(){
        return addsql="insert into mybiao(BID,HID,DKD,SKD,MKD,MTIME,EID)" + "values(null,?,?,?,?,now(),1)";
    }

    public static String getQueryAllsql() {
        queryAllsql="SELECT B.*,H.HADDRESS,H.HFH,E.EREALNAME FROM MYBIAO B,MYHOUSE H,MYEMP E WHERE B.HID=H.HID AND B.EID=E.EID ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from mybiao ";
        return queryAllsqlCount;
    }

    public boolean add(Map map) {
        int length = 4;
        Object[] objects = new Object[length];
        objects[0] = map.get("hid");
        objects[1] = map.get("dkd");
        objects[2] = map.get("skd");
        objects[3] = map.get("mkd");

        return JdbcUtils.update(getAddsql(),objects);
    }
}
