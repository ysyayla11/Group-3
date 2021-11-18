package bacit.web.bacit_web.servlets.tools;

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
        String delivered = request.getParameter("delivered");
        String image = request.getParameter("image");
        String toolID = request.getParameter("toolID");
        int intToolID = Integer.parseInt(toolID);

        ToolModel tool = new ToolModel(toolID, toolName, type, condition, Integer.parseInt(price), Integer.parseInt(freeFirstDay), importantInformation, image, true);

        try{
            editToolInfo(tool, out);
            out.println("Change success!");
        }
        catch(SQLException e){
            out.println("oops something went wrong " + e);
        }
    }

    public void editToolInfo(ToolModel tool, PrintWriter out) throws SQLException {

        Connection db = null;
        try{
            db = DBUtils.getINSTANCE().getConnection();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Error i connection");
        }

        String query = "Update tools set Tool_toolName = ?, Tool_type = ?, Tool_condition = ?, Tool_price = ?, " +
                        "Tool_freeFirstDay = ?, Tool_importantInformation = ? , Tool_delivered = ? , Tool_image = ? where Tool_id = ?";

        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, tool.getName());
        statement.setString(2, tool.getType());
        statement.setString(3, tool.getCondition());
        statement.setInt(4, tool.getPrice());
        statement.setInt(5, tool.getFreeFirstDay());
        statement.setString(6, tool.getImportantInformation());
        statement.setBoolean(7, true);
        statement.setString(8, tool.getImage());
        statement.setString(9, tool.getId());
        statement.executeQuery();

    }


}
