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

@WebServlet(name = "GetAllToolServlet", value = "/GetAllToolServlet")
public class GetAllToolServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        try {
            ResultSet results;

            results = getAllTool(out);
            out.println(HtmlModel.getHeader("all tools"));
            out.println("<br><div>");
            printForm(results, out);
            out.println("</div>");
            out.println(HtmlModel.getFooter());
        }
        catch (SQLException e){
            out.println(e);
        }
    }

    public ResultSet getAllTool(PrintWriter out)
            throws SQLException{

        Connection db = null;
        try{
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error i connection");
        }

        String query = "select * from tools";
        PreparedStatement statement = db.prepareStatement(query);
        ResultSet results = statement.executeQuery();
        return results;
    }

    public void printForm(ResultSet results, PrintWriter out){

        try {
            while (results.next()) {
                out.println("<form action='GetToolInfoServlet' method='get'>\n" +
                        "    <div>" + results.getString(2) + "</div>\n" +
                        "    <div>type: " + results.getString(3) + "</div>\n" +
                        "    <button type=\"submit\" name='userID' value='" + results.getString(1) + "'>Rediger verktøy</button>\n" +
                        "</form>");
            }
        }
        catch (SQLException e){
            out.println(e);
        }
    }
}