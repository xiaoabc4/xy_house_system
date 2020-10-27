package com.xy.dao;

import com.xy.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;


/**
 * @author admin
 * @version 1.0
 * @desc 系统基类DAO
 * */

public abstract  class SystemDao extends BaseDao{

    /**
     *
     * @param sql
     * @param pageMap
     * @param objects
     * @return
     */

    public final List<Map<String,Object>> queryRecords(String sql,Map<String,Object> pageMap,Object... objects){
        return JdbcUtils.query(sql,pageMap,objects);
    }


    /**
     * desc 通用的更新方法 包括INSERT/UPDATE/DELETE
     * @param sql
     * @param args
     * @return
     */
    public boolean update(String sql,Object... args){
        return JdbcUtils.update(sql,args);
    }

    /**
     *
     * @param sql
     * @param objs 跟设置参数一一对应
     * @return
     * @desc 获取总记录数
     */

}
