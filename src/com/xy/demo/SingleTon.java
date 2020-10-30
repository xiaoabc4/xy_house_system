package com.xy.demo;

//单例模式
public class SingleTon {
    private  SingleTon(){};
    private static SingleTon singleTon = null;//定义一个对象

    //获取单例对象
    public  static SingleTon getInstance(){
        if (singleTon == null){
            singleTon = new SingleTon();
        }
        return singleTon;
    }

    public static void main(String[] args) {
        SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = SingleTon.getInstance();
    }
}
