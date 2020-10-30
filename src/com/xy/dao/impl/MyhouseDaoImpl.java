package com.xy.dao.impl;

import com.xy.dao.SystemDao;

public class MyhouseDaoImpl extends SystemDao {

    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;

    public static String getQueryAllsql() {
        queryAllsql="SELECT * FROM mysort s,myhouse h,myarea a WHERE h.AID=a.AID AND h.SID=s.SID ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from myhouse ";
        return queryAllsqlCount;
    }
}
