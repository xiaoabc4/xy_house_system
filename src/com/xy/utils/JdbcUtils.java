package com.xy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class JdbcUtils {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs =null;

    public static Connection getConn() {
        try {
            Properties properties=new Properties();
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

    /**
     * 查询结果集
     * @param sql
     * @param PageMap
     * @param args
     * @return
     */
        public  static List<Map<String,Object>> query(String sql,Map<String,Object> PageMap,Object... args) {
        List<Map<String,Object>> list = new ArrayList<>();


        try {
            conn=getConn();
            Object start = PageMap.get("start");
            Object pageSize = PageMap.get("pageSize");
            //分页参数赋值
            if (PageMap!=null && start!=null && pageSize!=null){
                ps = conn.prepareStatement(sql+" limit "+start+","+pageSize);

            }else {
                ps= conn.prepareStatement(sql);

            }
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();
            //根据查询结果集获得该rs对应的ResultSetMetaDate
            ResultSetMetaData rsmd = rs.getMetaData();
            //获得返回的列的对象
            int count = rsmd.getColumnCount();
            while (rs.next()){
             Map<String,Object> map = new HashMap<>();
                for (int i = 0; i < count; i++) {
                    map.put(rsmd.getColumnName(i+1),rs.getObject(i+1));
                }
                list.add(map);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(conn,ps,rs);
        }

        return list;
    }

/**
    更新方法
 */
    public  static  boolean update(String sql , Object... args){
        int k = 0;
        try{
            conn = getConn();
            ps = conn.prepareStatement(sql);
            if (args!=null && args.length>=1){
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1,args[i]);
                }
            }
            k = ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn,ps,null);
        }
        return  k>0;


    }

    /**
     * 关闭方法
     * @param conne
     * @param ps
     * @param rs
     */
    public  static void close(Connection conne,PreparedStatement ps,ResultSet rs){
        try {
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (conne != null){
                conne.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
