package bacit.web.bacit_web.DAO;

import bacit.web.bacit_web.models.BookingModel;
import bacit.web.bacit_web.models.ToolModel;
import bacit.web.bacit_web.utilities.DBUtils;

import java.awt.print.Book;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class BookingDAO {

    private Logger logger = Logger.getLogger(String.valueOf(BookingDAO.class));

    public ArrayList<BookingModel> getBookingsFromPhoneNumber(String userPhone) {

        ArrayList<BookingModel> bookings = null;
        ResultSet results = null;
        Connection db = null;
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "select Booking_id, Tool_id, booking.User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered  from booking inner join user u on booking.User_id = u.User_id where u.User_phoneNumber = ?";
            statement = db.prepareStatement(query);
            statement.setString(1, userPhone);
            results = statement.executeQuery();
            bookings = resultSetToBookingModelArrayList(results);
        }
        catch (ClassNotFoundException | SQLException e) {
            logger.info("getBookingsFromPhoneNumber" + e.getMessage());
        }
        finally {
            closeConnections(db, results, statement);
        }
        return bookings;
    }

    public ArrayList<BookingModel> getBookingDatesFromToolID(String toolID) {
        ArrayList<BookingModel> bookings = null;

        try {
            Connection db = DBUtils.getINSTANCE().getConnection();
            String query = "select * from booking where tool_id = ? and Booking_dateStart;";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, toolID);
            ResultSet results = statement.executeQuery();
            bookings = resultSetToBookingModelArrayList(results);
            statement.executeQuery();
            db.close();
            statement.close();
            results.close();
            return bookings;
        }
        catch (ClassNotFoundException | SQLException e) {
            logger.info("getBookingsFromPhoneNumber" + e.getMessage());
        }
        return null;
    }

    public boolean addBooking(BookingModel booking){
        try {
            Connection db = DBUtils.getINSTANCE().getConnection();

            String query = "insert into booking(Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered) VALUES(Booking_id, ?, ?, ?, ?, ?, null);";
            PreparedStatement statement = db.prepareStatement(query);

            statement.setInt(1, booking.getTool_id());
            statement.setInt(2, booking.getUser_id());
            statement.setString(3, booking.getBooking_dateStart());
            statement.setString(4, booking.getBooking_dateEnd());
            statement.setBoolean(5, booking.getPaid());

            statement.executeQuery();
            db.close();
            statement.close();
            return true;
        }
        catch (ClassNotFoundException | SQLException e){
            logger.info("addBooking " + e.getMessage());
        }
        return false;
    }

    private ArrayList<BookingModel> resultSetToBookingModelArrayList(ResultSet results){
        int booking_id = 0;
        int tool_id = 0;
        int user_id = 0;
        String booking_dateStart = null;
        String booking_dateEnd;
        boolean paid = false;
        String booking_dateDelivered = null;

        ArrayList<BookingModel> bookings = new ArrayList<>();

        try {
            while (results.next()) {
                booking_id = results.getInt(1);
                tool_id = results.getInt(2);
                user_id = results.getInt(3);
                booking_dateStart = results.getString(4);
                booking_dateEnd = results.getString(5);
                paid = results.getBoolean(6);
                booking_dateDelivered = results.getString(7);
                BookingModel booking = new BookingModel(booking_id, tool_id, user_id, booking_dateStart, booking_dateEnd, paid, booking_dateDelivered);
                bookings.add(booking);
            }
            return bookings;
        }
        catch(SQLException e){
                logger.info(e.getMessage() + "test");
            }
        return null;
    }

    private void closeConnections(Connection db, ResultSet results, PreparedStatement statement){

        if (db != null){try {db.close();}catch (Exception e){logger.info(e.getMessage());}}
        if(statement != null){ try{ statement.close(); } catch (Exception e){ logger.info(e.getMessage());}}
        if(results != null){ try{ results.close();} catch (Exception e){ logger.info(e.getMessage());}}

    }
}
