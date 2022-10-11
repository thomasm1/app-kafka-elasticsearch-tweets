package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dao.DeptDao;
import dao.DeptDaoImpl;
//import db.DB;
import models.Dept; 

public class DeptService {

	public static DeptDao deptdao = new DeptDaoImpl();

	public static boolean addDept(Dept d) { 
//		 DB.depts.put(d.getDeptId(), d);
//		return null;
		System.out.println("Passing DeptService ...");
		 return deptdao.addDept(d);
	
	}
	public static Dept getDept(int id) {
//		return DB.depts.get(id);
		System.out.println("Passing DeptService ...");
		return deptdao.getDept(id); 
	
	} 
	
	public static  List<Dept> listDept() {  
//		List<Dept> dailyList = new ArrayList<Dept>();
//		Set<Integer> keys = DB.depts.keySet();
//		for(Integer k: keys)
//			dailyList.add(DB.depts.get(k));
//		return dailyList;
		System.out.println("Passing DeptService   ...");
		return deptdao.listDept();
	
	}
	
}
