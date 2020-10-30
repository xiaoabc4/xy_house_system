package com.xy.service;

import com.xy.dao.impl.MyareaDaoImpl;
import com.xy.entity.Myarea;
import com.xy.entity.Myjs;

import javax.servlet.annotation.WebServlet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyareaService  implements BaseService{
    MyareaDaoImpl myareaDao = new MyareaDaoImpl();
    @Override
    public Integer queryRecordsCount() {

        return myareaDao.queryRecordsTotal(myareaDao.getQueryAllsqlCount(),null);
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List queryRecordsListDto(Object[] objects, Map pageMap, Class clazz) {
        return myareaDao.queryBaseRecords(myareaDao.getQueryAllsql(),objects,pageMap, Myarea.class);
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap, Class clazz) {
        return null;
    }

}
