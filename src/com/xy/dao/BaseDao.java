package com.xy.dao;

import com.xy.utils.JdbcUtils;
import org.apache.commons.beanutils.BeanUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDao<T> {
    private T t;

    /**
     * 查询所有记录
     */
    public  final List<T> queryBaseRecords(String sql, Object[] objs, Map<String,Object>pageMap,Class<T>clazz){
        List<T>list=new ArrayList<T>();
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConn();
            Object start =pageMap.get("start");
            Object pageSize=pageMap.get("pageSize");
            //分页参数赋值
            if (pageMap !=null && start !=null && pageSize!=null){
                pre=conn.prepareStatement(sql+" limit "+start+","+pageSize);
            }else {
                pre= conn.prepareStatement(sql);
            }
            //设置执行参数
            if (objs !=null && objs.length>=1){
                for (int i=0; i<objs.length; i++){
                    pre.setObject(i+1,objs[i]);
                }
            }
            //执行查询
            rs=pre.executeQuery();
            //有记录才能取出来
            while (rs.next()){
                //实例化
                T bean=clazz.newInstance();
                getRecordToBean(rs,bean);
                //每次添加一个
                list.add(bean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
                String columnName = metaData.getColumnName(i+1).toLowerCase();
                Object columnValue = rs.getObject(i+1);
                map.put(columnName,columnValue);
            }

            //这个方法会遍历Map<key,value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bran的属性
            BeanUtils.populate(bean,map);

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

                total = rs.getInt(1);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,pre,rs);
        }
        return total;
    }
}
