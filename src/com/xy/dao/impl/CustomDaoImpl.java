package com.xy.dao.impl;

import com.xy.dao.BaseDao;
import com.xy.entity.Custom;
import com.xy.utils.JdbcUtils;

import java.io.ObjectOutput;

public class CustomDaoImpl extends BaseDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;

    public static String getQueryAllsql() {
        queryAllsql="select * from mycus where 1 = 1 ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from mycus ";
        return queryAllsqlCount;
    }

    public String getAddsql(){
        return addsql="insert into mycus(CID,CNAME,CSEX,CTEL,CTEL1,CCARD)"+" value (null,?,?,?,?,?)";
    }

    //添加客户记录
    public boolean addCustom(Custom custom){
        int len  =5;
        Object[] objects = new Object[len];
        objects[0] = custom.getCname();
        objects[1] = custom.getCcard();
        objects[2] = custom.getCsex();
        objects[3] = custom.getCtel();
        objects[4] = custom.getCtel1();
        return JdbcUtils.update(getAddsql(),objects);
    }
}
