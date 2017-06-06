package testIterator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Date;

import testIterator.ConnQueryDB;

public class IteratorTest {

	public static void main(String[] args){
		SqlIinit.init();

		Map<String, String> map = SqlIinit.hKeyValue;

		Iterator<Entry<String, String>> map_data = map.entrySet().iterator();
		PrintStream out = System.out;
		PrintStream ps = null;
		try {
			FileOutputStream fos = new FileOutputStream(
					"D:/Java Project/Java_src/src/testIterator/sql.txt", true);
			ps = new PrintStream(fos);
		} catch (IOException e) {
			e.getStackTrace();
			e.printStackTrace();
		}
		if (ps != null) {
			System.setOut(ps);
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(df.format(new Date()));
		// 通过Map.entrySet使用iterator遍历key和value
		while (map_data.hasNext()) {
			Entry<String, String> entry = map_data.next();
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			if(entry.getKey().contains(args[0])){
				String sql = SqlIinit.getSQL(args[0]);
				System.out.println("I want to execute the sql: "+sql);
				
				ArrayList<BaseBean> datalist = ConnQueryDB.dbResultSet(sql);
				for(BaseBean bean:datalist){
					System.out.println("ID="+bean.getId()+" NAME="+bean.getName()+" URL="+bean.getURL());
				}
			}
		}
		
		ps.flush();
		ps.close();
		System.setOut(out);
		System.out.println("The programme ended normally!");
	}

}
