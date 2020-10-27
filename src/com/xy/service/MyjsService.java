package com.xy.service;

import com.xy.dao.impl.MyjsDaoImpl;
import com.xy.entity.Myjs;
import com.xy.utils.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyjsService implements BaseService{
    MyjsDaoImpl myjsDao = new MyjsDaoImpl();

    @Override
    public Integer queryRecordsCount() {
        return myjsDao.queryRecordsTotal(myjsDao.getQueryAllsqlCount(),null);
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List<Myjs> queryRecordsListDto(Object[] objects, Map pageMap) {
        //1.查询数据
        List<Map<String,Object>>queryList=queryRecordsList(objects,pageMap);
        //2.new实体类List
        List<Myjs> resultList=new ArrayList<Myjs>();
        if (queryList !=null && !queryList.isEmpty()){
            for (int i= 0;i<queryList.size();i++){
                Myjs dto =new Myjs();
                Map<String,Object>map = queryList.get(i);
                dto.setJid(NumberUtil.getLong(map.get("JID")));
                dto.setJname(map.get("JNAME").toString());
                resultList.add(dto);
            }
        }
        return  resultList;
    }

    @Override
    public List<Map<String, Object>> queryRecordsList(Object[] objects, Map pageMap) {
        List<Map<String,Object>>list=myjsDao.queryRecords(myjsDao.getQueryAllsql(),pageMap,objects);
        System.out.println("List<Map<String,Object>>queryRecords(Object[]objs)="+list);
        return list;
    }

}
