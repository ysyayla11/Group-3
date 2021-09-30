package bacit.web.bacit_web;

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


@WebServlet(name = "EditUserInfoServlet", value = "/EditUserInfoServlet")
public class EditUserInfoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String access = request.getParameter("access");
        String union = request.getParameter("union");
        String debt = request.getParameter("debt");
        String password = request.getParameter("password");

        try{
            editUserInfo(fullName, email, phoneNumber, address, access, union, debt, password, out);
            out.println("Change success!");
        }
        catch(SQLException e){
            out.println("oops something went wrong " + e);


        }






        //out.println(fullName + email +  phoneNumber + address + access + union + debt + password);
    }

    public void editUserInfo(String fullName, String email, String phoneNumber, String address, String access, String union, String debt, String password, PrintWriter out) throws SQLException {
        Connection db = null;
        try{
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Error i connection");
        }
        String query = "Update user set user_fullName = ?, user_email = ?, user_phoneNumber = ?, user_address = ?, user_access = ?, user_union = ?, user_debt = ?, user_password = ? where user_id = 1";
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
        statement.executeQuery();

    }


}
