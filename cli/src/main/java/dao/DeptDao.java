package dao;

import java.util.List;

import models.Dept;

public interface DeptDao {
 
	public boolean addDept(Dept u); 
	public Dept getDept(int id); 
//	public Dept getDept(String username); 
	public List<Dept> listDept(); 
	public boolean updateDept(Dept change);
	public boolean deleteDept(int id);
	 
}
