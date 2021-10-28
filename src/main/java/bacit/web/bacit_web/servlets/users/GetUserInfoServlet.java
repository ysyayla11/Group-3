package bacit.web.bacit_web.servlets.users;

import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.models.UserModel;
import bacit.web.bacit_web.servlets.SuperServlet;
import bacit.web.bacit_web.utilities.DBUtils;

import javax.servlet.ServletException;
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

@WebServlet(name = "GetUserInfoServlet", value = "/SiteAdmin/GetUserInfoServlet")
public class GetUserInfoServlet extends SuperServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        ResultSet results;
        UserModel user;

        String userID = request.getParameter("userID");

        try {
            out.println(HtmlModel.getHeader("user info"));
            results = getUserInfo(out, userID);
            user = createUserModel(results, out);
            printHtml(out, user);
            out.println(HtmlModel.getFooter());

        }
        catch (SQLException e){
            out.println(e);
        }

        out.println(userID);

    }

    private ResultSet getUserInfo(PrintWriter out, String userID) throws SQLException {

        Connection db = super.connectToDB(out);

        String query = "select * from user where User_id = ?";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, userID);

        ResultSet results = statement.executeQuery();

        return results;
    }

    private UserModel createUserModel(ResultSet results, PrintWriter out) {
        String fullName = "";
        String email = "";
        String phoneNumber = "";
        Boolean union = false;
        String debt = "";
        String password = "";
        String address = "";
        String userID = "";

        try{
            while(results.next()){
                userID = results.getString(1);
                fullName = results.getString(2);
                email = results.getString(3);
                phoneNumber = results.getString(4);
                password = results.getString(5);
                address = results.getString(6);
                union = results.getBoolean(7);
                debt = results.getString(8);
            }
        }
        catch (SQLException e){
            out.println(e);
        }

        UserModel user = new UserModel(Integer.parseInt(userID), fullName, email,
                                        phoneNumber, password, address, union, Integer.parseInt(debt));

        return user;
    }

    private void printHtml(PrintWriter out, UserModel user) throws SQLException{
        printForm(out, user);
        printDeleteUserForm(out, user.getId());
        printScript(out);
    }

    private void printForm(PrintWriter out, UserModel user){

        out.println("    <form action=\"EditUserInfoServlet\" method=\"post\">\n" +
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
                    out.println("     <input type=\"radio\" id=\"buttonYes\" name=\"union\" value=\"true\" checked=\"checked\">\n" +
                            "        <label for=\"buttonYes\">Ja</label>\n" +
                            "        <input type=\"radio\" id=\"buttonNo\" name=\"union\" value=\"false\">\n" +
                            "        <label for=\"buttonNo\">Nei</label>\n");
                }
                else {
                    out.println("    <input type=\"radio\" id=\"buttonYes\" name=\"union\" value=\"true\">\n" +
                            "        <label for=\"buttonYes\">Ja</label>\n" +
                            "        <input type=\"radio\" id=\"buttonNo\" name=\"union\" value=\"false\" checked=\"checked\">\n" +
                            "        <label for=\"buttonNo\">Nei</label>\n");
                }
        out.println("        <br>\n" +
                    "        <label> Gjeld </label>\n" +
                    "        <input type=\"text\" name = \"debt\" value = '" + user.getDebt() + "'>\n" +
                    "        <br>\n" +
                    "        <label> Passord </label>\n" +
                    "        <input type=\"text\" name = \"password\" value = '" + user.getPassword() + "'>\n" +
                    "        <br>\n" +
                    "        <button type=\"submit\" value='" + user.getId() + "' name='userID'> Endre </button>\n" +
                    "    </form>\n");
    }

    private void printDeleteUserForm(PrintWriter out, int userID){
            out.println("<form action=\"../SiteAdmin/DeleteUserServlet\" method=\"post\" id=\"deleteUserForm\">\n" +
                    "\n" +
                    "    <input type=\"hidden\" name=\"userID\" value=\"" + userID + "\">\n" +
                    "\n" +
                    "</form>\n" +
                    "\n" +
                    "<button onclick=\"confirmDeleteUser()\">delete user</button>");
    }

    private void printScript(PrintWriter out){
        out.println("<script>\n" +
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
                "\n" +
                "</script>");
    }

}
