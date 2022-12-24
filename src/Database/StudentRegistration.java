package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.LinkedList;

public class StudentRegistration {
	public int createStudent(String name,long contact,String address,int age) {
		
		Connection conn = null;
		Statement st= null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishnu","vishnu");
			st = conn.createStatement();
			String sql = "select  max(id) id from students";
			rs = st.executeQuery(sql);
			rs.next();
			int id;
			if(rs.getInt("id") == 0) {
				id = 101;
			}
			else
			{
				id = rs.getInt("id") + 1;
			}
			sql = "insert into students values("+id+",'"+name+"'"+","+contact+",'"+address+"'"+","+age+")";

			rs = st.executeQuery(sql);
			return id;

		}catch(Exception e) {
			e.printStackTrace();
		}
	return 0;
}


	ArrayList<StudentBean> readStudent() {
		ArrayList<StudentBean> students = new ArrayList<>();
		Connection conn = null;
		Statement st= null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishnu","vishnu");
			st = conn.createStatement();
			String sql = "select * from students";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				StudentBean sb = new StudentBean(); 
				sb.setId(rs.getInt("id"));
				sb.setName(rs.getString("name"));
				sb.setContact(rs.getLong("contact"));
				sb.setAddress(rs.getString("address"));
				sb.setAge(rs.getInt("age"));
				students.add(sb);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return students;
	}



}
