package com.xy.entity;

public class Myjs extends Pagedto{

    Long jid;//角色编号
    String jname;//角色名称

    public Long getJid() {
        return jid;
    }

    public void setJid(Long jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    @Override
    public String toString() {
        return "Myjs{" +
                "jid=" + jid +
                ", jname='" + jname + '\'' +
                '}';
    }
}
