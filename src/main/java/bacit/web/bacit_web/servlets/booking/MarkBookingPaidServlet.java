package bacit.web.bacit_web.servlets.booking;

import bacit.web.bacit_web.models.BookingModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(name = "MarkBookingPaidServlet", value = "/SiteUser/markBookingPaidServlet")
public class MarkBookingPaidServlet extends BookingSuperServlet {

    Logger logger = Logger.getLogger(String.valueOf(MarkBookingPaidServlet.class));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String booking_id = request.getParameter("booking_id");
        BookingModel booking = getBooking(booking_id);
        int currentUserId = Integer.parseInt(getUserID(request.getUserPrincipal().getName()));
        int bookingOwner = booking.getUser_id();
        int bookingPrice = calculateDebt(booking);
        bookingPrice *= -1;

        logger.info("current " + currentUserId + ", booking: " + bookingOwner + ", " + bookingPrice);
        if (currentUserId == bookingOwner && !booking.getPaid()) {
            setAsDelivered(booking_id);
            updateDebt(bookingPrice, Integer.toString(currentUserId));
            out.println("Du har nå betalt din booking");
        }
        else if(currentUserId == bookingOwner && booking.getPaid()){
            out.println("Denne bookingen er allerede betalt");
        }
        else {
            out.println("dette er ikke din booking");
        }
    }
}
