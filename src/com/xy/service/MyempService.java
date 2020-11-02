package com.xy.service;

import com.xy.dao.impl.MyEmpDaoImpl;
import com.xy.entity.MyEmp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyempService implements BaseService {

    MyEmpDaoImpl myEmpDao = new MyEmpDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return myEmpDao.queryRecordsTotal(myEmpDao.getQueryAllsqlCount(),null);
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List queryRecordsListDto(Object[] objects, Map pageMap, Class clazz) {

        List list2 = myEmpDao.queryBaseRecords(myEmpDao.getQueryAllsql(),objects,pageMap, MyEmp.class);


        return list2;
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {

        return null;
    }

}
