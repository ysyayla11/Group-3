//general class for other servlets to extend

package bacit.web.bacit_web.servlets;

import bacit.web.bacit_web.utilities.DBUtils;

import javax.servlet.http.HttpServlet;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class SuperServlet extends HttpServlet {
    public Connection ConnectToDB(PrintWriter out){
        Connection db = null;

        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException|SQLException e) {
            out.println(e);
        }
        return db;
    }
}
