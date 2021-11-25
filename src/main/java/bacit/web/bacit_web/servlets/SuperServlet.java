package bacit.web.bacit_web.servlets;

import bacit.web.bacit_web.DAO.UserDAO;
import bacit.web.bacit_web.utilities.DBUtils;

import javax.servlet.http.HttpServlet;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class SuperServlet extends HttpServlet {

    protected final StringBuffer outString = new StringBuffer();

    public String getUserID(String phoneNumber){
        UserDAO dao = new UserDAO();
        return dao.getUserIdFromPhone(phoneNumber);
    }
}
