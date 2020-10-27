package com.xy.dao;

import com.xy.utils.JdbcUtils;
import org.apache.commons.beanutils.BeanUtils;


import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDao<T> {
    private T t;

    /**
     * 查询所以记录
     * @param sql
     * @param objects
     * @param pageMap
     * @param clazz
     * @return
     */
    public final List<T> queryBaseRecords(String sql, Object[] objects, Map<String,Object> pageMap,Class<T> clazz){
        List<T>  list  = new ArrayList<T>();
        Connection conn = null;
        PreparedStatement  pre = null;
        ResultSet rs =null;

        try {
            conn = JdbcUtils.getConn();
            Object start = pageMap.get("start");
            Object pageSize = pageMap.get("pageSize");
            //分页参数赋值
            if(pageMap!=null&&start!=null&&pageSize!=null){
                pre = conn.prepareStatement(sql+" limit "+ start +","+ pageSize);
            }else {
                pre = conn.prepareStatement(sql);
            }
            //设置查询参数
            if(objects !=null&& objects.length>0){
                for (int i = 0; i < objects.length; i++) {
                    pre.setObject(i+1,objects[i]);
                }
            }
            //执行查询
            rs = pre.executeQuery();
            //有记录才取出来
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()){
                //实例化
                HashMap<String, Object> map = new HashMap<>();
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
//                    map.put(metaData.getColumnName(i+1),rs.getObject(i+1));
                    Field field = clazz.getDeclaredField(metaData.getColumnName(i + 1).toLowerCase());
                    field.setAccessible(true);
                    field.set(t,rs.getObject(i+1));
                }
//                BeanUtils.populate(t,map);
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            JdbcUtils.close(conn,pre,rs);
        }
        return  list;
    }

    //获取一行记录
    //Object bean用于装一行记录
    private void  getRecordToBean(ResultSet rs ,Object bean){
        Map<String,Object> map = new HashMap<>();
        try{
            //获取结果集元数据
            ResultSetMetaData metaData = rs.getMetaData();
            //获取列数
            int columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Object columnValue = rs.getObject(i);
                map.put(columnName,columnValue);
            }
            //这个方法会遍历Map<key,value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bran的属性
            BeanUtils.populate(bean,map);
            System.out.println(bean);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public final  int queryRecordsTotal(String sql,Object... objs){
        Connection conn = null;
        PreparedStatement pre =null;
        ResultSet rs = null;
        Integer total =0;
        try {
            conn = JdbcUtils.getConn();
            pre = conn.prepareStatement(sql);

            //设置查询参数
            if (objs != null && objs.length > 0) {
                for (int i = 0; i < objs.length; i++) {
                    pre.setObject(i + 1, objs[i]);
                }
            }
            //执行查询
            rs = pre.executeQuery();
            //有记录才取出来
            if (rs.next()) {
                System.out.println("total" + total);
                total = rs.getInt(1);
                System.out.println("total2" + total);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,pre,rs);
        }
        return total;
    }
}
