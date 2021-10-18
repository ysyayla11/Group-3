package bacit.web.bacit_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "GetAllUsersServlet", value = "/GetAllUserServlet")
public class GetAllUsersServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        try {
            ResultSet results;

            results = getAllUsers(out);
            out.println(HtmlModel.getHeader("all users"));
            out.println("<br><div>");
            printForm(results, out);
            out.println("</div>");
            out.println(HtmlModel.getFooter());
        }
        catch (SQLException e){
            out.println(e);
        }
    }

    public ResultSet getAllUsers(PrintWriter out)
            throws SQLException{

        Connection db = null;
        try{
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Error i connection");
        }

        String query = "select * from user";
        PreparedStatement statement = db.prepareStatement(query);
        ResultSet results = statement.executeQuery();
        return results;
    }

    public void printForm(ResultSet results, PrintWriter out){

        try {
            while (results.next()) {
                out.println("<form action='GetUserInfoServlet' method='get'>\n" +
                        "    <div>" + results.getString(2) + "</div>\n" +
                        "    <div>tlf: " + results.getString(4) + "</div>\n" +
                        "    <button type=\"submit\" name='userID' value='" + results.getString(1) + "'>Rediger bruker</button>\n" +
                        "</form>");
            }
        }
        catch (SQLException e){
            out.println(e);
        }
    }
}