package bacit.web.bacit_web;

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


@WebServlet(name = "DeliverServlet", value = "/DeliverServlet")
public class DeliverServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String tool_id = request.getParameter("Tool_id");
        Boolean tool_delivered = false;
        if (request.getParameter("Tool_delivered").equals("true")) {
            tool_delivered = true;
            try {
                deliverTool(out, tool_id);
            } catch (SQLException e) {
                out.println(e);
            }
        }


        out.println("Varen har blitt levert");

    }
    public void deliverTool(PrintWriter out, String tool_id) throws SQLException  {
        Connection db = null;

        try {
            db = DBUtils.getINSTANCE().getConnection(out);

        } catch (ClassNotFoundException e)  {
            out.println(e);
        }
        String query = "update tools set Tool_delivered = 1 where Tool_id = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, tool_id);
        statement.executeQuery();
    }
}
