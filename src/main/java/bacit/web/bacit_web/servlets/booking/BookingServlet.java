package bacit.web.bacit_web.servlets.booking;

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
import java.sql.SQLException;



// Denne servleten skal gjøre det mulig å lage en ny booking
/*
* - create new booking in database
 - check if tool is available
 - check condition
 - check qualification
*
* */
@WebServlet(name = "BookingServlet", value ="/SiteUser/BookingServlet")
public class BookingServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String tool_id = request.getParameter("Tool_id");
        String user_id = request.getParameter("User_id");
        String booking_dateStart = request.getParameter("Booking_dateStart");
        String booking_dateEnd = request.getParameter("Booking_dateEnd");
        Boolean booking_paid = false;
        if (request.getParameter("Booking_paid").equals("true")) {
            booking_paid = true;
        }

        try {
            addBooking(out, tool_id, user_id, booking_dateStart, booking_dateEnd, booking_paid);
        } catch (SQLException e) {
            out.println(e);
        }

        out.println("Din bestilling var vellykket!" +
                "<a href=\"home.jsp\"><button type=\"button\">Gå tilbake til hjem</button></a> " +
                "");
    }

    public void addBooking(PrintWriter out, String tool_id, String user_id, String booking_dateStart, String booking_dateEnd, Boolean booking_paid) throws SQLException {
        Connection db = null;

        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            out.println(e);
        }
        String query = "insert into booking(Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid) VALUES(Booking_id, ?, ?, ?, ?, ?);";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, tool_id);
        statement.setString(2, user_id);
        statement.setString(3, booking_dateStart);
        statement.setString(4, booking_dateEnd);
        statement.setBoolean(5, booking_paid);
        statement.executeQuery();
    }




}
