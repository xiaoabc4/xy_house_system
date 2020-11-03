package com.xy.entity;

public class Custom extends Pagedto{
   String cname; //客户姓名
    String csex;//客户性别
    String ctel; //电话
    String ctel1;//备用电话
    String ccard;//身份证号
    long cid;//编号

    @Override
    public String toString() {
        return "Custom{" +
                "cname='" + cname + '\'' +
                ", csex='" + csex + '\'' +
                ", ctel='" + ctel + '\'' +
                ", ctel1='" + ctel1 + '\'' +
                ", ccard='" + ccard + '\'' +
                ", cid=" + cid +
                '}';
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getCtel1() {
        return ctel1;
    }

    public void setCtel1(String ctel1) {
        this.ctel1 = ctel1;
    }

    public String getCcard() {
        return ccard;
    }

    public void setCcard(String ccard) {
        this.ccard = ccard;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }
}
