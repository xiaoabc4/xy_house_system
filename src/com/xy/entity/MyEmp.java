package com.xy.entity;

public class MyEmp extends Pagedto{
    private long eid;
    private long pid;
    private long jid;
    private String ename;
    private String epsw;
    private String erealname;
    private String etel;
    private String eaddress;
    private long eflag;
    private String eremark;

    private  String pname;
    private  String jname;

    @Override
    public String toString() {
        return "MyEmp{" +
                "eid=" + eid +
                ", pid=" + pid +
                ", jid=" + jid +
                ", ename='" + ename + '\'' +
                ", epsw='" + epsw + '\'' +
                ", erealname='" + erealname + '\'' +
                ", etel='" + etel + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", eflag=" + eflag +
                ", eremark='" + eremark + '\'' +
                ", pname='" + pname + '\'' +
                ", jname='" + jname + '\'' +
                '}';
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getJid() {
        return jid;
    }

    public void setJid(long jid) {
        this.jid = jid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEpsw() {
        return epsw;
    }

    public void setEpsw(String epsw) {
        this.epsw = epsw;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    public String getEtel() {
        return etel;
    }

    public void setEtel(String etel) {
        this.etel = etel;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public long getEflag() {
        return eflag;
    }

    public void setEflag(long eflag) {
        this.eflag = eflag;
    }

    public String getEremark() {
        return eremark;
    }

    public void setEremark(String eremark) {
        this.eremark = eremark;
    }
}
