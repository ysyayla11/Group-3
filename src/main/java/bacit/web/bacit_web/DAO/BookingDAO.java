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

public class BookingDAO extends AMVDatabaseDAO{

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

    public ArrayList<BookingModel> getBookingsFromToolID(String toolID) {
        ArrayList<BookingModel> bookings = null;
        Connection db = null;
        PreparedStatement statement = null;
        ResultSet results = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "select * from booking where tool_id = ? and Booking_dateStart;";
            statement = db.prepareStatement(query);
            statement.setString(1, toolID);
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

    public BookingModel getBookingFromBookingID(String booking_id){
        BookingModel booking = null;
        Connection db = null;
        PreparedStatement statement = null;
        ResultSet results = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "select * from booking where Booking_id = ?;";
            statement = db.prepareStatement(query);
            statement.setString(1, booking_id);
            results = statement.executeQuery();
            booking = resultSetToBookingModelArrayList(results).get(0);
            statement.executeQuery();

        }
        catch (ClassNotFoundException | SQLException e) {
            logger.info("getBookingsFromPhoneNumber" + e.getMessage());
        }
        finally {
            closeConnections(db, results, statement);
        }
        return booking;
    }

    public int getNumberOfUnpaidBookings(String userId){
        int numberOfBookings = 0;
        Connection db = null;
        PreparedStatement statement = null;
        ResultSet results = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "select count(?) from booking where User_id = ?  and Booking_paid = 0";
            statement = db.prepareStatement(query);
            statement.setString(1, userId);
            statement.setString(2, userId);
            results = statement.executeQuery();

            results = statement.executeQuery();
            numberOfBookings = getNumberFromResultset(results);

        }
        catch (ClassNotFoundException | SQLException e) {
            logger.info("getBookingsFromPhoneNumber" + e.getMessage());
        }
        finally {
            closeConnections(db, results, statement);
        }
        return numberOfBookings;
    }

    public boolean payAllBookings(String userID){
        boolean success = false;
        Connection db = null;
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "update booking set Booking_paid = 1 where User_id = ? and Booking_paid = 0";
            statement = db.prepareStatement(query);
            statement.setString(1, userID);
            statement.executeQuery();
            success = true;
        }
        catch (ClassNotFoundException | SQLException e) {
            logger.info("getBookingsFromPhoneNumber" + e.getMessage());
        }
        finally {
            closeConnections(db, null, statement);
        }

        return success;
    }

    public boolean addBooking(BookingModel booking){

        Connection db = null;
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();

            String query = "insert into booking(Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered) VALUES(Booking_id, ?, ?, ?, ?, ?, null);";
            statement = db.prepareStatement(query);

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
        finally {
            closeConnections(db, null, statement);
        }
        return false;
    }

    public void setDeliveredDate(String booking_id){
        Connection db = null;
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();

            String query = "update booking set Booking_dateDelivered = current_date where Booking_id = ?;";
            statement = db.prepareStatement(query);
            statement.setString(1, booking_id);
            statement.executeQuery();
        }
        catch (ClassNotFoundException | SQLException e){
            logger.info("addBooking " + e.getMessage());
        }
        finally {
            closeConnections(db, null, statement);
        }
    }

    public void setBookingPaid(String booking_id){
        Connection db = null;
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();

            String query = "update booking set Booking_paid = true where Booking_id = ?";
            statement = db.prepareStatement(query);
            statement.setString(1, booking_id);
            statement.executeQuery();
        }
        catch (ClassNotFoundException | SQLException e){
            logger.info("addBooking " + e.getMessage());
        }
        finally {
            closeConnections(db, null, statement);
        }
    }

    private int getNumberFromResultset(ResultSet resultSet){
        int number = 0;
        try{
            resultSet.next();
            number = Integer.parseInt(resultSet.getString(1));
        }
        catch (SQLException e){
            logger.info(e.getMessage());
        }
        return number;
    }

    private ArrayList<BookingModel> resultSetToBookingModelArrayList(ResultSet results){
        int booking_id;
        int tool_id;
        int user_id;
        String booking_dateStart;
        String booking_dateEnd;
        boolean paid;
        String booking_dateDelivered;

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
}
