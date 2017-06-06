package testIterator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SqlIinit {
	private static Properties pr = null;
	public static Map<String, String> hKeyValue = new HashMap<String, String>();

	public static void init() {
		
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(
							"D:/Java Project/Java_src/src/testIterator/Sql.properties"));
			pr = new Properties();
			pr.load(br);
			br.close();
			setProperty();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
		
	}

	public static void setProperty(){
		Enumeration<?> names = pr.propertyNames();
		while(names.hasMoreElements()){
			String name = (String) names.nextElement();
			hKeyValue.put(name, pr.getProperty(name));
		}
	}
	
	public static String getSQL(String sqlID){
		String sql = null;
		sql = hKeyValue.get(sqlID);
		if(sql.isEmpty()){
			System.out.println(sqlID + "can not be found!");
		}
		return sql;
	}
}
