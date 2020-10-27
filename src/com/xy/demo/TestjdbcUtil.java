package com.xy.demo;

import com.xy.utils.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TestjdbcUtil {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JdbcUtils.getConn();
        Map<String,Object> pageMap = new HashMap<>();
        System.out.println(JdbcUtils.query("select *from user",pageMap));
        String sql = "INSERT INTO `xy`.`user`(`id`, `name`) VALUES (5, '赵六');";
        JdbcUtils.update(sql);
        System.out.println(JdbcUtils.query("select *from user",pageMap));
    }
}
