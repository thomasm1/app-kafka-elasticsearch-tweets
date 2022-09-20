package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class JDBCConnection {

	public static Connection conn = null; // connect to singleton design pattern
	
	public static Connection getConnection() {
		
		if(conn == null) { 
			String endpoint = "jdbc:oracle:thin:@thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com:1521:thomas";
			
			String secureValue = getJDBCKey();//  
//			String secureValue = "";							// endpoint:port:SID
//			try {
//				String fileBower = "C:/w/www/git/java-dev/bower/bowertext.txt";
//				File textFile = new File(fileBower);
//				Scanner scanText = new Scanner(textFile);
//				secureValue = scanText.nextLine(); 
//				System.out.println("\n  ....Accessing AWS RDS endpoint\n");
//				scanText.close();
//			} catch (FileNotFoundException e1) {
//				e1.printStackTrace();
//			};
			
			String password = secureValue; 
			String username = "thomas";

			try {
				conn = DriverManager.getConnection(endpoint, username, password);
				return conn;
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		} else {
			return conn;
		}
		return null;
	}

	public static String getJDBCKey() {
		Map<String, String> env = System.getenv();
		for (Map.Entry<String, String> entry : env.entrySet()) {
			if (entry.getKey().equals("ORACLE_DB_PASSWORD")) {
 
				return entry.getValue();
			}
		}
		return null;
	}

//	public static void main(String[] args) { 
//		Connection conn1 = getConnection();
//		Connection conn2 = getConnection();
//		Connection conn3 = getConnection();
//		Connection conn4 = getConnection();
//		
//		
//		System.out.println(conn1);
//		System.out.println(conn2);
//		System.out.println(conn4);
//	}

}
