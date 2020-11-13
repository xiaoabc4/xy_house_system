package com.xy.entity;

public class Myzhichu extends Pagedto{
    int zid;
    int eid;
    String zmoney;
    String ztm;
    String ztime;
    String zremark;
    String erealname;

    @Override
    public String toString() {
        return "Myzhichu{" +
                "zid=" + zid +
                ", eid=" + eid +
                ", zmoney='" + zmoney + '\'' +
                ", ztm='" + ztm + '\'' +
                ", ztime='" + ztime + '\'' +
                ", zremark='" + zremark + '\'' +
                ", erealname='" + erealname + '\'' +
                '}';
    }

    public int getZid() {
        return zid;
    }

    public void setZid(int zid) {
        this.zid = zid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getZmoney() {
        return zmoney;
    }

    public void setZmoney(String zmoney) {
        this.zmoney = zmoney;
    }

    public String getZtm() {
        return ztm;
    }

    public void setZtm(String ztm) {
        this.ztm = ztm;
    }

    public String getZtime() {
        return ztime;
    }

    public void setZtime(String ztime) {
        this.ztime = ztime;
    }

    public String getZremark() {
        return zremark;
    }

    public void setZremark(String zremark) {
        this.zremark = zremark;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }
}
