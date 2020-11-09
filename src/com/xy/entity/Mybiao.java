package com.xy.entity;

public class Mybiao extends Pagedto{
    private Long bid;           //编号
    private Long hid;           //房子编号
    private Long dkd;           //电刻度
    private Long skd;           //水刻度
    private String mkd;         //煤刻度
    private Long mtime;         //操表时间
    private Long eid;           //经办人编号

    private String haddress;    //房子地址
    private String hfh;         //房号
    private String erealname;   //经办人

    @Override
    public String toString() {
        return "Mybiao{" +
                "bid=" + bid +
                ", hid=" + hid +
                ", dkd=" + dkd +
                ", skd=" + skd +
                ", mkd='" + mkd + '\'' +
                ", mtime=" + mtime +
                ", eid=" + eid +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", erealname='" + erealname + '\'' +
                '}';
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public Long getDkd() {
        return dkd;
    }

    public void setDkd(Long dkd) {
        this.dkd = dkd;
    }

    public Long getSkd() {
        return skd;
    }

    public void setSkd(Long skd) {
        this.skd = skd;
    }

    public String getMkd() {
        return mkd;
    }

    public void setMkd(String mkd) {
        this.mkd = mkd;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHfh() {
        return hfh;
    }

    public void setHfh(String hfh) {
        this.hfh = hfh;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }
}
