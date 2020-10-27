package com.xy.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

//数据库预编译类
public class PreparedStatementDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    String sql="select * from user where 1 =?";
    //使用object对象数组进行动态传参
        Object[] objs = {1};
        //获得结果集
        getResultSet(sql,objs);
    }
//封装成案例方法
    public static ResultSet getResultSet(String sql,Object[] objs) throws SQLException, ClassNotFoundException {
        //获取一个数据库链接
        Connection connection = JdbcConnectionExample.getConnection();
        //使用String类型的sql
        PreparedStatement ps = connection.prepareStatement(sql);
        //输出预编译对象
        System.out.println("ps="+ps);
        //ps对象对需要替代的参数进行赋值
        if (objs!=null && objs.length>=1){
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i+1,objs[i]);
            }
        }
        //ps对象执行查询sql，返回执行查询结果集resultSet
        ResultSet resultSet = ps.executeQuery();
        return  resultSet;
    }

    public static ResultSet getResultSet() throws SQLException, ClassNotFoundException {
        //获取一个数据库链接
        Connection connection = JdbcConnectionExample.getConnection();
        //定义String类型的sql
        String sql = "select * from user where 1 = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        //输出预编译对象
        System.out.println("pa"+ps);
        //使用object对象数组进行动态传参
        Object[] objs = {1};
        //ps对象对需要替代的对象进行赋值
        if(objs!=null && objs.length>=1){
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i+1,objs[i]);
            }
        }
        //返回查询结果集
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }
}
