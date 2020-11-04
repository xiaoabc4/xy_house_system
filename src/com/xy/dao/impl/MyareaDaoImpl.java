package com.xy.dao.impl;

import com.xy.dao.SystemDao;
import com.xy.entity.Custom;
import com.xy.entity.Myarea;
import com.xy.utils.JdbcUtils;

public class MyareaDaoImpl  extends SystemDao {

    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;

    public String getAddsql(){
        return addsql="insert into myarea(AID,ANAME)" + " value (null,?)";
    }

    public static String getQueryAllsql() {
        queryAllsql="select * from myarea where 1 = 1 ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from myarea ";
        return queryAllsqlCount;
    }
    //添加客户记录
    public boolean addlist(Myarea myarea){
        int len  =1;
        Object[] objects = new Object[len];
        objects[0] = myarea.getAname();


        return JdbcUtils.update(getAddsql(),objects);
    }
}
