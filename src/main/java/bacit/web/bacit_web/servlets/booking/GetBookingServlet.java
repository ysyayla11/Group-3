package bacit.web.bacit_web.servlets.booking;

import bacit.web.bacit_web.DAO.BookingDAO;
import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.models.BookingModel;
import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.servlets.SuperServlet;
import jdk.jpackage.internal.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

@WebServlet(name = "GetBookingServlet", value = "/SiteUser/GetBookingServlet")
public class GetBookingServlet extends SuperServlet{

    private Logger logger = Logger.getLogger(String.valueOf(GetBookingServlet.class));
    private StringBuffer outString = new StringBuffer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userPhone = request.getUserPrincipal().getName();
        response.setContentType("text/html");
        outString.delete(0, outString.length());

        try {
            outString.append(HtmlModel.getHeader("Bookings"));
            printBookingList(getBookings(userPhone));
            outString.append(HtmlModel.getFooter());
            out.println(outString);
        }
        catch (SQLException e){
            logger.info(e.getMessage());
        }
    }

    private ArrayList<BookingModel> getBookings(String userPhone) throws SQLException {

        BookingDAO dao = new BookingDAO();

        ArrayList<BookingModel> bookings = dao.getBookingsFromPhoneNumber(userPhone);

        return bookings;
    }

    private void printBookingList(ArrayList<BookingModel> bookings) throws SQLException{
        outString.append("<ul>");
        for(int i = 0; i<bookings.size(); i++){
            outString.append("<li>\n" +
                    "        <div>" + getToolName(Integer.toString(bookings.get(i).getTool_id())) + "</div>\n" +
                    "        <div>" + bookings.get(i).getBooking_dateStart() + "</div>\n" +
                    "        <div>" + bookings.get(i).getBooking_dateEnd() +  "</div>\n" +
                    "        <div>" + bookings.get(i).getPaid() +  "</div>\n" +
                    "    </li>");
        }


        outString.append("</ul>");
    }

    private String getToolName(String tool_id){
        ToolDAO dao = new ToolDAO();

        return dao.getToolName(tool_id);
    }
}
