package com.xy.dao.impl;

import com.xy.dao.SystemDao;

import java.util.Map;

public class DjrzDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;

    public String getAddsql(){
        return addsql="insert into mydj(MID,MDATE,EID,CID,HID,MIMG,MYJ,MYZJ,MFLAG,MBEGINTIME)"+" value (null,now(),1,?,?,null,?,?,0,?)";
    }

    public static String getQueryAllsql() {
        queryAllsql="SELECT D.*,E.EREALNAME,C.CNAME,C.CTEL,H.HADDRESS,H.HFH FROM MYDJ D,MYEMP E,MYCUS C,MYHOUSE H WHERE D.EID=E.EID AND D.CID=C.CID AND D.HID=H.HID ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from mydj ";
        return queryAllsqlCount;
    }
    public boolean add(Map map){
        int len = 5;
        Object[] objects = new Object[len];
        objects[0] = map.get("cid");
        objects[1] = map.get("hid");
        objects[2] = map.get("myj");
        objects[3] = map.get("myzj");
        objects[4] = map.get("time");
    return update(getAddsql(),objects);
    }

}
