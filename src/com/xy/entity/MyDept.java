package com.xy.entity;

public class MyDept {
    private long pid;//部门编号
    private String pname;//部门名称
    private long pflag;//0使用，1删除
    private String premark;//备注说明

    private Integer up;
    private Integer next;
    private Integer allpages;
    private Integer current;
    private Integer allcount;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public long getPflag() {
        return pflag;
    }

    public void setPflag(long pflag) {
        this.pflag = pflag;
    }

    public String getPremark() {
        return premark;
    }

    public void setPremark(String premark) {
        this.premark = premark;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getAllpages() {
        return allpages;
    }

    public void setAllpages(Integer allpages) {
        this.allpages = allpages;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getAllcount() {
        return allcount;
    }

    public void setAllcount(Integer allcount) {
        this.allcount = allcount;
    }

    @Override
    public String toString() {
        return "MyDept{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pflag=" + pflag +
                ", premark='" + premark + '\'' +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", current=" + current +
                ", allcount=" + allcount +
                '}';
    }
}
