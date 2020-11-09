package com.xy.entity;

public class Mybs extends Pagedto{
    private Long bid;           //编号
    private Long hid;           //房子编号
    private Long mtime;         //报损时间
    private String bremark;     //备注说明
    private Long eid;           //经办人编号

    private String haddress;    //房子地址
    private String hfh;         //房号
    private String erealname;   //经办人

    @Override
    public String toString() {
        return "Mybs{" +
                "bid=" + bid +
                ", hid=" + hid +
                ", mtime=" + mtime +
                ", bremark='" + bremark + '\'' +
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

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    public String getBremark() {
        return bremark;
    }

    public void setBremark(String bremark) {
        this.bremark = bremark;
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
