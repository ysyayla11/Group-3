package bacit.web.bacit_web.servlets.users;

import bacit.web.bacit_web.DAO.UserDAO;
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
import java.util.ArrayList;
import java.util.logging.Logger;

@WebServlet(name = "GetAllUsersServlet", value = "/SiteAdmin/GetAllUserServlet")
public class GetAllUsersServlet extends SuperServlet {

    Logger logger = Logger.getLogger(String.valueOf(GetAllUsersServlet.class));
    StringBuffer outString = new StringBuffer();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        outString.delete(0, outString.length());
        ArrayList<UserModel> users;

        users = getAllUsers();
        printHtml(users, out);
        out.println(outString);

    }

    private void printHtml(ArrayList<UserModel> users, PrintWriter out){
        outString.append(HtmlModel.getHeader("all users"));
        outString.append("<br><div>");
        outString.append("<input type=\"text\" id=\"myInput\" onkeyup=\"myFunction()\" placeholder=\"søk navn eller tlf...\">");//search through list of users
        printForm(users);
        outString.append("</div>");
        printScript();
        outString.append(HtmlModel.getFooter());
    }

    public ArrayList<UserModel> getAllUsers() {
        UserDAO dao = new UserDAO();
        return dao.getAllUsers();
    }

    private void printForm(ArrayList<UserModel> users){

        outString.append("<ul id=\"myUL\">");
        for (int i = 0; i < users.size(); i++) {
            outString.append("<li><form action='GetUserInfoServlet' method='get'>\n" +
                    "    <div>" + users.get(i).getFullName() + "</div>\n" +//navn
                    "    <div>tlf: " + users.get(i).getPhoneNumber() + "</div>\n" +//nummer
                    "    <button type=\"submit\" name='userID' value='" + users.get(i).getId() + "'>Rediger bruker</button>\n" +//input har value id til brukeren
                    "    <a href='" + /*TODO: add URL to administerbooking*/ "'><button>administrer bookinger</button></a>\n" +//input har value id til brukeren
                    "</form></li>");
        }
        outString.append("</ul>");
    }

    //prints a javascript to search through the list of users and display the results
    private void printScript(){
        outString.append("<script>\n" +
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