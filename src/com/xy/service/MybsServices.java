package com.xy.service;

import com.xy.dao.impl.MybsDaoImpl;
import com.xy.entity.Mybiao;
import com.xy.entity.Mybs;

import java.util.List;
import java.util.Map;

public class MybsServices implements BaseService{
    MybsDaoImpl dao = new MybsDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return  dao.queryRecordsTotal(dao.getQueryAllsqlCount(),null);
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
        return dao.queryBaseRecords(dao.getQueryAllsql(),objects,pageMap, Mybs.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }

}
