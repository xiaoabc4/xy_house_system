package com.xy.dao.impl;

import com.xy.dao.SystemDao;
import com.xy.entity.Myjs;
import com.xy.utils.JdbcUtils;

public class MyjsDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;

    private  static  String addsql=null;

    public String getAddsql(){
        return addsql="insert into myjs(JID,JNAME)"+" value (null,?)";
    }

    public static String getQueryAllsql() {
        queryAllsql="select * from myjs where 1 = 1 ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
       queryAllsqlCount="select count(1) from myjs ";
        return queryAllsqlCount;
    }
    //添加客户记录
    public boolean addlist(Myjs myjs){
        int len  =1;
        Object[] objects = new Object[len];
        objects[0] = myjs.getJname();

        return JdbcUtils.update(getAddsql(),objects);
    }

}
