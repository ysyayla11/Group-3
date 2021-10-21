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
@MultipartConfig(maxFileSize = 100000000) //upload file size upto 100MB

public class ToolUploadDBServlet extends HttpServlet {
    private String dbURL= "jdbc:mariadb://172.17.0.1:3308/MytestDB";
    private String dbUsername="root";
    private String dbPassword="12345";

    //endring
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException{}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get values of text fields
        String name = request.getParameter("Tool_name");
        String type = request.getParameter("Tool_type");
        String condition = request.getParameter("Tool_condition");
        String freeFirstDay = request.getParameter("Tool_freeFirstDay");
        String price = request.getParameter("Tool_price");
        String importantInfo = request.getParameter("Tool_importantInformation");

        //input stream is the upload file
        InputStream inputStream = null;

        //Obtains the upload file in this multipart request
        Part filePart = request.getPart("Tool_image");
        if (filePart != null){
            //prints out information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            //obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        Connection conn = null;
        String message = null;

        try{
            //connects to db
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            //constructs SQL statement
            String sql = "INSERT INTO tools (Tool_name, Tool_type, Tool_condition, Tool_price, " +
                    "Tool_importantInformation, Tool_image, Tool_freeFirstDay) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setString(3, condition);
            statement.setString(4, price);
            statement.setString(5, importantInfo);
            statement.setBoolean(7, Boolean.parseBoolean(freeFirstDay));

            if (inputStream != null){
                //fetches input stream of the upload file for the picture
                statement.setBlob(6, inputStream);
            }

            //sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0){
                message = "File uploaded and saved to tool in database";
            }
        }
        catch (SQLException sqlException){
            message = "ERROR: " + sqlException.getMessage();
            sqlException.printStackTrace();
        }
        finally {
            if (conn != null){
                //closes db connection
                try{
                    conn.close();
                }
                catch (SQLException sqlException){
                    sqlException.printStackTrace();
                }
            }
            //sets the message in request scope
            request.setAttribute("MessageTool", message);

            //forwards to the message page
            request.getServletContext().getRequestDispatcher("/MessageTool.jsp").forward(request, response);
        }
    }
}
