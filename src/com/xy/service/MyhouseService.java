package com.xy.service;

import com.xy.dao.impl.MyhouseDaoImpl;
import com.xy.entity.Myarea;
import com.xy.entity.Myhouse;
import com.xy.entity.Myjs;

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
        if(objects !=null && objects.length>=1){
            return myhouseDao.queryBaseRecords(myhouseDao.getQueryAllsql() +" and h.Aid = ?",objects,pageMap, Myhouse.class);
        }else {
            return myhouseDao.queryBaseRecords(myhouseDao.getQueryAllsql(),null,pageMap, Myhouse.class);
        }

    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }

    public boolean addlist(Myhouse myhouse){
        if (myhouse==null){
            return  false;
        }else {
            return myhouseDao.addlist(myhouse);
        }
    }
}
