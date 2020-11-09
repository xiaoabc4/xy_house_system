package com.xy.entity;

public class Mydj extends Pagedto{
    private Long mid;           //编号
    private String mdate;       //登记时间
    private Long eid;           //经办人编号（员工编号）
    private Long cid;           //客户编号
    private Long hid;           //房屋编号
    private String mimg;        //合同图片
    private String myj;         //押金
    private String myzj;        //预收租金
    private String mflag;       //正在出租中为0，退租为1
    private String mbegintime;  //下次收租日期

    private String haddress;    //房子地址
    private String hfh;         //房号
    private String cname;       //客户姓名
    private String ctel;       //客户电话
    private String erealname;   //经办人

    @Override
    public String toString() {
        return "Mydj{" +
                "mid=" + mid +
                ", mdate='" + mdate + '\'' +
                ", eid=" + eid +
                ", cid=" + cid +
                ", hid=" + hid +
                ", mimg='" + mimg + '\'' +
                ", myj='" + myj + '\'' +
                ", myzj='" + myzj + '\'' +
                ", mflag='" + mflag + '\'' +
                ", mbegintime='" + mbegintime + '\'' +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", cname='" + cname + '\'' +
                ", ctel='" + ctel + '\'' +
                ", erealname='" + erealname + '\'' +
                '}';
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public String getMimg() {
        return mimg;
    }

    public void setMimg(String mimg) {
        this.mimg = mimg;
    }

    public String getMyj() {
        return myj;
    }

    public void setMyj(String myj) {
        this.myj = myj;
    }

    public String getMyzj() {
        return myzj;
    }

    public void setMyzj(String myzj) {
        this.myzj = myzj;
    }

    public String getMflag() {
        return mflag;
    }

    public void setMflag(String mflag) {
        this.mflag = mflag;
    }

    public String getMbegintime() {
        return mbegintime;
    }

    public void setMbegintime(String mbegintime) {
        this.mbegintime = mbegintime;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }
}
