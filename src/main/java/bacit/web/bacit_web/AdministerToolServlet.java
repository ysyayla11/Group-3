package bacit.web.bacit_web;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;


public class AdministerToolServlet {
    private void getTool(String Tool_id, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        System.out.println(Tool_id);
    }

}
