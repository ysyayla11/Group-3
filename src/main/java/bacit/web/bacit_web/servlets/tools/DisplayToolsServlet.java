package bacit.web.bacit_web.servlets.tools;

import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.models.ToolModel;
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

@WebServlet(name = "DisplayToolsServlet", value = "/SiteUser/DisplayToolsServlet")
public class DisplayToolsServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(String.valueOf(DisplayToolsServlet.class));
    private StringBuffer outString = new StringBuffer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        outString.delete(0, outString.length());

        try {
            ArrayList<ToolModel> tools;
            tools = getTools();
            outString.append(HtmlModel.getHeader("verktøy til leie"));
            outString.append("<br><div>");
            outString.append("<input type=\"text\" id=\"myInput\" onkeyup=\"myFunction()\" placeholder=\"søk etter verktøy\">");
            printForm(tools);
            outString.append("</div>");
            outString.append(HtmlModel.getFooter());
            printScript();
        }
        catch (SQLException e) {
            logger.info(e.getMessage());
        }
        out.println(outString);
    }

    private ArrayList<ToolModel> getTools() throws SQLException {

        ToolDAO dao = new ToolDAO();

        ArrayList<ToolModel> tools = dao.getAllTools();
        return tools;
    }

    private void printForm(ArrayList<ToolModel> tools) {
        outString.append("<ul id = 'toolList'>");
        for (int i = 0; i<tools.size(); i++) {
            outString.append("<li><form action='../SiteUser/BookToolPageServlet' method='get'>\n" +
                    "    <div class='div'>" + tools.get(i).getName() + " </div>\n");
            addImage(tools.get(i).getImage());
            outString.append("<button type='submit' name='Tool_id' value = '" + tools.get(i).getId() + "' heigth=\"1vh\">Reserver dette verktøyet</button>" +
                    "    </form></li>");
        }
        outString.append("</ul>");
    }

    private void addImage(String image_id){
        if (image_id != null){
            outString.append("<img src=\"../fileDownload?file_id=" + image_id + "\"><br>");
        }
        else{
            outString.append("<img src=\"../Images/bildeMangler.png\" height=\"320px\"><br>");
        }
    }

    private void printScript(){
        outString.append("<script>\n" +
                "    function myFunction() {\n" +
                "        var input, filter, ul, li, name, i, nameTxtValue;\n" +
                "        input = document.getElementById(\"myInput\");\n" +
                "        filter = input.value.toUpperCase();\n" +
                "        ul = document.getElementById(\"toolList\");\n" +
                "        li = ul.getElementsByTagName(\"li\");\n" +
                "\n" +
                "        for (i = 0; i < li.length; i++) {\n" +
                "            name = li[i].getElementsByClassName(\"div\")[0];\n" +
                "            nameTxtValue = name.textContent || name.innerText;\n" +
                "            if (nameTxtValue.toUpperCase().indexOf(filter) > -1) {\n" +
                "                li[i].style.display = \"\";\n" +
                "            } else {\n" +
                "                li[i].style.display = \"none\";\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "</script>");
    }


}
