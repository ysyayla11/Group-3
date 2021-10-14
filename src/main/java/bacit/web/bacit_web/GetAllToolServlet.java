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

@WebServlet(name = "GetToolServlet", value = "/getToolServlet")

public class GetAllToolServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            ResultSet results;

            results = getTool(out);
            out.println(HtmlModel.getHeader("all tools"));
            out.println("<br><div>");
            printForm(results, out);
            out.println("</div>");
            out.println(HtmlModel.getFooter());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private ResultSet getTool(PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query3 = "select * from tools";

        PreparedStatement statement = db.prepareStatement(query3);
        ResultSet rs = statement.executeQuery();
        return rs;


    }

    public void printForm(ResultSet results, PrintWriter out){

        try {
            while (results.next()) {
                out.println("<form action='GetUserInfoServlet' method='get'>\n" +
                        "    <div>" + results.getString(2) + "</div>\n" +
                        "    <div>type: " + results.getString(3) + "</div>\n" +
                        "    <button type=\"submit\" name='userID' value='" + results.getString(1) + "'>Rediger bruker</button>\n" +
                        "</form>");
            }
        }
        catch (SQLException e){
            out.println(e);
        }


    }

}