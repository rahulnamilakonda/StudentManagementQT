package Database;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class JavaJoined {

		// TODO Auto-generated method stub
		//ArrayList<CourseDetails> courses = new ArrayList<>();
		ArrayList<String> courses = new ArrayList<>();
		public void getCourseJoinedNames(String cname) {
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			FileWriter fw = null;
			HashMap<String,Integer> coursesNames = new HashMap<>();
			coursesNames.put("JAVA", 1);
			coursesNames.put("PYTHON", 2);
			coursesNames.put("HTML", 3);
			coursesNames.put("JAVA FULL STACK", 4);
			coursesNames.put("PYTHON FULL STACK", 5);
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishnu","vishnu");
				st = conn.createStatement();
//				String sql = "select name from students where id in (select unique(sid) from coursejoining where cid=5)";
				String sql = "select name from students where id in (select unique(sid) from coursejoining where cid="+coursesNames.get(cname)+")";
				rs = st.executeQuery(sql);
				File f = new File("D:\\my java\\QT\\QT_PROJECT\\javaCourse.txt");
				if(!f.exists()) {
					f.createNewFile();
				}
				while(rs.next()) {
					
					courses.add(rs.getString("name")); 
						
					}
					
			fw = new FileWriter(f);
			fw.write("The students enrolled for "+cname+" "+System.lineSeparator());
			for(String name : courses) {
				fw.write(name+System.lineSeparator());
			}
			System.out.println("The names are copied into javaCourse.txt file....!");
			}catch(Exception e) {
				e.printStackTrace();
			} 
			

			finally {
				try {
					fw.close();rs.close(); st.close(); conn.close();
				}catch(Exception e) {}
			}
			
			
		}
		
			

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			JavaJoined jd = new JavaJoined();
			jd.getCourseJoinedNames("PYTHON");
			
			
		}

	
}


