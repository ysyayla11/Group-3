package bacit.web.bacit_web.servlets.users;

import bacit.web.bacit_web.servlets.SuperServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SeeUserInfoServlet", value = "/SiteUser/SeeUserInfoServlet")
public class SeeUserInfoServlet extends SuperServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentUserPhone = request.getUserPrincipal().getName();
    }
}
