package app.mapl.dao;

import java.util.List;

import app.mapl.models.Groups;

public interface GroupsDao {

	public boolean addGroups(Groups u);
	public Groups getGroups(int id);
//	public Group getGroups(String username);
	public List<Groups> listGroups();
	public boolean updateGroups(Groups change);
	public boolean deleteGroups(int id);

}