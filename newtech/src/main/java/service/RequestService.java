package service;

//import java.util.ArrayList;
import java.util.List;
//import java.util.Set;

import dao.RequestDao;
import dao.RequestDaoImpl;
//import db.DB;
import models.Request; 

public class RequestService {

	public static RequestDao reqdao = new RequestDaoImpl();

	public static boolean addReq(Request r) {
//		 DB.requests.put(r.getReqId(), r);
//		return null;
		return reqdao.addReq(r); 
	}
	
	public static Request getReq(int id) {
//		return DB.requests.get(id);
		System.out.println("Passing reqService with id ..."+id);
		return reqdao.getReq(id); 
	} 
	
	public static  List<Request> listReq() {  
		System.out.println("Passing ReqService class ...");
		return reqdao.listReq();
//		System.out.println("Passing ReqService class ...");
//		return requestdao.listUser();
//		List<Request> requestList = new ArrayList<Request>();
//		Set<Integer> keys = DB.requests.keySet();
//		for(Integer k: keys)
//			requestList.add(DB.requests.get(k));
//		return requestList;
	}

	public static  List<Request> listReq(int id) {  
		System.out.println("Passing ReqService class ...");
		return reqdao.listReq(id); 
	}
	public static boolean updateReq(Request change) {
		System.out.println("Passing ReqService UPDATE...");
		return reqdao.updateReq(change);
	}
//	public static boolean deleteReq(Request change) {
//		System.out.println("Passing ReqService UPDATE...");
//		return reqdao.deleteReq(change);
//	}
}
