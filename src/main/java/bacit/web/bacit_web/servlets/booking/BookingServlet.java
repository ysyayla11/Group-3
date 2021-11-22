package bacit.web.bacit_web.servlets.booking;

import bacit.web.bacit_web.DAO.BookingDAO;
import bacit.web.bacit_web.DAO.QualificationDAO;
import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.DAO.UserDAO;
import bacit.web.bacit_web.models.BookingModel;
import bacit.web.bacit_web.models.ToolModel;
import bacit.web.bacit_web.servlets.SuperServlet;
import bacit.web.bacit_web.utilities.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;


// Denne servleten skal gjøre det mulig å lage en ny booking
/*
* - create new booking in database
 - check if tool is available
 - check condition
 - check qualification
*
* */
@WebServlet(name = "BookingServlet", value ="/SiteUser/BookingServlet")
public class BookingServlet extends SuperServlet {

    private Logger logger = Logger.getLogger(String.valueOf(BookingServlet.class));
    private StringBuffer outString = new StringBuffer();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        outString.delete(0, outString.length());

        String tool_id = request.getParameter("Tool_id");
        String user_id = request.getParameter("User_id");
        String booking_dateStart = request.getParameter("Booking_dateStart");
        String booking_dateEnd = request.getParameter("Booking_dateEnd");

        boolean booking_paid = false;
        if (request.getParameter("Booking_paid").equals("true")) {
            booking_paid = true;
        }

        BookingModel booking = new BookingModel(0, Integer.parseInt(tool_id), Integer.parseInt(user_id), booking_dateStart, booking_dateEnd, booking_paid, null);
        int bookingPrice = calculateBookingPrice(booking);
        logger.info(Integer.toString(bookingPrice));

        if(checkQualified(tool_id, user_id)){
            if(addBooking(booking) && updateDebt(user_id, bookingPrice)){
                outString.append("booking vellykket");
            }
            else {
                outString.append("det skjedde noe feil under bookingen, vennligst prøv igjen");
            }
        }
        else{
            outString.append("du er ikke kvalifisert til å booke dette verktøyet");
        }

        out.println(outString);

    }

    private boolean checkQualified(String tool_id, String user_id){

        QualificationDAO dao = new QualificationDAO();

        if (dao.needsQualification(tool_id)){
            return dao.isQualified(user_id, tool_id);
        }
        return true;
    }

    private boolean addBooking(BookingModel booking){
        BookingDAO dao = new BookingDAO();
        return dao.addBooking(booking);

    }

    private boolean updateDebt(String user_id, int amount){
        UserDAO dao = new UserDAO();
        return dao.updateUserDebt(user_id, amount);
    }

    private int calculateBookingPrice(BookingModel booking){
        LocalDate startDate = LocalDate.parse(booking.getBooking_dateStart().substring(0, 10));
        LocalDate endDate = LocalDate.parse(booking.getBooking_dateEnd().substring(0, 10));

        int daysBetween = Period.between(startDate, endDate).getDays() + 1;
        ToolDAO dao = new ToolDAO();
        ToolModel tool = dao.getToolById(Integer.toString(booking.getTool_id()));
        int price = tool.getPrice();
        int freeFirstDay = tool.getFreeFirstDay();

        int debt = daysBetween * price;

        if(freeFirstDay == 1){
            debt-=(price);
        }

        //for testing TBR
        logger.info(
                "startDato = " + startDate + "\n" +
                "endDato = " + endDate + "\n" +
                "freeFirstDay " + freeFirstDay +"\n" +
                "pris per dag " + price + "\n" +
                "daysBetween " + daysBetween + "\n" +
                "pris: " + debt);

        return debt;
    }

}
