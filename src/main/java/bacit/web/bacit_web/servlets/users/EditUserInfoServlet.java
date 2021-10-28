package bacit.web.bacit_web.servlets.users;

import bacit.web.bacit_web.models.UserModel;
import bacit.web.bacit_web.servlets.SuperServlet;
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


@WebServlet(name = "EditUserInfoServlet", value = "/SiteAdmin/EditUserInfoServlet")
public class EditUserInfoServlet extends SuperServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        UserModel user = createUserModelFromRequest(request);

        try{
            editUserInfo(user, out);
            out.println("Change success!");
        }
        catch(SQLException e){
            out.println("oops something went wrong " + e);
        }
    }

    private UserModel createUserModelFromRequest(HttpServletRequest request){

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String union = request.getParameter("union");
        String debt = request.getParameter("debt");
        String password = request.getParameter("password");
        String userID = request.getParameter("userID");
        String address = request.getParameter("address");

        boolean boolUnion;
        if (union.equals("true")){boolUnion = true;}
        else {boolUnion = false;}
        int intDebt = Integer.parseInt(debt);
        int intUserID = Integer.parseInt(userID);

        UserModel userModel = new UserModel(intUserID, fullName, email, phoneNumber, password, address, boolUnion, intDebt);

        return userModel;
    }



    private void editUserInfo(UserModel user, PrintWriter out) throws SQLException {

        Connection db = super.connectToDB(out);

        String query = "Update user set user_fullName = ?, user_email = ?, user_phoneNumber = ?," +
                        "user_union = ?, user_debt = ?, user_password = ? where user_id = ?";

        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, user.getFullName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPhoneNumber());
        statement.setBoolean(4, user.getUnion());
        statement.setInt(5, user.getDebt());
        statement.setString(6, user.getPassword());
        statement.setInt(7, user.getId());
        statement.executeQuery();

    }


}
