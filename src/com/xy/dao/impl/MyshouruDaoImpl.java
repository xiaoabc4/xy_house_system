package com.xy.dao.impl;

import com.xy.dao.SystemDao;
import com.xy.utils.JdbcUtils;

import java.util.Map;

public class MyshouruDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;

    public String getAddsql(){
        return addsql="insert into myshouru(SID,EID,SMONEY,STM,STIME,SREMARK)" + "values(null,1,?,?,now(),?)";
    }

    public static String getQueryAllsql() {
        queryAllsql="select * from myemp e,myshouru s where s.EID = e.EID ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from myshouru ";
        return queryAllsqlCount;
    }

    public boolean add(Map map) {

        int length = 3;
        Object[] objects = new Object[length];
        objects[0] = map.get("smoney");
        objects[1] = map.get("stm");
        objects[2] = map.get("sremark");
        return JdbcUtils.update(getAddsql(),objects);
    }
}
