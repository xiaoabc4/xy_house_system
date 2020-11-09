package com.xy.service;

import com.xy.dao.impl.MysfDaoImpl;
import com.xy.entity.Myjs;
import com.xy.entity.Mysf;

import java.util.List;
import java.util.Map;

public class MysfService implements BaseService{
    MysfDaoImpl dao = new MysfDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return  dao.queryRecordsTotal(dao.getQueryAllsqlCount(),null);
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List queryRecordsListDto(Object[] objects, Map pageMap, Class clazz) {
        return dao.queryBaseRecords(dao.getQueryAllsql(),objects,pageMap, Mysf.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }
}
