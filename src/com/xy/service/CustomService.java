package com.xy.service;

import com.xy.dao.impl.CustomDaoImpl;
import com.xy.entity.Custom;

import java.util.List;
import java.util.Map;

public class CustomService implements BaseService{

    CustomDaoImpl dao = new CustomDaoImpl();

    public boolean addCustom(Custom custom){
        if (custom==null){
            return  false;
        }else {
            return dao.addCustom(custom);
        }
    }

    @Override
    public Integer queryRecordsCount() {
        return dao.queryRecordsTotal(dao.getQueryAllsqlCount(),null);
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List queryRecordsListDto(Object[] objects, Map pageMap, Class clazz) {
        return dao.queryBaseRecords(dao.getQueryAllsqlCount(),objects,pageMap,Custom.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }
}
