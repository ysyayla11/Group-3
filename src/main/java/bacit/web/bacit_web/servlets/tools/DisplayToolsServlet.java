package bacit.web.bacit_web.servlets.tools;

import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.utilities.DBUtils;

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

@WebServlet(name = "DisplayToolsServlet", value = "/SiteUser/DisplayToolsServlet")
public class DisplayToolsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try {
            ResultSet results;
            results = getTools(out);
            out.println(HtmlModel.getHeader("THis is the tools in the system"));
            out.println("<br><div>");
            printForm(results, out);
            out.println("</div>");
            out.println(HtmlModel.getFooter());
        }
        catch (SQLException e) {
            out.println(e);
        }

    }

    public ResultSet getTools(PrintWriter out) throws SQLException {

        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error i connection");
        }
        String query = "select * from MytestDB.tools";
        PreparedStatement statement = db.prepareStatement(query);
        ResultSet results = statement.executeQuery();
        return results;
    }

    public void printForm(ResultSet results, PrintWriter out) {

        try {
            while (results.next()) {
                out.println("<form action='DisplayToolsServlet' method='get'>\n" +
                        "    <div>Tool name: " + results.getString(2) + " </div>\n" +
                        "    <div>Tool condition: " + results.getString(4) + "</div>\n" +
                        "    <div>Tool price: " + results.getString(5) + "</div>\n" +
                        "    <div>Gratis første dag: " + results.getString(7) + "</div>\n" +
                        "    <div>Viktig informasjon: " + results.getString(8) + "</div>\n" +
                        "    <div>Tool picture: " + results.getString(11) + "</div>\n" +
                        "</form>");
            }
        }
        catch (SQLException e) {
            out.println(e);
        }
    }
}
