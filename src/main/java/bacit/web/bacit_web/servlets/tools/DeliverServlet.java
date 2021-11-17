package bacit.web.bacit_web.servlets.tools;

import bacit.web.bacit_web.DAO.ToolDAO;
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
import java.util.logging.Logger;


@WebServlet(name = "DeliverServlet", value = "/DeliverServlet")
public class DeliverServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(String.valueOf(DeliverServlet.class));
    private StringBuffer outString = new StringBuffer();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        outString.delete(0, outString.length());

        String tool_id = request.getParameter("Tool_id");
        Boolean tool_delivered = false;
        if (request.getParameter("Tool_delivered").equals("true")) {
            tool_delivered = true;
            deliverTool(tool_id);
        }

        outString.append("Varen har blitt levert");
        out.println(outString);
    }
    public void deliverTool(String tool_id){
        ToolDAO dao = new ToolDAO();
        dao.deliverTool(tool_id);
    }
}
