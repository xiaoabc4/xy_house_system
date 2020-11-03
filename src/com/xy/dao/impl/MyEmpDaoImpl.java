package com.xy.dao.impl;

import com.xy.dao.SystemDao;
import com.xy.entity.Custom;
import com.xy.entity.MyEmp;
import com.xy.utils.JdbcUtils;

public class MyEmpDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;

    public String getAddsql(){
        return addsql="insert into mycus(CID,CNAME,CSEX,CTEL,CTEL1,CCARD)"+" value (null,?,?,?,?,?)";
    }

    public static String getQueryAllsql() {
        queryAllsql="SELECT * FROM MYJS J,MYEMP E,MYDEPT D WHERE J.JID=E.JID AND E.PID=D.PID";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from myemp ";
        return queryAllsqlCount;
    }


}
