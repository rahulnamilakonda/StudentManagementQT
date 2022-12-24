package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class RegisterCourse {

	public void enrollCourse(int id,String name)
	{	
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		
		
	
		HashMap<String,Integer> courses = new HashMap<>();
		courses.put("JAVA", 1);
		courses.put("PYTHON", 2);
		courses.put("HTML", 3);
		courses.put("JAVA FULL STACK", 4);
		courses.put("PYTHON FULL STACK", 5);
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishnu","vishnu");
			st = conn.createStatement();
			Date date = new Date();
		    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
			String sysdate = formatter.format(date);
			String sql = "insert into CourseJoining values("+id+","+courses.get(name)+",to_date('"+sysdate+"','dd-mm-yy'),'N','N')";
			System.out.println(sql);
			st.executeQuery(sql);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}


}


