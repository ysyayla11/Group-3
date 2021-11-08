package bacit.web.bacit_web.servlets.booking;

import bacit.web.bacit_web.models.HtmlModel;
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

@WebServlet(name = "GetBookingServlet", value = "/SiteUser/GetBookingServlet")
public class GetBookingServlet extends SuperServlet{

    StringBuffer outStr = new StringBuffer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userPhone = request.getUserPrincipal().getName();
        response.setContentType("text/html");

        try {
            outStr.append(HtmlModel.getHeader("Bookings"));
            printBookingList(getBookings(out, userPhone));
            outStr.append(HtmlModel.getFooter());
            out.println(outStr);
        }
        catch (SQLException e){
            out.println(e);
        }
    }

    private ResultSet getBookings(PrintWriter out, String userPhone) throws SQLException {
        Connection db = super.connectToDB(out);

        String query = "select * from booking inner join user u on booking.User_id = u.User_id where u.User_phoneNumber = ? and Booking_paid is false";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, userPhone);
        ResultSet results = statement.executeQuery();

        return results;
    }

    private void printBookingList(ResultSet results) throws SQLException{
        outStr.append("<li>");
        while (results.next()){
            outStr.append("<li>\n" +
                    "        <div>" + results.getString(2) + "</div>\n" +
                    "        <div>" + results.getString(3) + "</div>\n" +
                    "        <div>" + results.getString(4) + "</div>\n" +
                    "        <div>" + results.getString(5) + "</div>\n" +
                    "        <div>" + results.getString(6) + "</div>\n" +
                    "    </li>");
        }
        outStr.append("</li>");
    }
}
