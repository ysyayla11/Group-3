package bacit.web.bacit_web.servlets.users;

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
import java.sql.SQLException;
import java.util.logging.Logger;

@WebServlet(name = "GetUserInfoServlet", value = "/SiteAdmin/GetUserInfoServlet")
public class GetUserInfoServlet extends SuperServlet {

    Logger logger = Logger.getLogger(String.valueOf(GetUserInfoServlet.class));
    StringBuffer outString = new StringBuffer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        outString.delete(0, outString.length());

        UserModel user;

        String userID = request.getParameter("userID");

        outString.append(HtmlModel.getHeader("user info"));
        user = getUserInfo(userID);
        printHtml(user);
        outString.append(HtmlModel.getFooter());

        out.println(outString);
    }

    private UserModel getUserInfo(String userID) {

        UserDAO dao = new UserDAO();

        return dao.getUserFromID(userID);
    }

    private void printHtml(UserModel user) {
        printForm(user);
        printDeleteUserForm(user.getId());
        printScript();
    }

    private void printForm(UserModel user){

        outString.append("    <form action=\"EditUserInfoServlet\" method=\"post\" id=\"editUserForm\">\n" +
                    "        <label> Fullt navn </label>\n" +
                    "        <input type=\"text\" name = \"fullName\" value='" + user.getFullName() + "'>\n" +
                    "        <br>\n" +
                    "        <label> E-mail </label>\n" +
                    "        <input type=\"text\" name = \"email\" value = '" + user.getEmail() + "'>\n" +
                    "        <br>\n" +
                    "        <label> Telefonnummer </label>\n" +
                    "        <input type=\"text\" name = \"phoneNumber\" value='" + user.getPhoneNumber() + "'>\n" +
                    "        <br>\n" +
                    "        <label> adresse </label>\n" +
                    "       <input type=\"text\" name = \"address\" value='" + user.getAddress() + "'>\n" +
                    "        <br>\n" +
                    "        <label> Fagforening </label>\n");
                if(user.getUnion()) {
                    outString.append("     <input type=\"radio\" id=\"buttonYes\" name=\"union\" value=\"true\" checked=\"checked\">\n" +
                            "        <label for=\"buttonYes\">Ja</label>\n" +
                            "        <input type=\"radio\" id=\"buttonNo\" name=\"union\" value=\"false\">\n" +
                            "        <label for=\"buttonNo\">Nei</label>\n");
                }
                else {
                    outString.append("    <input type=\"radio\" id=\"buttonYes\" name=\"union\" value=\"true\">\n" +
                            "        <label for=\"buttonYes\">Ja</label>\n" +
                            "        <input type=\"radio\" id=\"buttonNo\" name=\"union\" value=\"false\" checked=\"checked\">\n" +
                            "        <label for=\"buttonNo\">Nei</label>\n");
                }
        outString.append("        <br>\n" +
                    "        <label> Gjeld </label>\n" +
                    "        <input type=\"text\" name = \"debt\" value = '" + user.getDebt() + "'>\n" +
                    "        <br>\n" +
                    "        <button onclick='confirmEditUser' value='" + user.getId() + "' name='userID'> Endre </button>\n" +
                    "    </form>\n");
    }

    private void printDeleteUserForm(int userID){
            outString.append("<form action=\"../SiteAdmin/DeleteUserServlet\" method=\"post\" id=\"deleteUserForm\">\n" +
                    "\n" +
                    "    <input type=\"hidden\" name=\"userID\" value=\"" + userID + "\">\n" +
                    "\n" +
                    "</form>\n" +
                    "\n" +
                    "<button onclick=\"confirmDeleteUser()\">delete user</button>");
    }

    private void printScript(){
        outString.append("<script>\n" +
                "\n" +
                "    var form = document.getElementById(\"deleteUserForm\")\n" +
                "\n" +
                "    function confirmDeleteUser() {\n" +
                "        if (confirm(\"Vil du slette denne brukeren og tilhørende data? Denne handlingen kan ikke angres.\")) {\n" +
                "            form.submit()\n" +
                "        }\n" +
                "        else {\n" +
                "            return\n" +
                "        }\n" +
                "    }\n" +
                "    var formEdit = document.getElementById(\"editUserForm\")\n" +
                "\n" +
                "    function confirmEditUser() {\n" +
                "        if (confirm(\"Vil du utføre disse endringene? Denne handlingen kan ikke angres.\")) {\n" +
                "            formEdit.submit()\n" +
                "        }\n" +
                "        else {\n" +
                "            return\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "</script>");
    }

}
