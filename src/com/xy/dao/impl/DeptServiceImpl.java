package com.xy.dao.impl;

import com.xy.entity.MyDept;
import com.xy.utils.NumberUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  admin
 * @version 1.0
 * @desc 部门信息Service
 */
public class DeptServiceImpl {
    DeptBaseDaoImpl dao=new DeptBaseDaoImpl();
    DeptSystemDaoImpl deptSystemDao=new DeptSystemDaoImpl();
    private  static  String queryAllsql="select * from mydept where 1 = 1";
    private  static  String queryAllsqlCount="select count(1) from mydept";
    public  List<MyDept>queryRecords(Object[] objs,Map<String,Object>pageMap){
        String sql="select * from mydept";
        return  dao.queryBaseRecords(sql,null,pageMap,MyDept.class);
    }
    public  Integer queryRecordsTotal(){
        return dao.queryRecordsTotal(queryAllsqlCount,null);
    }


    public Integer queryRecordsCount(){
        return deptSystemDao.queryRecordsTotal(queryAllsqlCount,null);
    }
    private List<Map<String, Object>> queryRecordsList(Object[] objects, Map<String, Object> pageMap) {
        List<Map<String,Object>>list=deptSystemDao.queryRecords(queryAllsql,pageMap,objects);
        System.out.println("List<Map<String,Object>>queryRecords(Object[]objs)="+list);
        return list;
    }
    public List<MyDept>queryRecordsListDto(Object[] objects,Map<String,Object>pageMap){
        //1.查询数据
        List<Map<String,Object>>queryList=queryRecordsList(objects,pageMap);
        //2.new实体类List
        List<MyDept> resultList=new ArrayList<MyDept>();
        if (queryList !=null && !queryList.isEmpty()){
            for (int i= 0;i<queryList.size();i++){
                MyDept dto =new MyDept();
                Map<String,Object>map =queryList.get(i);
                dto.setPid(NumberUtil.getLong(map.get("PID")));
                dto.setPname(map.get("PNAME").toString());
                dto.setPflag(NumberUtil.getLong(map.get("PFLAG")));
                dto.setPremark(map.get("PREMARK").toString());
                resultList.add(dto);
            }
        }
        return  resultList;
    }
    public static void main(String[] args) {
        DeptServiceImpl deptService =new DeptServiceImpl();
        Object[]objects=new Object[]{};
        Map<String,Object>pageMap=new HashMap<String, Object>();
        //List<Map<String,Object>> queryList=deptService.queryRecordsList(objects,pageMap);
        List<MyDept> resultList=deptService.queryRecordsListDto(objects,pageMap);
        System.out.println("resultList="+resultList);
        //System.out.println("queryList="+queryList);
    }

}
