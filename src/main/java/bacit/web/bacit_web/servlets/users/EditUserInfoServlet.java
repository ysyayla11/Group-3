package bacit.web.bacit_web.servlets.users;

import bacit.web.bacit_web.DAO.UserDAO;
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
import java.util.logging.Logger;


@WebServlet(name = "EditUserInfoServlet", value = "/SiteAdmin/EditUserInfoServlet")
public class EditUserInfoServlet extends SuperServlet {

    Logger logger = Logger.getLogger(String.valueOf(EditUserInfoServlet.class));
    StringBuffer outString = new StringBuffer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        outString.delete(0, outString.length());

        PrintWriter out = response.getWriter();

        UserModel user = createUserModelFromRequest(request);

        if(editUserInfo(user)) {
            outString.append("Endringen lykkes");
        }
        else {
            outString.append("noe gikk feil ");
        }

        out.println(outString);
    }

    private UserModel createUserModelFromRequest(HttpServletRequest request){

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String union = request.getParameter("union");
        String debt = request.getParameter("debt");
        String userID = request.getParameter("userID");
        String address = request.getParameter("address");

        boolean boolUnion;
        if (union.equals("true")){boolUnion = true;}
        else {boolUnion = false;}
        int intDebt = Integer.parseInt(debt);
        int intUserID = Integer.parseInt(userID);

        UserModel userModel = new UserModel(intUserID, fullName, email, phoneNumber, null, address, boolUnion, intDebt);

        return userModel;
    }

    private boolean editUserInfo(UserModel user){
        UserDAO dao = new UserDAO();
        return dao.editUserInfo(user);
    }


}
