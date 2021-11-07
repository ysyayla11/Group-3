package bacit.web.bacit_web.servlets.tools;
import bacit.web.bacit_web.models.ToolModel;
import bacit.web.bacit_web.models.UserModel;
import bacit.web.bacit_web.utilities.DBUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import bacit.web.bacit_web.servlets.SuperServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name = "AdministerToolServlet", value = "/SiteAdmin/AdministerToolServlet")
public class AdministerToolServlet extends SuperServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        ToolModel tool = createToolModelFromRequest(request);

        try{
            AdministerTool(tool, out);
            out.println("Change success!");
        }
        catch(SQLException e){
            out.println("oops something went wrong " + e);
        }

        private ToolModel createToolModelFromRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String condition = request.getParameter("condition");
        String price  = request.getParameter("price ");
        String qualification = request.getParameter("qualification");
        String freeFirstDay   = request.getParameter("freeFirstDay  ");
        String importantInformation = request.getParameter("importantInformation");
        String maxDays  = request.getParameter("maxDays ");
        String delivered  = request.getParameter("delivered ");
        String toolID = request.getParameter("toolID");
        int intUserID = Integer.parseInt(toolID);

            ToolModel toolModel = new ToolModel(toolID, name, type, condition, price, qualification, freeFirstDay, importantInformation, maxDays, delivered, );

            return toolModel;
        }

        public void  editToolInfo(ToolModel tool, PrintWriter out);
                throws SQLException {

            Connection db = super.connectToDB(out);


            String query = "Update tool set tool_name  = ?, tool_type  = ?, tool_condition  = ?, tool_price  = ?, tool_qualification  = ?, " +
                    "tool_freeFirstDay  = ?, tool_importantInformation = ?, tool_maxDays = ?, tool_delivered = ?,   where tool_id = ?";

            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setString(3, condition);
            statement.setString(4, price);
            statement.setString(5, qualification);

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

            statement.setString(10, toolID);

            statement.executeQuery();

        }

        out.println("<html><body>");
        out.println("<p>test</p>");
        out.println("<form action='GetToolServlet' method='get' enctype='multipart/form-data'>");
        out.println("<label for='Tool_Name'>Navn på verktøy: </label>");
        out.println("</form>");
        out.println("</body></html>");
    }

}