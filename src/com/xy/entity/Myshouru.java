package com.xy.entity;

public class Myshouru extends Pagedto{
   int sid;
   int eid;
   String smoney;
   String stm;
   String stime;
   String sremark;
   String erealname;

    @Override
    public String toString() {
        return "Myshouru{" +
                "sid=" + sid +
                ", eid=" + eid +
                ", smoney='" + smoney + '\'' +
                ", stm='" + stm + '\'' +
                ", stime='" + stime + '\'' +
                ", sremark='" + sremark + '\'' +
                ", erealname='" + erealname + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getSmoney() {
        return smoney;
    }

    public void setSmoney(String smoney) {
        this.smoney = smoney;
    }

    public String getStm() {
        return stm;
    }

    public void setStm(String stm) {
        this.stm = stm;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }
}
