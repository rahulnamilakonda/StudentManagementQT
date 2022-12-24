package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DownloadCertificate {
    public void certificateDownload(int sid, int cid) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "vishnu", "vishnu");
            System.out.println("conn==" + conn);
            st = conn.createStatement();
            String sql = "update certificates set cercollected = 'Y' where sid =" + sid + " and cid = " + cid;
            st.execute(sql);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
