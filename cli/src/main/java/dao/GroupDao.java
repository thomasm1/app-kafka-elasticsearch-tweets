package dao;

import java.util.List;

import models.Group;

public interface GroupDao {
 
	public boolean addGroup(Group u); 
	public Group getGroup(int id); 
//	public Group getGroup(String username); 
	public List<Group> listGroup(); 
	public boolean updateGroup(Group change);
	public boolean deleteGroup(int id);
	 
}
