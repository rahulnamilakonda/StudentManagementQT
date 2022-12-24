package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Certificate {
   public void IstInstallment(int sid,int cid) {

	   Connection conn = null;
	   Statement st= null;
	   ResultSet rs = null;

	   try {
		   Class.forName("oracle.jdbc.OracleDriver");
		   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishnu","vishnu");
		   System.out.println("conn=="+conn);
		   st = conn.createStatement();
		   String sql = "update coursejoining set first_ins = 'Y' where sid = "+sid+" and cid = "+cid;
		   System.out.println(sql);
		   st.execute(sql);
		   conn.commit();
		   System.out.println(sql);
		   System.out.println("updated..");


	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   public void IIndInstallment(int sid, int cid) {
	   	Connection conn = null;
		Statement st= null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishnu","vishnu");
			st = conn.createStatement();
			String sql = "update coursejoining set second_ins = 'Y' where sid = "+sid+" and cid = "+cid;
			//String sql = "insert into students values("+id+",'"+name+"'"+","+contact+",'"+address+"'"+","+age+")";
			st.execute(sql);
			conn.commit();
			System.out.println(sql);
			
}catch(Exception e) {
	e.printStackTrace();
}




	
}

}