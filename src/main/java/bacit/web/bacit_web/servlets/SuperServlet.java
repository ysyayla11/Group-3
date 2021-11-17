package bacit.web.bacit_web.servlets;

import bacit.web.bacit_web.utilities.DBUtils;

import javax.servlet.http.HttpServlet;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class SuperServlet extends HttpServlet {
    public Connection connectToDB(){
        Connection db = null;
        try{
            db = DBUtils.getINSTANCE().getConnection();
        }
        catch(ClassNotFoundException| SQLException e){
            e.printStackTrace();
            System.out.println("Error i connection");
        }
        return db;
    }
}
