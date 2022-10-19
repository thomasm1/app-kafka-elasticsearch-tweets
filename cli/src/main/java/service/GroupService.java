package service;

import java.util.List;

import dao.GroupDao;
import dao.GroupDaoImpl;
//import db.DB;
import models.Group; 

public class GroupService {

	public static GroupDao groupdao = new GroupDaoImpl();

	public static boolean addGroup(Group d) { 
//		 DB.groups.put(d.getGroupId(), d);
//		return null;
		System.out.println("Passing GroupService ...");
		 return groupdao.addGroup(d);
	
	}
	public static Group getGroup(int id) {
//		return DB.groups.get(id);
		System.out.println("Passing GroupService ...");
		return groupdao.getGroup(id); 
	
	} 
	
	public static  List<Group> listGroup() {  
//		List<Group> dailyList = new ArrayList<Group>();
//		Set<Integer> keys = DB.groups.keySet();
//		for(Integer k: keys)
//			dailyList.add(DB.groups.get(k));
//		return dailyList;
		System.out.println("Passing GroupService   ...");
		return groupdao.listGroup();
	
	}
	
}
