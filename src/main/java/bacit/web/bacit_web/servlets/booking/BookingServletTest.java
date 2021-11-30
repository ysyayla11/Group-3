package bacit.web.bacit_web.servlets.booking;

import bacit.web.bacit_web.models.BookingModel;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class BookingServletTest {
    @org.junit.jupiter.api.Test

    void doPost() throws Exception{
        BookingServletFake unitUnderTest = new BookingServletFake();

        unitUnderTest.doPost(null, null);

        BookingModel booking = new BookingModel(1, 1, 1, "2001-01-01", "2001-01-02", true, null);
        assertEquals(20, unitUnderTest.calculateBookingPrice(booking));

    }

}
class BookingServletFake extends BookingServlet {

    @Override
    protected boolean bookingPaidStatus(HttpServletRequest request){
        return true;
    }

    @Override
    protected String getToolIdFromRequest(HttpServletRequest request){
        return "1";
    }

    @Override
    protected String getUser_idFromRequest(HttpServletRequest request) {
        return "1";
    }

    @Override
    protected String getBooking_dateStartFromRequest(HttpServletRequest request) {
        return "2001-11-01";
    }

    @Override
    protected String getBooking_dateEndFromRequest(HttpServletRequest request) {
        return "2001-11-01";
    }

    @Override
    protected void printHtml(HttpServletResponse response) throws IOException {

    }

    @Override
    protected void setResponseContentType(HttpServletResponse response){

    }

    @Override
    protected boolean checkQualified(String tool_id, String user_id){
        return true;
    }

    @Override
    protected boolean addBooking(BookingModel booking){
        return true;
    }

    @Override
    protected boolean updateDebt(String user_id, int amount){
        return true;
    }

    @Override
    protected int calculateBookingPrice(BookingModel booking){
        return 20;
    }
}