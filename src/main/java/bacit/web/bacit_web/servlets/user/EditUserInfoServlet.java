package bacit.web.bacit_web.servlets.user;

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


@WebServlet(name = "EditUserInfoServlet", value = "/EditUserInfoServlet")
public class EditUserInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String access = request.getParameter("access");
        String union = request.getParameter("union");
        String debt = request.getParameter("debt");
        String password = request.getParameter("password");
        String userID = request.getParameter("userID");
        int intUserID = Integer.parseInt(userID);

        try{
            editUserInfo(fullName, email, phoneNumber, address, access, union, debt, password, intUserID, out);
            out.println("Change success!");
        }
        catch(SQLException e){
            out.println("oops something went wrong " + e);
        }
    }

    public void editUserInfo(String fullName, String email, String phoneNumber, String address,
                             String access, String union, String debt, String password, int userID, PrintWriter out) throws SQLException {

        Connection db = null;
        try{
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Error i connection");
        }

        String query = "Update user set user_fullName = ?, user_email = ?, user_phoneNumber = ?, user_address = ?, user_access = ?, " +
                        "user_union = ?, user_debt = ?, user_password = ? where user_id = ?";

        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, fullName);
        statement.setString(2, email);
        statement.setString(3, phoneNumber);
        statement.setString(4, address);
        statement.setString(5, access);

        if(union.equals("true")){
            statement.setBoolean(6, true);
        }
        else{
            statement.setBoolean(6, false);
        }
        statement.setString(7, debt);
        statement.setString(8, password);
        statement.setInt(9, userID);
        statement.executeQuery();

    }


}
