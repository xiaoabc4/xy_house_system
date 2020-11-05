package com.xy.entity;

public class Myhouse extends Pagedto{
    /**
     *
     */
    private  long aid;
    private  long sid;
    private  long hid;
    private  String haddress;
    private  String sname;
    private  String aname;
    private  String hfh;
    private  String hhx;
    private  String hmj;
    private  String hcx;
    private  float hmoney;
    private  long hflagnumber; //1代表正在出租0---没有出租

    /**
     * 		  "house.hwf":hwf,
     * 		  "house.hdx":hdx,
     * 		  "house.hsf":hsf,
     * 		  "house.hmq":hmq,
     * 		  "house.dkd":dkd,
     * 		  "house.skd":skd,
     * 		  "house.mkd":mkd,
     * 		  "house.hjp":hjp,
     * 		  "house.hremark":hremark
     *
     * @return
     */

    @Override
    public String toString() {
        return "Myhouse{" +
                "aid=" + aid +
                ", sid=" + sid +
                ", hid=" + hid +
                ", haddress='" + haddress + '\'' +
                ", sname='" + sname + '\'' +
                ", aname='" + aname + '\'' +
                ", hfh='" + hfh + '\'' +
                ", hhx='" + hhx + '\'' +
                ", hmj='" + hmj + '\'' +
                ", hcx='" + hcx + '\'' +
                ", hmoney=" + hmoney +
                ", hflagnumber=" + hflagnumber +
                '}';
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public long getHid() {
        return hid;
    }

    public void setHid(long hid) {
        this.hid = hid;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getHfh() {
        return hfh;
    }

    public void setHfh(String hfh) {
        this.hfh = hfh;
    }

    public String getHhx() {
        return hhx;
    }

    public void setHhx(String hhx) {
        this.hhx = hhx;
    }

    public String getHmj() {
        return hmj;
    }

    public void setHmj(String hmj) {
        this.hmj = hmj;
    }

    public String getHcx() {
        return hcx;
    }

    public void setHcx(String hcx) {
        this.hcx = hcx;
    }

    public float getHmoney() {
        return hmoney;
    }

    public void setHmoney(float hmoney) {
        this.hmoney = hmoney;
    }

    public long getHflagnumber() {
        return hflagnumber;
    }

    public void setHflagnumber(long hflagnumber) {
        this.hflagnumber = hflagnumber;
    }
}
