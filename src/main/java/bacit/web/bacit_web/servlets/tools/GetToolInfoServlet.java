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

@WebServlet(name = "GetToolInfoServlet", value = "/SiteAdmin/GetToolInfoServlet")
public class GetToolInfoServlet extends SuperServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        outString.delete(0, outString.length());

        String toolID = request.getParameter("toolID");
        ToolModel tool = getToolInfo(toolID);

        addHTML(tool);

        out.println(outString);

    }

    private ToolModel getToolInfo(String toolID){
        ToolDAO dao = new ToolDAO();
        return dao.getToolById(toolID);
    }

    private void addHTML(ToolModel tool){
        outString.append(HtmlModel.getHeader("tool info"));
        printForm(tool);
        addDeleteForm(tool.getId());
        addImageForm(tool.getId());
        addBackButton();
        addScript();
        outString.append(HtmlModel.getFooter());
    }

    private void printForm(ToolModel tool) {

        //oppdater form til å avspeile reel data som skal endres
        outString.append("<form action=\"../SiteAdmin/EditToolInfoServlet\" method=\"post\" id=\"editToolForm\">\n");
        addInputName(tool.getName());
        addSelectType(Integer.parseInt(tool.getType()));
        addInputCondition(tool.getCondition());
        addInputPrice(tool.getPrice());
        addInputFreeFirstDay(tool.getFreeFirstDay());
        addInputImportantInformation(tool.getImportantInformation());
        outString.append("<input type=\"hidden\" value='" + tool.getId() + "' name='toolID'>\n");
        outString.append("</form>\n");
        outString.append("<button onclick=\"confirmEditTool()\">Endre</button>");
    }

    private void addDeleteForm(String toolID){
        outString.append("<form action=\"DeleteToolServlet\" id=\"deleteToolForm\" method=\"get\">\n" +
                "<input type=\"hidden\" name = \"tool_id\" value=\"" + toolID + "\" >" +
                "</form>\n" +
                "<button onclick=\"confirmDeleteTool()\">slett</button>");
    }

    private void addBackButton(){
        outString.append("<form action=\"GetAllToolServlet\" method=\"get\">\n" +
                "        <button type=\"submit\">gå tilbake til alle verktøy</button></form>\n");
    }

    private void addInputName(String name){
        outString.append("        <label> Verktøy navn </label>\n" +
                "        <input type=\"text\" name = \"toolName\" value='" + name + "'>\n" +
                "        <br>\n");
    }

    private void addSelectType(int type){


        outString.append("          <label> Type </label>\n" +
                "                   <select name=\"type\">\n" +
                "                   <option value=\"1\"");
        checkType(type, 1);
        outString.append(">         Diverse småutstyr</option>\n");
        outString.append("          <option value=\"2\"");
        checkType(type, 2);
        outString.append(">         Spikerpistoler o.l.</option>\n" +
                "                   <option value=\"3\"");
        checkType(type, 3);
        outString.append(">         Utstyr for vedhogst</option>\n" +
                "                   <option value=\"4\"");
        checkType(type, 4);
        outString.append(">         Tilhengere</option>\n" +
                "                   <option value=\"5\"");
        checkType(type, 5);
        outString.append(">         Større Utstyr</option>\n" +
                "                   </select> <br>");
    }

    private void checkType(int type, int option){
        if (type == option){ outString.append("selected");}
    }

    private void addInputCondition(String condition){
        outString.append("<label> Hvilken stand er verktøy i? </label>\n" +
        "        <input type=\"text\" name = \"condition\" value='" + condition + "'><br>\n");
    }

    private void addInputPrice(int price){
        outString.append("<label> Pris </label>\n" +
                "        <input type=\"text\" name = \"price\" value = '" + price + "'><br>\n");
    }

    private void addInputFreeFirstDay(int freeFirstDay){
        outString.append("        <label> Er verktøyet gratis første dagen? </label>\n");

        if(freeFirstDay == 1) {
            outString.append("<input type=\"radio\" id=\"buttonYes\" name=\"freeFirstDay\" value=\"1\" checked=\"checked\">\n" +
                    "        <label for=\"buttonYes\">Ja</label>\n" +
                    "        <input type=\"radio\" id=\"buttonNo\" name=\"freeFirstDay\" value=\"0\">\n" +
                    "        <label for=\"buttonNo\">Nei</label><br>\n");
        }
        else {
            outString.append("<input type=\"radio\" id=\"buttonYes\" name=\"freeFirstDay\" value=\"1\">\n" +
                    "        <label for=\"buttonYes\">Ja</label>\n" +
                    "        <input type=\"radio\" id=\"buttonNo\" name=\"freeFirstDay\" value=\"0\" checked=\"checked\">\n" +
                    "        <label for=\"buttonNo\">Nei</label>\n");
        }
    }

    private void addInputImportantInformation(String importantInformation){
        outString.append("        <label> Viktig informasjon om verktøyet </label>\n" +
                "        <input type=\"text\" name = \"importantInformation\" value = '" + importantInformation + "'>\n" +
                "        <br>\n" +
                "        <br>\n");
    }

    private void addImageForm(String tool_id){
        outString.append("<form action='fileUpload' method='POST' enctype='multipart/form-data'>");
        outString.append("<label for='file'>Last opp et bilde</label> ");
        outString.append("<input type='file' name='file' accept='.pdf, .png' required/>");
        outString.append("<input type =\"hidden\" value = \"" + tool_id + "\" name = \"tool_id\">");
        outString.append("<input type='submit' value='last opp bilde'/>");
        outString.append("</form>");
    }

    private void addScript(){
        outString.append("<script>\n" +
                "\n" +
                "    var form = document.getElementById(\"deleteToolForm\")\n" +
                "\n" +
                "    function confirmDeleteTool() {\n" +
                "        if (confirm(\"Vil du slette dette verktøyet? Denne handlingen kan ikke angres.\")) {\n" +
                "            form.submit();\n" +
                "        }\n" +
                "        else {\n" +
                "            return\n" +
                "        }\n" +
                "    }\n" +
                "    var formEdit = document.getElementById(\"editToolForm\")\n" +
                "\n" +
                "    function confirmEditTool() {\n" +
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
