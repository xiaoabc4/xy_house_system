package com.xy.dao.impl;

import com.xy.controller.Editpsw;
import com.xy.dao.SystemDao;
import com.xy.entity.Custom;
import com.xy.entity.MyEmp;
import com.xy.entity.Myjs;
import com.xy.utils.JdbcUtils;

import java.util.Map;

public class MyEmpDaoImpl extends SystemDao {
    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;
    private  static  String upsql=null;

    public String updatesql(){
        return upsql="update myemp set EPSW = ? WHERE EID = ? ";
    }

    public String getAddsql(){
        return addsql="insert into myemp(EID,PID,JID,ENAME,EPSW,EREALNAME,ETEL,EADDRESS,EFLAG,EREMARK)"
                +" value (null,?,?,?,?,?,?,?,0,?)";
    }

    public static String getQueryAllsql() {
        queryAllsql="SELECT * FROM MYJS J,MYEMP E,MYDEPT D WHERE J.JID=E.JID AND E.PID=D.PID";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from myemp ";
        return queryAllsqlCount;
    }
    public boolean uplist(Map map){

        Object[] objects = new Object[2];
        objects[0] = map.get("epsw");
        objects[1] = map.get("eid");

        return JdbcUtils.update(updatesql(),objects);
    }
    public boolean add(Map map) {

        int length = 8;
        Object[] objects = new Object[length];
        objects[0] = map.get("pid");
        objects[1] = map.get("jid");
        objects[2] = map.get("ename");
        objects[3] = map.get("epsw");
        objects[4] = map.get("erealname");
        objects[5] = map.get("etel");
        objects[6] = map.get("eaddress");
        objects[7] = map.get("eremark");
        return JdbcUtils.update(getAddsql(),objects);
    }
}
