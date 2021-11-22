package bacit.web.bacit_web.servlets.booking;

import bacit.web.bacit_web.DAO.BookingDAO;
import bacit.web.bacit_web.DAO.ToolDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MarkToolDeliveredServlet", value = "/SiteUser/markToolDeliveredServlet")
public class MarkToolDeliveredServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String tool_id = request.getParameter("tool_id");
        String booking_id = request.getParameter("booking_id");

        markAsDelivered(tool_id, booking_id);

        out.println("satt som levert");
    }

    private void markAsDelivered(String toolId, String booking_id){
        ToolDAO toolDAO = new ToolDAO();
        BookingDAO bookingDAO = new BookingDAO();
        toolDAO.markToolAsDelivered(toolId);
        bookingDAO.setDeliveredDate(booking_id);
    }
}
