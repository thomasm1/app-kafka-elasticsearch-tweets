package dao;

import java.util.List;

import models.Request;

public interface RequestDao {

	public boolean addReq(Request u); 
	public Request getReq(int id); 
//	public Request getReq(String username); 
	public List<Request> listReq(); 
	public List<Request> listReq(int id); 
	public boolean updateReq(Request change);
//	public boolean deleteReq(String username);
//	public boolean deleteReq(Request change);
	boolean deleteReq(int id);
}
