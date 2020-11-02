package com.xy.service;

import com.xy.dao.impl.MyjsDaoImpl;
import com.xy.entity.Myjs;
import com.xy.utils.NumberUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyjsService implements BaseService{
    MyjsDaoImpl myjsDao = new MyjsDaoImpl();

    @Override
    public Integer queryRecordsCount() {
        return myjsDao.queryRecordsTotal(myjsDao.getQueryAllsqlCount(),null);
    }

    @Override
    public List<Myjs> queryRecordsListDto(Object[] objects, Map pageMap ,Class clazz) {

        return  myjsDao.queryBaseRecords(myjsDao.getQueryAllsql(),objects,pageMap,Myjs.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap,Class clazz) {

        return null;
    }

    @Override
    public boolean add(Map map) {

        return false;
    }



}
