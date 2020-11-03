package com.xy.service;

import com.xy.dao.impl.CustomDaoImpl;
import com.xy.entity.Custom;
import com.xy.entity.Myjs;

import java.util.HashMap;
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
    public List<Custom> queryRecordsListDto(Object[] objects, Map pageMap, Class clazz) {
        return  dao.queryBaseRecords(dao.getQueryAllsql(),objects,pageMap, Custom.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }

    public static void main(String[] args) {
        CustomService customService = new CustomService();
        CustomDaoImpl dao = new CustomDaoImpl();
        Object[] objects = null;
        Map pageMap = new HashMap();
        List<Custom> q = customService.queryRecordsListDto(objects,pageMap,Custom.class);
        System.out.println(q);
    }
}
