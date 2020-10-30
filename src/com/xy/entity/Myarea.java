package com.xy.entity;

public class Myarea extends Pagedto{
    private  long aid;
    private  String aname;

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Myarea{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                '}';
    }
}
