package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class AdminOperations {
    public int operations(String name){
        HashMap<String,Integer> operations = new HashMap<>();

        operations.put("Average Duration", 1);
        operations.put("Students Collected certifactes", 2);
        operations.put("students 2 installments paid", 3);
        operations.put("students 1 installment paid", 4);

        Connection conn = null;
        Statement st= null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishnu","vishnu");
            st = conn.createStatement();
            String sql = "";
//            System.out.println(""+operations.get(name));
            if(operations.get(name) == 1){
                sql = "select avg(dur) from coursedetails";

            }
            else if(operations.get(name) == 2){
                sql = "select count(cercollected) from certificates where cercollected = 'y'";
            }else if(operations.get(name) == 3){
                sql ="select count(second_ins) from  coursejoining  where second_ins = 'Y'";
            }
            else {
                sql ="select count(first_ins) from  coursejoining  where first_ins = 'Y'";
            }
//            System.out.println(sql);
            rs = st.executeQuery(sql);
            rs.next();
            return  rs.getInt(1);
            }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        AdminOperations ao = new AdminOperations();
        System.out.println(ao.operations("students 1 installment paid"));
    }
}
