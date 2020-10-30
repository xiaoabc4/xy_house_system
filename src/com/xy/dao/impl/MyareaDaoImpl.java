package com.xy.dao.impl;

import com.xy.dao.SystemDao;

public class MyareaDaoImpl  extends SystemDao {

    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;

    public static String getQueryAllsql() {
        queryAllsql="select * from myarea where 1 = 1 ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from myarea ";
        return queryAllsqlCount;
    }
}
