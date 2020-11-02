package com.xy.service;

import com.xy.dao.impl.MysortDaoImpl;
import com.xy.entity.MyEmp;
import com.xy.entity.Myarea;
import com.xy.entity.Myjs;
import com.xy.entity.Mysort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysortService implements BaseService{

    MysortDaoImpl mysortDao = new MysortDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return mysortDao.queryRecordsTotal(mysortDao.getQueryAllsqlCount(),null);
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List queryRecordsListDto(Object[] objects, Map pageMap, Class clazz) {
        return mysortDao.queryBaseRecords(mysortDao.getQueryAllsql(),objects,pageMap, Mysort.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }


}
