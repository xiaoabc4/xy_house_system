package com.xy.dao.impl;

import com.xy.dao.SystemDao;

public class MysortDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;

    public static String getQueryAllsql() {
        queryAllsql="select * from mysort where 1 = 1 ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from mysort ";
        return queryAllsqlCount;
    }
}
