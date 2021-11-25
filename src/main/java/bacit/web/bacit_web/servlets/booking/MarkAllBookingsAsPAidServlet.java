package bacit.web.bacit_web.servlets.booking;

import bacit.web.bacit_web.DAO.BookingDAO;
import bacit.web.bacit_web.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(name = "MarkAllBookingsAsPAidServlet", value = "/SiteUser/markAllBookingsAsPAidServlet")
public class MarkAllBookingsAsPAidServlet extends BookingSuperServlet {

    private final Logger logger = Logger.getLogger(String.valueOf(GetBookingServlets.class));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String currentUserId = getUserID(request.getUserPrincipal().getName());

        if (payAllBookings(currentUserId)){
            updateDebt(getUserDebt(currentUserId)*-1, currentUserId);
            outString.append("alle bookingene dine er nå betalt");
        }
        else{
            outString.append("noe feil har skjedd, vennligst prøv igjen senere");
        }

        out.println(outString);
    }

    private boolean payAllBookings(String userID){
        BookingDAO dao = new BookingDAO();
        return dao.payAllBookings(userID);
    }

    private int getUserDebt(String user_id){
        UserDAO dao = new UserDAO();

        return dao.getUserDebt(user_id);
    }

}
