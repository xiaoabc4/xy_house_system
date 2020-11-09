package com.xy.service;

import com.xy.dao.impl.DjrzDaoImpl;
import com.xy.entity.Myarea;
import com.xy.entity.Mydj;

import java.util.List;
import java.util.Map;

public class DjrzService implements BaseService{
    DjrzDaoImpl dao = new DjrzDaoImpl();
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
        return dao.queryBaseRecords(dao.getQueryAllsql(),objects,pageMap, Mydj.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }
}
