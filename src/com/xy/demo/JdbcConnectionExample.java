package com.xy.demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//获取一个链接
public class JdbcConnectionExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getConnection());
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        String dababaseType = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mysql";
        String userName = "root";
        String password = "root";
        //通过java反射动态加载数据库类型
        Class.forName(dababaseType);
        //通过驱动管理对象DriverManager获取一个链接
        connection = DriverManager.getConnection(url,userName,password);
        return connection;
    }
}
