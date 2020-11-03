package com.xy.dao.impl;

import com.xy.entity.Custom;
import com.xy.entity.MyDept;
import com.xy.utils.JdbcUtils;
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
    private  static  String addsql=null;
    public String getAddsql(){
        return addsql="insert into mydept(PID,PNAME,PREMARK,PFLAG)"+" value (null,?,?,0)";
    }
    //添加客户记录
    public boolean addlist(MyDept myDept){
        int len  =2;
        Object[] objects = new Object[len];
        objects[0] = myDept.getPname();
        objects[1] = myDept.getPremark();

        return JdbcUtils.update(getAddsql(),objects);
    }

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


}
