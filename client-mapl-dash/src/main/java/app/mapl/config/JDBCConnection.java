package app.mapl.config;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
//public static Connection conn = JDBCConnection.getConnection();

public class JDBCConnection {
	@Value("${spring.datasource.driver-class-name}") // dev 		// org.h2.Driver
	private static String DRIVER;// = prod = "oracle.jdbc.driver.OracleDriver";
//	jdbc:h2:mem:test;NON_KEYWORDS=VALUE,PASSWORD;

	@Value("${spring.datasource.url}") // ${"jdbc:oracle:thin:@localhost:1521:xe"})
	private static  String URL;// = "jdbc:oracle:thin:@thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com:1521:thomas";

	@Value("${spring.datasource.username}")
	private static  String USERNAME;// =

	@Value("${spring.datasource.password}")
	private static  String PASSWORD;//

	public static Connection conn = null; // connect to singleton design pattern
	public static Connection getConnection() {
		try {
			System.out.println(Class.forName(DRIVER)+DRIVER+"...${DRIVER} JDBC Driver connected.");
		} catch (ClassNotFoundException e) {
			System.out.println("oops, Driver not found :-O");
			e.printStackTrace();
		}
		if(conn == null) {
			String endpoint = URL;
			String username = USERNAME;
			String password = (PASSWORD!=null) ? PASSWORD :  getJDBCKey();//
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
			if (entry.getKey().equals("8i")) {
				return entry.getValue();
			}
		}
		return null;
	}

}
