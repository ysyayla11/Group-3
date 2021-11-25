package bacit.web.bacit_web.servlets.tools;

import bacit.web.bacit_web.DAO.FileDAO;
import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.models.FileModel;
import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.models.ToolModel;
import bacit.web.bacit_web.servlets.SuperServlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "/uploadServlet", value = "/SiteAdmin/toolUploadServlet")
public class ToolUploadDBServlet extends SuperServlet {

    Logger logger = Logger.getLogger(String.valueOf(ToolUploadDBServlet.class));

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        outString.delete(0, outString.length());

        //get values of text fields
        String name = request.getParameter("Tool_name");
        String type = request.getParameter("Tool_type");
        String condition = request.getParameter("Tool_condition");

        int freeFirstDay;
        if(request.getParameter("Tool_freeFirstDay").equals("on")){
            freeFirstDay = 1;
        }
        else{
            freeFirstDay = 0;
        }
        int price = Integer.parseInt(request.getParameter("Tool_price"));
        String importantInfo = request.getParameter("Tool_importantInformation");

        ToolModel tool = createToolModel(name, type, condition, price, freeFirstDay, importantInfo, null);

        boolean success = addNewTool(tool);
        addHtml(success, tool.getId());

        out.println(outString);
    }

    public void addHtml(boolean success, String tool_id){
        outString.append(HtmlModel.getHeader("<br>Legge til bilde?"));
        if (success){
            outString.append("Vellykket opplastning, vil du legge til et bilde? <br><br>");
            addImageForm(tool_id);
            outString.append("<br><a href=\"AdminDashboard.jsp\"><button>Gå til dashboard</button></a>");
        }
        else {
            outString.append("Noe feil har skjedd, vennligst gå tilbake og prøv igjen,\nEller prøv igjen senere");
        }
        outString.append(HtmlModel.getFooter());
    }

    //String Tool_id, String Tool_Name, String Tool_type, String Tool_condition, int Tool_price, int Tool_freeFirstDay, String Tool_importantInformation, String Tool_image, Boolean Tool_delivered
    private ToolModel createToolModel(String name, String type, String condition, int price, int freeFirstDay, String importantInfo, String imageID){
        return new ToolModel("0", name, type, condition, price, freeFirstDay, importantInfo, imageID, true);
    }

    private boolean addNewTool(ToolModel tool){
        ToolDAO dao = new ToolDAO();
        return dao.uploadNewTool(tool);
    }

    private void addImageForm(String tool_id){
        outString.append("<form action='fileUpload' method='POST' enctype='multipart/form-data'>");
        outString.append("<label for='file'>Upload a file</label> ");
        outString.append("<input type='file' name='file' accept='.pdf, .png' required/>");
        outString.append("<input type =\"hidden\" value = \"" + tool_id + "\" name = \"tool_id\"");
        outString.append("<input type='submit' value='last opp bilde'/>");
        outString.append("</form>");
    }
}
