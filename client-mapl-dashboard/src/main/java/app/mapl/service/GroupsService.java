package app.mapl.service;

import java.util.List;

import app.mapl.dao.GroupsDao;
import app.mapl.dao.GroupsDaoImpl;
//import db.DB;
import app.mapl.models.Groups;

public class GroupsService {

	public static GroupsDao groupsdao = new GroupsDaoImpl();

	public static boolean addGroups(Groups d) {
//		 DB.groups.put(d.getGroupsId(), d);
//		return null;
		System.out.println("Passing GroupsService ...");
		 return groupsdao.addGroups(d);
	
	}
	public static Groups getGroups(int id) {
//		return DB.groups.get(id);
		System.out.println("Passing GroupsService ...");
		return groupsdao.getGroups(id);
	
	} 
	
	public static  List<Groups> listGroups() {
//		List<Groups> dailyList = new ArrayList<Groups>();
//		Set<Integer> keys = DB.groups.keySet();
//		for(Integer k: keys)
//			dailyList.add(DB.groups.get(k));
//		return dailyList;
		System.out.println("Passing GroupsService   ...");
		return groupsdao.listGroups();
	
	}
	
}
