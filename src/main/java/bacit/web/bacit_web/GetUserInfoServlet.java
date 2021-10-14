package bacit.web.bacit_web;

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

@WebServlet(name = "GetUserInfoServlet", value = "/GetUserInfoServlet")
public class GetUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");

        String userID = request.getParameter("userID");
        try {
            out.println(HtmlModel.getHeader("user info"));
            printForm(out, getUserInfo(out, userID));
            out.println(HtmlModel.getFooter());
        }
        catch (SQLException e){
            out.println(e);
        }

        out.println(userID);

    }

    private ResultSet getUserInfo(PrintWriter out, String userID) throws SQLException {

        Connection db = null;
        try{
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Error i connection");
        }

        String query = "select * from user where User_id = ?";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, userID);

        ResultSet results = statement.executeQuery();

        return results;
    }

    private void printForm(PrintWriter out, ResultSet results) throws SQLException{
        String fullName = "";
        String email = "";
        String phoneNumber = "";
        String address = "";
        String access = "";
        Boolean union = false;
        String debt = "";
        String password = "";
        String userID = "";

        while(results.next()){
            fullName = results.getString(2);
            email = results.getString(3);
            phoneNumber = results.getString(4);
            address = results.getString(6);
            access = results.getString(7);
            union = results.getBoolean(8);
            debt = results.getString(9);
            password = results.getString(5);
            userID = results.getString(1);

        }

        out.println(
                "    <form action=\"EditUserInfoServlet\" method=\"post\">\n" +
                "        <label> Fullt navn </label>\n" +
                "        <input type=\"text\" name = \"fullName\" value='" + fullName + "'>\n" +
                "        <br>\n" +
                "        <label> E-mail </label>\n" +
                "        <input type=\"text\" name = \"email\" value = '" + email + "'>\n" +
                "        <br>\n" +
                "        <label> Telefonnummer </label>\n" +
                "        <input type=\"text\" name = \"phoneNumber\" value='" + phoneNumber + "'>\n" +
                "        <br>\n" +
                "        <label> Addresse </label>\n" +
                "        <input type=\"text\" name = \"address\" value = '" + address + "'>\n" +
                "        <br>\n" +
                "        <Label> Tilgang </Label>\n" +
                "        <input type=\"text\" name = \"access\" value = '" + access + "'>\n" +
                "        <br>\n" +
                "        <label> Fagforening </label>\n");

                if(union) {
                    out.println("        <input type=\"radio\" id=\"buttonYes\" name=\"union\" value=\"true\" checked=\"checked\">\n" +
                            "        <label for=\"buttonYes\">Ja</label>\n" +
                            "        <input type=\"radio\" id=\"buttonNo\" name=\"union\" value=\"false\">\n" +
                            "        <label for=\"buttonNo\">Nei</label>\n");
                }
                else {
                    out.println("        <input type=\"radio\" id=\"buttonYes\" name=\"union\" value=\"true\">\n" +
                            "        <label for=\"buttonYes\">Ja</label>\n" +
                            "        <input type=\"radio\" id=\"buttonNo\" name=\"union\" value=\"false\" checked=\"checked\">\n" +
                            "        <label for=\"buttonNo\">Nei</label>\n");
                }
                out.println("        <br>\n" +
                "        <label> Gjeld </label>\n" +
                "        <input type=\"text\" name = \"debt\" value = '" + debt + "'>\n" +
                "        <br>\n" +
                "        <label> Passord </label>\n" +
                "        <input type=\"text\" name = \"password\" value = '" + password + "'>\n" +
                "        <br>\n" +
                "        <button type=\"submit\" value='" + userID + "' name='userID'> Endre </button>\n" +
                "    </form>\n" +
                "    <form action=\"GetAllUserServlet\" method=\"get\">\n" +
                "        <button type=\"submit\">get all users</button>\n" +
                "    </form>\n");
    }

}
