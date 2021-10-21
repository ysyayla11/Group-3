package bacit.web.bacit_web.servlets.booking;

import java.io.IOException;
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


@WebServlet("/uploadServletUser")
@MultipartConfig(maxFileSize = 100000000) //upload file size upto 100MB

public class UserUploadDBServlet extends HttpServlet {
    private String dbURL= "jdbc:mariadb://172.17.0.1:3308/MytestDB";
    private String dbUsername="root";
    private String dbPassword="12345";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException{}
    //endring
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get values of text fields
        String fullName = request.getParameter("User_fullName");
        String email = request.getParameter("User_email");
        String phoneNumber = request.getParameter("User_phoneNumber");
        String address = request.getParameter("User_address");
        String access = request.getParameter("User_access");
        String union = request.getParameter("User_union");
        String debt = request.getParameter("User_debt");
        String password = request.getParameter("User_password");



        Connection connection = null;
        String messageUser = null;

        try{
            //connects to db
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            //constructs SQL statement
            String sql = "INSERT INTO user (User_fullName, User_email, User_phoneNumber, User_address, " +
                    "User_access, User_union, User_debt, User_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, access);
            preparedStatement.setBoolean(6, Boolean.parseBoolean(union));
            preparedStatement.setString(7, debt);
            preparedStatement.setString(8, password);



            //sends the statement to the database server
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                messageUser = "File uploaded and saved to users in database";
            }
        }
        catch (SQLException sqlException){
            messageUser = "ERROR: " + sqlException.getMessage();
            sqlException.printStackTrace();
        }
        finally {
            if (connection != null){
                //closes db connection
                try{
                    connection.close();
                }
                catch (SQLException sqlException){
                    sqlException.printStackTrace();
                }
            }
            //sets the message in request scope
            request.setAttribute("MessageUser", messageUser);

            //forwards to the message page
            request.getServletContext().getRequestDispatcher("/MessageUser.jsp").forward(request, response);
        }
    }
}

