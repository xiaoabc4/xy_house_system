package com.xy.service;

import com.xy.entity.MyDept;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    //查询记录总数
    Integer queryRecordsCount();

    //查询记录
    List<Map<String,Object>> queryRecordsList(Object[] objects, Map<String,Object> pageMap,Class clazz);
    //添加记录
    boolean add(Map map);
    //返回list实体类
    List<T>queryRecordsListDto(Object[] objects,Map<String,Object>pageMap,Class clazz);
}
