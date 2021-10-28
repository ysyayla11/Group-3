package bacit.web.bacit_web.servlets.users;

import bacit.web.bacit_web.models.HtmlModel;
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

@WebServlet(name = "GetAllUsersServlet", value = "/SiteAdmin/GetAllUserServlet")
public class GetAllUsersServlet extends SuperServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        ResultSet results;

        try {

            results = getAllUsers(out);
            printHtml(results, out);
        }
        catch (SQLException e){
            out.println(e);
        }
    }

    private void printHtml(ResultSet results, PrintWriter out){
        out.println(HtmlModel.getHeader("all users"));
        out.println("<br><div>");
        out.println("<input type=\"text\" id=\"myInput\" onkeyup=\"myFunction()\" placeholder=\"søk navn eller tlf...\">");//search through list of users
        printForm(results, out);
        out.println("</div>");
        printScript(out);
        out.println(HtmlModel.getFooter());
    }

    public ResultSet getAllUsers(PrintWriter out)
            throws SQLException{

        Connection db = super.connectToDB(out);

        String query = "select * from user";
        PreparedStatement statement = db.prepareStatement(query);
        ResultSet results = statement.executeQuery();
        return results;
    }

    private void printForm(ResultSet results, PrintWriter out){

        try {
            //making list of all users in the database
            out.println("<ul id=\"myUL\">");
            while (results.next()) {
                out.println("<li><form action='GetUserInfoServlet' method='get'>\n" +
                        "    <div>" + results.getString(2) + "</div>\n" +//navn
                        "    <div>tlf: " + results.getString(4) + "</div>\n" +//nummer
                        "    <button type=\"submit\" name='userID' value='" + results.getString(1) + "'>Rediger bruker</button>\n" +//input har value
                        "</form></li>");
            }
            out.println("</ul>");
        }
        catch (SQLException e){
            out.println(e);
        }
    }

    //prints a javascript to search through the list of users and display the results
    private void printScript(PrintWriter out){
        out.println("<script>\n" +
                "    function myFunction() {\n" +
                "        var input, filter, ul, li, name, number, i, nameTxtValue, numberTxtValue;\n" +
                "        input = document.getElementById(\"myInput\");\n" +
                "        filter = input.value.toUpperCase();\n" +
                "        ul = document.getElementById(\"myUL\");\n" +
                "        li = ul.getElementsByTagName(\"li\");\n" +
                "\n" +
                "        for (i = 0; i < li.length; i++) {\n" +
                "            name = li[i].getElementsByTagName(\"div\")[0];\n" +
                "            number = li[i].getElementsByTagName(\"div\")[1];\n" +
                "            nameTxtValue = name.textContent || name.innerText;\n" +
                "            numberTxtValue = number.textContent || number.innerText;\n" +
                "            if (nameTxtValue.toUpperCase().indexOf(filter) > -1 || numberTxtValue.toUpperCase().indexOf(filter) > -1) {\n" +
                "                li[i].style.display = \"\";\n" +
                "            } else {\n" +
                "                li[i].style.display = \"none\";\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "</script>");
    }
}