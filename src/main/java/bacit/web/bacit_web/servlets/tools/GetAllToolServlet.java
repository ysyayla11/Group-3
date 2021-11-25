package bacit.web.bacit_web.servlets.tools;

import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.models.ToolModel;
import bacit.web.bacit_web.servlets.SuperServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GetAllToolServlet", value = "/SiteAdmin/GetAllToolServlet")
public class GetAllToolServlet extends SuperServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        outString.delete(0, outString.length());
        response.setCharacterEncoding("UTF-8");

        ArrayList<ToolModel> tools = getAllTools();
        addHtml(tools);
        out.println(outString);

    }

    public void addHtml(ArrayList<ToolModel> tools){
        tools = getAllTools();
        outString.append(HtmlModel.getHeader("all tools"));
        outString.append("<br><div>");
        addSearchField();
        addSearchScript();
        printForm(tools);
        outString.append("</div>");
        outString.append(HtmlModel.getFooter());
    }

    public ArrayList<ToolModel> getAllTools(){
        ToolDAO dao = new ToolDAO();
        return dao.getAllTools();
    }

    private void addSearchField(){
        outString.append("<input type=\"text\" id=\"myInput\" onkeyup=\"myFunction()\" placeholder=\"søk navn eller tlf...\">");//search through list of users
    }

    private void addSearchScript(){
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

    public void printForm(ArrayList<ToolModel> tools){

        outString.append("<ul id=\"toolList\">");
        for (int i = 0; i<tools.size(); i++) {
            outString.append("<li><form action='GetToolInfoServlet' method='get'>\n" +
                    "    <div class='div'>" + tools.get(i).getName() + "</div>\n" +
                    addImage(tools.get(i).getImage()) +
                    "    <button type=\"submit\" name='toolID' value='" + tools.get(i).getId() + "'>Rediger verktøy</button>\n" +
                    "</form></li>");
        }
        outString.append("</ul>");
    }

    private String addImage(String image_id){
        if (image_id != null){
            return "<img src=\"../fileDownload?file_id=" + image_id + "\"><br>";
        }
        else{
            return "<img src=\"../Images/bildeMangler.png\" height=\"320px\"><br>";
        }
    }
}