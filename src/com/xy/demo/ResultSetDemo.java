package com.xy.demo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetDemo {
    /**
     * 程序的入口
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<Map<String, Object>> list = new ArrayList<>();
        //1.获取结果集
        ResultSet resultSet =PreparedStatementDemo.getResultSet();
        System.out.println("resultSet=" + resultSet);
        //2.获取结果集元数据
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        //3.获取列数
        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount="+ columnCount);
        //4.判断结果集是否有数据
        while(resultSet.next()){
            Map<String,Object> map = new HashMap<>();
            for (int i = 1; i<=columnCount; i++){
                map.put(resultSetMetaData.getCatalogName(i),resultSet.getObject(i));
            }
            list.add(map);
        }
        //5.输出数据
        System.out.println("list="+ list.toString());
    }
}
