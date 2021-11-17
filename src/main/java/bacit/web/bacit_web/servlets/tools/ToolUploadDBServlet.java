package bacit.web.bacit_web.servlets.tools;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet")

public class ToolUploadDBServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get values of text fields
        String name = request.getParameter("Tool_name");
        String type = request.getParameter("Tool_type");
        String condition = request.getParameter("Tool_condition");
        String freeFirstDay = request.getParameter("Tool_freeFirstDay");
        String price = request.getParameter("Tool_price");
        String importantInfo = request.getParameter("Tool_importantInformation");

    }
}
