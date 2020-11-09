package com.xy.service;

import com.xy.dao.impl.MybiaoDaoImpl;
import com.xy.entity.Mybiao;

import java.util.List;
import java.util.Map;

public class MybiaoService implements BaseService{
    MybiaoDaoImpl dao = new MybiaoDaoImpl();

    @Override
    public Integer queryRecordsCount() {
        return dao.queryRecordsTotal(dao.getQueryAllsqlCount(),null);
    }

    @Override
    public boolean add(Map map) {
        if (map==null){
            return false;
        }else {
            return dao.add(map);
        }
    }

    @Override
    public List queryRecordsListDto(Object[] objects, Map pageMap, Class clazz) {
        return dao.queryBaseRecords(dao.getQueryAllsql(),objects,pageMap, Mybiao.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }

}
