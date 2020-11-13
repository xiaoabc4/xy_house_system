package com.xy.dao.impl;

import com.xy.dao.SystemDao;
import com.xy.utils.JdbcUtils;

import java.util.Map;

public class MyzhichuDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;

    public String getAddsql(){
        return addsql="insert into myzhichu(ZID,EID,ZMONEY,ZTM,ZTIME,ZREMARK)" + "values(null,1,?,?,now(),?)";
    }

    public static String getQueryAllsql() {
        queryAllsql="select * from myemp e,myzhichu z where e.EID = z.EID ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from myzhichu ";
        return queryAllsqlCount;
    }

    public boolean add(Map map) {

        int length = 3;
        Object[] objects = new Object[length];
        objects[0] = map.get("zmoney");
        objects[1] = map.get("ztm");
        objects[2] = map.get("zremark");
        return JdbcUtils.update(getAddsql(),objects);
    }
}
