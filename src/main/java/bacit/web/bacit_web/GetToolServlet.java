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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "GetToolServlet", value = "/GetToolServlet")

public class GetToolServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Tool_Name = request.getParameter("Tool_Name");
        PrintWriter out = response.getWriter();
        try {
            ToolModel model = getTool(Tool_Name, out);

            out.println(model.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private ToolModel getTool(String Tool_name, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query3 = "select * from tools where Tool_id = ?";

        PreparedStatement statement = db.prepareStatement(query3);
        statement.setString(1, Tool_name);
        ResultSet rs = statement.executeQuery();
        ToolModel model = null;
        while (rs.next()) {
            model =
                    new ToolModel(rs.getString("Tool_id"), rs.getString("Tool_name"), rs.getString("Tool_type"), rs.getString("Tool_condition"),
                            rs.getInt("Tool_price"), rs.getInt("Tool_freeFirstDay"),
                            rs.getString("Tool_importantInformation"), rs.getString("Tool_image"));
        }

        return model;
    }

}