package com.xy.dao.impl;

import com.xy.dao.SystemDao;
import com.xy.entity.Myhouse;

import com.xy.utils.JdbcUtils;

public class MyhouseDaoImpl extends SystemDao {

    private  static   String queryAllsql=null;
    private  static  String queryAllsqlCount=null;
    private  static  String addsql=null;

    public String getAddsql(){
        return addsql="insert  into myhouse(HID,SID,AID,HADDRESS,HFH,HHX,HMJ,HCX,HMONEY,HWF,HDX,HSF,HMQ,DKD,SKD,MKD,HJP,HREMARK,HIMG,HFLAG)" + " values (null,?,?,?,?,?,?,?,?,null,null,null,null,null,null,null,null,null,null,null)";
    }

    public static String getQueryAllsql() {
        queryAllsql="SELECT * FROM mysort s,myhouse h,myarea a WHERE h.AID=a.AID AND h.SID=s.SID ";
        return queryAllsql;
    }

    public static String getQueryAllsqlCount() {
        queryAllsqlCount="select count(1) from myhouse ";
        return queryAllsqlCount;
    }

    public boolean addlist(Myhouse myhouse){
        /**
         *
         *     private  long aid;
         *     private  long sid;
         *     private  long hid;
         *     private  String haddress;
         *     private  String sname;
         *     private  String aname;
         *     private  String hfh;
         *     private  String hhx;
         *     private  String hmj;
         *     private  String hcx;
         *     private  float hmoney;
         */
        int len  =8;
        Object[] objects = new Object[len];
     //   SID,AID,HADDRESS,HFH,HHX,HMJ,HCX,HMONEY
        objects[0] = myhouse.getSid();
        objects[1] = myhouse.getAid();
        objects[2] = myhouse.getHaddress();
        objects[3] = myhouse.getHfh();
        objects[4] = myhouse.getHhx();
        objects[5] = myhouse.getHmj();
        objects[6] = myhouse.getHcx();
        objects[7] = myhouse.getHmoney();

        return JdbcUtils.update(getAddsql(),objects);
    }
}
