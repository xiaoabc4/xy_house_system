package com.xy.service;

import com.xy.dao.impl.MyshouruDaoImpl;
import com.xy.entity.Mybs;
import com.xy.entity.Myshouru;

import java.util.List;
import java.util.Map;

public class MyshouruService implements BaseService{
    MyshouruDaoImpl dao = new MyshouruDaoImpl();
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
       return dao.queryBaseRecords(dao.getQueryAllsql(),objects,pageMap, Myshouru.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }
}
