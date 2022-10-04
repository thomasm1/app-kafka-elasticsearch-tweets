package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCConnectionOld {

	public static Connection conn = null; // connect to singleton design pattern
	
	public static Connection getConnection() {
		 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			System.out.println("...Logging by Log4j2.\n");
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");
		} catch (ClassNotFoundException e) {
			System.out.println("oops, Driver not found :-O");
		}
		
		
		if(conn == null) {
			
			
			String value = "";							// endpoint:port:SID
			try {
				String fileBower = "C:/w/www/git/java-cli/bower/bowertext.txt";
				File textFile = new File(fileBower);
				Scanner scanText = new Scanner(textFile);
				value = scanText.nextLine(); 
				System.out.println("\n  ....Accessing AWS RDS endpoint\n");
				scanText.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			};
			String username = "thomas";
			String password = value;
			String endpoint = "jdbc:oracle:thin:@thomas.cs8ihlmwvzfx.us-east-1.rds.amazonaws.com:1521:thomas";
			String driver = "oracle.jdbc.driver.OracleDriver";

		
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

	public static void main(String[] args) { 
		Connection conn1 = getConnection();
		Connection conn2 = getConnection();
		Connection conn3 = getConnection();
		Connection conn4 = getConnection();
		
		
		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);
		System.out.println(conn4);
	}

}
