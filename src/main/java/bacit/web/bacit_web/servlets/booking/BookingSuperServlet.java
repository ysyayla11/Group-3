package bacit.web.bacit_web.servlets.booking;

import bacit.web.bacit_web.DAO.BookingDAO;
import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.DAO.UserDAO;
import bacit.web.bacit_web.models.BookingModel;
import bacit.web.bacit_web.models.ToolModel;
import bacit.web.bacit_web.models.UserModel;
import bacit.web.bacit_web.servlets.SuperServlet;

import java.time.LocalDate;
import java.time.Period;

public class BookingSuperServlet extends SuperServlet {

    protected int calculateDebt(BookingModel booking){

        int daysToPayFor = calculateDaysToPayFor(booking);

        ToolDAO dao = new ToolDAO();
        ToolModel tool = dao.getToolById(Integer.toString(booking.getTool_id()));

        int freeFirstDay = tool.getFreeFirstDay();
        int price = tool.getPrice();

        int debt = daysToPayFor * price;

        if(freeFirstDay == 1){
            debt-=(price);
        }

        return debt;
    }

    private int calculateDaysToPayFor(BookingModel booking){

        LocalDate startDate = LocalDate.parse(booking.getBooking_dateStart().substring(0, 10));
        LocalDate endDate = LocalDate.parse(booking.getBooking_dateEnd().substring(0, 10));

        String dateDeliveredString = booking.getBooking_dateDelivered();
        LocalDate dateDelivered;

        if (dateDeliveredString != null){ dateDelivered = LocalDate.parse(dateDeliveredString.substring(0, 10)); }
        else { dateDelivered = null; }

        LocalDate currentDate = LocalDate.now();

        if(dateDelivered != null && !endDate.isBefore(dateDelivered)){
            return Period.between(startDate, endDate).getDays() + 1;
        }
        else if(dateDelivered != null && endDate.isBefore(dateDelivered)){
            return Period.between(startDate, dateDelivered).getDays() + 1;
        }
        else if(dateDelivered == null && endDate.isBefore(currentDate)){
            return Period.between(startDate, currentDate).getDays();
        }
        else{
            return Period.between(startDate, endDate).getDays() + 1;
        }
    }

    protected void updateDebt(int amount, String userID){
        UserDAO dao = new UserDAO();
        dao.updateUserDebt(userID, amount);
    }

    protected BookingModel getBooking(String booking_id){
        BookingDAO dao = new BookingDAO();
        return dao.getBookingFromBookingID(booking_id);
    }

    protected UserModel getUser(String userPhone){
        UserDAO dao = new UserDAO();
        return dao.getUserFromPhoneNumber(userPhone);
    }

    protected void setAsDelivered(String booking_id){
        BookingDAO dao = new BookingDAO();
        dao.setBookingPaid(booking_id);
    }
}
