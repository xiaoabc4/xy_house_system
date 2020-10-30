package com.xy.entity;

public class Mysort extends Pagedto{
    private long sid;
    private String sname;

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Mysort{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }
}
