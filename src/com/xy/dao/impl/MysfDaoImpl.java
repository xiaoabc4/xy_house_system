package com.xy.dao.impl;

import com.xy.dao.SystemDao;

public class MysfDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;

    public static String getQueryAllsql() {
        queryAllsql="SELECT S.*,D.MDATE,C.CNAME,C.CTEL,H.HADDRESS,H.HFH FROM MYDJ D,MYCUS C,MYHOUSE H,MYSF S WHERE D.EID=S.EID AND D.CID=C.CID AND D.HID=H.HID ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from mysf ";
        return queryAllsqlCount;
    }


}
