package bacit.web.bacit_web.servlets.tools;

import bacit.web.bacit_web.utilities.DBUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name = "EditToolInfoServlet", value = "/EditToolInfoServlet")
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
        String maxDays = request.getParameter("maxDays");
        String delivered = request.getParameter("delivered");
        String image = request.getParameter("image");
        String toolID = request.getParameter("toolID");
        int intToolID = Integer.parseInt(toolID);

        try{
            editToolInfo(toolName, type, condition, price, qualification, freeFirstDay, importantInformation, maxDays, delivered, image, intToolID, out);
            out.println("Change success!");
        }
        catch(SQLException e){
            out.println("oops something went wrong " + e);
        }
    }

    public void editToolInfo(String toolName, String type, String condition, String price,
                             String qualification, String freeFirstDay, String importantInformation, String maxDays, String delivered, String image, int toolID, PrintWriter out) throws SQLException {

        Connection db = null;
        try{
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Error i connection");
        }

        String query = "Update tools set Tool_name = ?, Tool_type = ?, Tool_condition = ?, Tool_price = ?, Tool_qualification = ?, " +
                        "Tool_freeFirstDay = ?, Tool_importantInformation = ?, Tool_maxDays = ? , Tool_delivered = ? , Tool_image = ? where Tool_id = ?";

        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, toolName);
        statement.setString(2, type);
        statement.setString(3, condition);
        statement.setString(4, price);

        if(qualification.equals("true")){
            statement.setBoolean(5, true);
        }
        else{
            statement.setBoolean(5, false);
        }

        if(freeFirstDay.equals("true")){
            statement.setBoolean(6, true);
        }
        else{
            statement.setBoolean(6, false);
        }
        statement.setString(7, importantInformation);
        statement.setString(8, maxDays);

        if(delivered.equals("true")){
            statement.setBoolean(9, true);
        }
        else{
            statement.setBoolean(9, false);
        }

        statement.setString(10, image);
        statement.setInt(11, toolID);
        statement.executeQuery();

    }


}
