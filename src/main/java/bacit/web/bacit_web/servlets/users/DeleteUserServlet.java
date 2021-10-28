package bacit.web.bacit_web.servlets.users;

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

@WebServlet(name = "DeleteUserServlet", value="/SiteAdmin/DeleteUserServlet")
public class DeleteUserServlet extends SuperServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String user_id = request.getParameter("userID");
        int user_idInt = Integer.parseInt(user_id);
        try{
            deleteUser(user_idInt, out);
            response.sendRedirect("/bacit-web-1.0-SNAPSHOT/SiteAdmin/GetAllUserServlet");
        }
        catch (SQLException e){
            out.println(e);
        }

    }

    private void deleteUser(int userId, PrintWriter out) throws SQLException {

        Connection db = super.connectToDB(out);

        String query = "delete from user where User_id = ?";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, userId);
        statement.executeQuery();
    }

    private void printResponse(PrintWriter out){
        out.println("user deleted");
    }


}
