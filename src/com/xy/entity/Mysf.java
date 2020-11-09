package com.xy.entity;

public class Mysf extends Pagedto{
    private String yid;             //编号
    private String mid;             //入住编号
    private String eid;             //经办人编号（员工编号）
    private String myzj;            //预收租金
    private String mbegintime;      //下次收租日期

    private String haddress;        //房子地址
    private String hfh;             //房号
    private String cname;           //客户姓名
    private String ctel;            //客户电话
    private String mdate;           //登记时间

    @Override
    public String toString() {
        return "Mysf{" +
                "yid='" + yid + '\'' +
                ", mid='" + mid + '\'' +
                ", eid='" + eid + '\'' +
                ", myzj='" + myzj + '\'' +
                ", mbegintime='" + mbegintime + '\'' +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", cname='" + cname + '\'' +
                ", ctel='" + ctel + '\'' +
                ", mdate='" + mdate + '\'' +
                '}';
    }

    public String getYid() {
        return yid;
    }

    public void setYid(String yid) {
        this.yid = yid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getMyzj() {
        return myzj;
    }

    public void setMyzj(String myzj) {
        this.myzj = myzj;
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

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }
}
