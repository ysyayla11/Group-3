package bacit.web.bacit_web.servlets.tools;

import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.models.ToolModel;
import bacit.web.bacit_web.utilities.DBUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.Tool;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name = "EditToolInfoServlet", value = "/SiteAdmin/EditToolInfoServlet")
public class EditToolInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String toolName = request.getParameter("toolName");
        String type = request.getParameter("type");
        String condition = request.getParameter("condition");
        String price = request.getParameter("price");
        String qualification = request.getParameter("qualification");
        String freeFirstDay = request.getParameter("freeFirstDay");
        String importantInformation = request.getParameter("importantInformation");
        String image = request.getParameter("image");
        String toolID = request.getParameter("toolID");

        ToolModel tool = new ToolModel(toolID, toolName, type, condition, Integer.parseInt(price), Integer.parseInt(freeFirstDay), importantInformation, image, true);

        if(editToolInfo(tool)){
            out.println("Change success!");
        }
        else {
            out.println("noe gikk galt");
        }

    }

    public boolean editToolInfo(ToolModel tool){
        ToolDAO dao = new ToolDAO();
        return dao.editTool(tool);
    }


}
