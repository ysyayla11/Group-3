package bacit.web.bacit_web.servlets.users;

import bacit.web.bacit_web.DAO.AccessDAO;
import bacit.web.bacit_web.DAO.UserDAO;
import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.models.UserModel;
import bacit.web.bacit_web.servlets.SuperServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(name = "GetUserProfileServlet", value = "/SiteUser/GetUserProfileServlet")
public class GetUserProfileServlet extends SuperServlet {

    Logger logger = Logger.getLogger(String.valueOf(GetUserProfileServlet.class));
    StringBuffer outString = new StringBuffer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        outString.delete(0, outString.length());

        String phoneNumber = request.getUserPrincipal().getName();

        addHtml(getUser(phoneNumber));

        out.println(outString);
    }

    private UserModel getUser(String phoneNumber){
        UserDAO dao = new UserDAO();


        return dao.getUserFromPhoneNumber(phoneNumber);
    }

    private boolean userIsAdmin(String phoneNumber){
        AccessDAO dao = new AccessDAO();
        return dao.IsAdmin(phoneNumber);
    }

    private void addHtml(UserModel user){
        outString.append(HtmlModel.getHeader("Din profil"));
        if(userIsAdmin(user.getPhoneNumber())){
            addAdminLinks();
        }
        addUserInfo(user);
        outString.append(HtmlModel.getFooter());
    }

    private void addAdminLinks(){
        outString.append("<a href=\"../SiteAdmin/Admin_dashboard.jsp\"><button>Gå til admin dashboard</button></a>");
    }

    private void addUserInfo(UserModel user){
        outString.append("<div>Navn: " + user.getFullName() + "</div>\n" +
                "<div>telefonnummer: " + user.getPhoneNumber() + "</div>\n" +
                "<div>email: " + user.getEmail() + "</div>\n" +
                "<div>adresse: " + user.getAddress() + "</div>\n" +
                "<a href = '../logOutServlet'><button>logg ut</button></a>");
    }
}
