package bacit.web.bacit_web.servlets.booking;

import bacit.web.bacit_web.DAO.BookingDAO;
import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.models.BookingModel;
import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

@WebServlet(name = "GetBookingsServlet", value = "/SiteUser/GetBookingsServlet")
public class GetBookingServlets extends BookingSuperServlet {

    private final Logger logger = Logger.getLogger(String.valueOf(GetBookingServlets.class));
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userPhone = request.getUserPrincipal().getName();
        response.setContentType("text/html");
        outString.delete(0, outString.length());

        ArrayList<BookingModel> bookings = getBookings(userPhone);
        UserModel bookingOwner = getUser(userPhone);

        addHtml(bookings, bookingOwner);
        out.println(outString);
    }

    private ArrayList<BookingModel> getBookings(String userPhone) {

        BookingDAO dao = new BookingDAO();

        return dao.getBookingsFromPhoneNumber(userPhone);
    }

    private void addHtml(ArrayList<BookingModel> bookings, UserModel bookingOwner){
        outString.append(HtmlModel.getHeader("Bookings"));
        addBookingInterface(bookings, bookingOwner);
        if(bookings.size() != 0) {
            addBookingList(bookings);
        }
        else{
            outString.append("<b>Du har ingen bookinger</b>");
        }
        outString.append(HtmlModel.getFooter());
    }

    private void addBookingInterface(ArrayList<BookingModel> bookings, UserModel bookingOwner){

        int unpaidBookings = getNumberOfUnpaidBookings(Integer.toString(bookingOwner.getId()));

        outString.append("<div id=\"bookingInterface\">\n" +
                "    <div>Du skylder: "+ bookingOwner.getDebt() +" kroner</div>\n" +
                "    <div>Du har: "+  unpaidBookings + " ubetalte bookinger</div>\n");
        if(unpaidBookings != 0) {
            outString.append("    <a href= \"markAllBookingsAsPAidServlet\"><button>betal alle ubetalt bookinger</button></a>\n");
        }
        outString.append("\n" +
                "    <br><b>Dine bookinger:</b><br>\n" +
                "    <label>Sorter etter</label>\n" +
                "    <select id=\"sortSelect\">\n" +
                "        <option selected>Ubetalte</option>\n" +
                "        <option>Ulevert</option>\n" +
                "        <option>Kommende</option>\n" +
                "        <option>Alle</option>\n" +
                "    </select>\n" +
                "</div>");
    }

    private void addBookingList(ArrayList<BookingModel> bookings){
        outString.append("<ul>");
        for(int i = 0; i<bookings.size(); i++){
            outString.append("<li class = \"bookingLi\" style=\"\">\n" +
                    "        <br><div><b>" + getToolName(Integer.toString(bookings.get(i).getTool_id())) + "</b></div><br>\n" +
                    "        <div> Start: " + bookings.get(i).getBooking_dateStart().substring(0, 10) + "</div>\n" +
                    "        <div> Slutt: " + bookings.get(i).getBooking_dateEnd().substring(0, 10) +  "</div>\n" +
                    "        <br><div>" + addPaymentButton(bookings.get(i)) +  "</div>\n" +
                    "        <div>" + addReportButton() + "</div>\n" +
                    "        <div>" + addDeliverButton(bookings.get(i)) + "</div>\n" +
                    "    </li><br>");
        }

        outString.append("</ul>");
    }

    private String addPaymentButton(BookingModel booking){

        if(booking.getPaid()){
            return "Denne bookingen er betalt";
        }
        else{
            return "Du skylder " + calculateDebt(booking) + " kr for denne bookingen <br><a href=\"markBookingPaidServlet?booking_id=" + booking.getBooking_id() + "\"><button class=\"paymentButton\">Betal nå med vipps</button></a>";
        }
    }

    private String addReportButton(){
        return "<button>Rapporter skade</button>";
    }

    private String addDeliverButton(BookingModel booking){

        String returnString = null;
        if(booking.getBooking_dateDelivered()!=null){
            returnString = "Du leverte dette verktøyet: " + booking.getBooking_dateDelivered().substring(0, 10);
        }
        else {
            returnString = "<a href=\"markToolDeliveredServlet?booking_id=" + booking.getBooking_id() + "&tool_id=" + booking.getTool_id() +"\"><button>Marker som levert</button></a>";
        }
        return returnString;
    }

    private String getToolName(String tool_id){
        ToolDAO dao = new ToolDAO();
        return dao.getToolName(tool_id);
    }

    private int getNumberOfUnpaidBookings(String userID){
        BookingDAO dao = new BookingDAO();
        return dao.getNumberOfUnpaidBookings(userID);
    }
}
