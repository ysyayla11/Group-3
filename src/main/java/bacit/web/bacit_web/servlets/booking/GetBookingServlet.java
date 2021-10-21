package bacit.web.bacit_web.servlets.booking;

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

@WebServlet(name = "GetBookingServlet", value = "/GetBookingServlet")
public class GetBookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        try {
            ResultSet results;

            results = getBooking(out);
            out.println(HtmlModel.getHeader("All bookings"));
            out.println("<br><div>");
            printForm(results, out);
            out.println("</div>");
            out.println(HtmlModel.getFooter());
        }
        catch (SQLException e) {
            out.println(e);
        }


    }

    public ResultSet getBooking(PrintWriter out) throws SQLException {

        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error i connection");
        }
        String query = "select * from MytestDB.booking";
        PreparedStatement statement = db.prepareStatement(query);
        ResultSet results = statement.executeQuery();
        return results;
    }

    public void printForm(ResultSet results, PrintWriter out){

        try {
            while (results.next()) {
                out.println("<form action='GetBookingServlet' method='get'>\n" +
                        "    <div>Booking id: " + results.getString(1) + " </div>\n" +
                        "    <div>User id: " + results.getString(2) + "</div>\n" +
                        "    <div>Tool id: " + results.getString(3) + "</div>\n" +
                        "    <div>Booking Start: " + results.getString(4) + "</div>\n" +
                        "    <div>Booking End: " + results.getString(5) + "</div>\n" +
                        "    <div>Booking paid: " + results.getString(6) + "</div>\n" +
                        "</form>");
            }
        }
        catch (SQLException e){
            out.println(e);
        }

    }
}
