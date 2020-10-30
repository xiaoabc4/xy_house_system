package com.xy.service;

import com.xy.dao.impl.MyhouseDaoImpl;
import com.xy.entity.Myarea;
import com.xy.entity.Myhouse;

import java.util.List;
import java.util.Map;

public class MyhouseService implements BaseService{
    MyhouseDaoImpl myhouseDao = new MyhouseDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return myhouseDao.queryRecordsTotal(myhouseDao.getQueryAllsqlCount(),null);
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List queryRecordsListDto(Object[] objects, Map pageMap, Class clazz) {
        return myhouseDao.queryBaseRecords(myhouseDao.getQueryAllsql(),objects,pageMap, Myhouse.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }
}
