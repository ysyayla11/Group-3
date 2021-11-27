package bacit.web.bacit_web.servlets.tools;



import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.servlets.SuperServlet;
import bacit.web.bacit_web.utilities.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DeleteToolServlet", value = "/SiteAdmin/DeleteToolServlet")
public class DeleteToolServlet extends SuperServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        outString.delete(0, outString.length());
        String toolID = request.getParameter("tool_id");

        if(deleteTool(toolID)){
            outString.append("suksess");
        }
        else{
            outString.append("sletting feilet, gå tilbake og prøv på nytt");
        }
        out.println(outString);
    }

    private boolean deleteTool(String toolID){
        ToolDAO dao = new ToolDAO();
        return dao.deleteToolWithID(toolID);
    }

}
