package bacit.web.bacit_web.DAO;

import bacit.web.bacit_web.utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class BookingDAO {

    private Logger logger = Logger.getLogger(String.valueOf(BookingDAO.class));

    public ResultSet getBookingsFromPhoneNumber(String userPhone, PrintWriter out) {
        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);
            String query = "select t.Tool_name, Booking_dateStart, Booking_dateEnd, Booking_dateDelivered, Booking_paid from booking inner join user u on booking.User_id = u.User_id inner join tools t on booking.Tool_id = t.Tool_id where u.User_phoneNumber = 12345679;";
            PreparedStatement statement = db.prepareStatement(query);
            ResultSet results = statement.executeQuery();
            return results;
        }
        catch (ClassNotFoundException | SQLException e) {
            logger.info("getBookingsFromPhoneNumber" + e.getMessage());
        }
        return null;
    }
}
