package bacit.web.bacit_web.servlets.users;

import bacit.web.bacit_web.models.HtmlModel;
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

        outString.append(HtmlModel.getHeader("bruker profil"));
        outString.append(request.getUserPrincipal().getName());
        outString.append("<a href='../SiteAdmin/Admin_dashboard.jsp'>admin dashboard</a>");
        outString.append(HtmlModel.getFooter());

        out.println(outString);
    }
}
