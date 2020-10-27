package com.xy.entity;

public class Pagedto {
    private Integer up;
    private Integer next;
    private Integer allpages;
    private Integer current;
    private Integer allcount;

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
        return "Pagedto{" +
                "up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", current=" + current +
                ", allcount=" + allcount +
                '}';
    }
}
