package bacit.web.bacit_web.servlets.users;

import bacit.web.bacit_web.DAO.AccessDAO;
import bacit.web.bacit_web.DAO.UserDAO;
import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.models.UserModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="/uploadServletUser", value = "/SiteAdmin/UserUploadDBServlet")
public class UserUploadDBServlet extends HttpServlet {

    StringBuffer outString = new StringBuffer();
    Logger logger = Logger.getLogger(String.valueOf(UserUploadDBServlet.class));

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        outString.delete(0, outString.length());

        //get values of text fields
        String fullName = request.getParameter("User_fullName");
        String email = request.getParameter("User_email");
        String phoneNumber = request.getParameter("User_phoneNumber");
        String address = request.getParameter("User_address");
        String stringAccess = request.getParameter("User_access");
        Boolean access = false;
        String stringUnion = request.getParameter("User_union");
        Boolean union = false;
        String debt = request.getParameter("User_debt");
        String password = request.getParameter("User_password");

        if (stringAccess.equals("true")){
            access = true;
        }
        if (stringUnion.equals("true")){
            union = true;
        }

        UserModel user = new UserModel(0, fullName, email, phoneNumber, password, address, union, Integer.parseInt(debt));

        ;

        outString.append(HtmlModel.getHeader("opplastning suksessfull"));
        if(uploadNewUser(user)){
            giveUserAccess(user, access);
            outString.append("vellykket opplastning");
        }
        else{
            outString.append("noe feil skjedde, vennligst prøv igjen");
        }

        out.println(outString);

    }

    private Boolean uploadNewUser(UserModel user){
        UserDAO dao = new UserDAO();
        return (dao.uploadNewUser(user));
    }

    private void giveUserAccess(UserModel user, Boolean access){
        AccessDAO dao = new AccessDAO();
        dao.giveUserAccess(user.getPhoneNumber());
        if(access){
            dao.giveAdminAccess(user.getPhoneNumber());
        }
    }

}

