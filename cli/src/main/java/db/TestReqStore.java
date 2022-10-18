package db;

import java.util.HashMap;
import java.util.Map;

import models.Task;
import models.Dept; 
import models.UserAdmin;
import models.Request;

public class TestReqStore {
	
	public static Map<Integer, Task> tasks = new HashMap<Integer, Task>();  
	public static Map<Integer, Dept> depts = new HashMap<Integer, Dept>();
	public static Map<Integer, UserAdmin> userAdmins = new HashMap<Integer, UserAdmin>();
	public static Map<Integer, Request> requests = new HashMap<Integer, Request>();
	
	static {  // Static initializer 1st; shared among all super-constructors, but only by last of this-constructors
		///////////////////////  TASKS
		Task d1 = new Task(1, 1, 1,"1-20-20", "URL" , "newRules", "newConf", "numeric", "70%", 300.99, 1);
		Task d2 = new Task(2, 2, 1,"2-20-20", "form data" , "newRules", "newConf", "numeric", "80%", 250.00, 1); 
		Task d3 = new Task(3, 3, 4,"12-21-19", "  data" , "newRules", "newConf", "numeric", "90%", 450.00, 1); 
		Task d4 = new Task(4, 4, 3,"12-6-19", "PDF upload data" , "newRules", "newConf", "numeric", "80%", 450.00, 1);
		Task d5 = new Task(5, 5, 3,"12-9-19", "form data" , "newRules", "newConf", "numeric", "80%", 750.00, 1);   System.out.println(d1);
		tasks.put(1, d1);
		tasks.put(2, d2); 
		tasks.put(3, d3);  
		tasks.put(4, d4);  
		tasks.put(5, d5); 
		
		/////////////////////// Dept
		Dept templateDept1 = new Dept(1, 24, "Business Dept.");
		Dept templateDept2 = new Dept(2, 12, "Arts & Science Dept.");
		Dept templateBenco = new Dept(3, 52, "Benefits Coordination");	 	System.out.println(templateDept1);
		depts.put(1, templateDept1);
		depts.put(2, templateDept2);
		depts.put(3, templateBenco);
		
		/////////////////////// UserAdmin
		//int userId, int deptId, int superId, String userName, String password, String email) {
		UserAdmin templateUserAdminSup1 = new UserAdmin(1, 1, 4, "super1", "password", "myEmail1");
		UserAdmin templateUserAdminReq1 = new UserAdmin(2, 2, 1, "u", "p", "myEmail2");
		UserAdmin templateUserAdminSup2 = new UserAdmin(3, 3, 2, "super2", "password", "myEmail3");
		UserAdmin templateUserAdminReq2 = new UserAdmin(4, 2, 3, "user2", "password", "myEmail4");
		UserAdmin templateUserAdminReq3 = new UserAdmin(5, 1, 3, "user3", "password", "myEmail5");      System.out.println(templateUserAdminReq3);
		userAdmins.put(1, templateUserAdminSup1);
		userAdmins.put(2, templateUserAdminReq1); 
		userAdmins.put(3, templateUserAdminSup2);
		userAdmins.put(4, templateUserAdminReq2);
		userAdmins.put(5, templateUserAdminReq3);
		////////////////////// Request 
//int reqId, int userId, String reqName, String reqType, String reqDesc, String reqJustify,
//		String reqDatetime, String reqPlace, String gradeType, String gradePass, double reqAmt, int reqStage) {
 
		Request empRequest1 = new Request(1, 1, "Oracle", "certification", "Java Oracle Pro-1", "Java proficiency", "1-21-20", "Pitt", "numeric", "80%", 349.99, 1, "superText", "dheadText", "bencoText", "reqText");
		Request empRequest2 = new Request(2, 2, "AWS", "certification", "Assoc Dev", "cloud", "3-20-20", "Morgantown", "numeric", "720", 150.00, 1, "superText", "dheadText", "bencoText", "reqText");
		Request empRequest3 = new Request(3, 3, "MongoWorld", "conference", "Industry News", "no-sql", "2-20-20", "Dallas", "presentation", "present", 750.00, 1, "superText", "dheadText", "bencoText", "reqText");
		 
		System.out.println(empRequest1);
		requests.put(1, empRequest1); 
		requests.put(2, empRequest2); 
		requests.put(3, empRequest3); 
	}
	
}
 