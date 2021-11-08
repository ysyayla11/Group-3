package bacit.web.bacit_web.models;

import java.sql.Date;

public class BookingModel {
    private int booking_id;
    private int tool_id;
    private int user_id;
    private String booking_dateStart;
    private String booking_dateEnd;
    private boolean paid;
    private String booking_dateDelivered;

    public BookingModel(int booking_id, int tool_id, int user_id, String booking_dateStart, String booking_dateEnd, boolean paid, String booking_dateDelivered){
        this.booking_id = booking_id;
        this.tool_id = tool_id;
        this.user_id = user_id;
        this.booking_dateStart = booking_dateStart;
        this.booking_dateEnd = booking_dateEnd;
        this.paid = paid;
        this.booking_dateDelivered = booking_dateDelivered;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public int getTool_id() {
        return tool_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getBooking_dateStart() {
        return booking_dateStart;
    }

    public String getBooking_dateEnd() {
        return booking_dateEnd;
    }

    public boolean getPaid(){
        return paid;
    }

    public String getBooking_dateDelivered() {
        return booking_dateDelivered;
    }
}

