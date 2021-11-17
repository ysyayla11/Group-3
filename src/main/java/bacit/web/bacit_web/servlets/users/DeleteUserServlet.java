package bacit.web.bacit_web.servlets.users;

import bacit.web.bacit_web.DAO.UserDAO;
import bacit.web.bacit_web.servlets.SuperServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@WebServlet(name = "DeleteUserServlet", value="/SiteAdmin/DeleteUserServlet")
public class DeleteUserServlet extends SuperServlet {

    Logger logger = Logger.getLogger(String.valueOf(DeleteUserServlet.class));
    StringBuffer outString = new StringBuffer();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        outString.delete(0, outString.length());
        String user_id = request.getParameter("userID");
        int user_idInt = Integer.parseInt(user_id);

        try{
            deleteUser(user_idInt);
            response.sendRedirect("/bacit-web-1.0-SNAPSHOT/SiteAdmin/GetAllUserServlet");
        }
        catch (SQLException e){
            logger.info(e.getMessage());
        }

    }

    private void deleteUser(int userID) throws SQLException {
        UserDAO dao = new UserDAO();

        dao.deleteUser(userID);
    }


}
