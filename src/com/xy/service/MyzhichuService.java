package com.xy.service;

import com.xy.dao.impl.MyzhichuDaoImpl;
import com.xy.entity.Myshouru;
import com.xy.entity.Myzhichu;

import java.util.List;
import java.util.Map;

public class MyzhichuService implements BaseService{
    MyzhichuDaoImpl dao = new MyzhichuDaoImpl();
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
        return  dao.queryBaseRecords(dao.getQueryAllsql(),objects,pageMap, Myzhichu.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }
}
