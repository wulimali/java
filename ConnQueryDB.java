package testIterator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnQueryDB {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://192.168.99.100:3307/test_docker?"
			+ "useUnicode=true&characterEncoding=UTF-8&useSSL=false";

	static final String USER = "root";
	static final String PASSWORD = "123456";

	public static ArrayList<BaseBean> dbResultSet(String str){
		Connection conn = null;
		Statement stmt = null;
		ArrayList<BaseBean> datalist = new ArrayList<BaseBean>();
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting DB...");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			while (rs.next()) {
				BaseBean bbean = new BaseBean();
				bbean.setProperties(rs);
				datalist.add(bbean);
			}
			return datalist;
		}catch (SQLException se) {
			// handle JDBC exception
			se.printStackTrace();
		} catch (Exception e) {
			// handle Class exception
			e.getStackTrace();
			e.printStackTrace();
		} finally {
			// close the resource
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {

			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return null;
	}
}
