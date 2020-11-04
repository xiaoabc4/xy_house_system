package com.xy.dao.impl;

import com.xy.dao.SystemDao;
import com.xy.entity.Myarea;
import com.xy.entity.Mysort;
import com.xy.utils.JdbcUtils;

public class MysortDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;

    public String getAddsql(){
        return addsql="insert into mysort(SID,SNAME)" + " value (null,?)";
    }

    public static String getQueryAllsql() {
        queryAllsql="select * from mysort where 1 = 1 ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from mysort ";
        return queryAllsqlCount;
    }
    //添加客户记录
    public boolean addlist(Mysort mysort){
        int len  =1;
        Object[] objects = new Object[len];
        objects[0] = mysort.getSname();
        return JdbcUtils.update(getAddsql(),objects);
    }
}
