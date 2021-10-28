package bacit.web.bacit_web.servlets.tools;

import bacit.web.bacit_web.models.HtmlModel;
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

@WebServlet(name = "GetToolInfoServlet", value = "/GetToolInfoServlet")
public class GetToolInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");

        String toolID = request.getParameter("toolID");
        try {
            out.println(HtmlModel.getHeader("tool info"));
            printForm(out, getToolInfo(out, toolID));
            out.println(HtmlModel.getFooter());
        }
        catch (SQLException e){
            out.println(e);
        }

        out.println(toolID);

    }

    private ResultSet getToolInfo(PrintWriter out, String toolID) throws SQLException {
        //connection må endres til å bruke super
        Connection db = null;
        try{
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Error i connection");
        }

        String query = "select * from tools where Tool_id = ?";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, toolID);

        ResultSet results = statement.executeQuery();

        return results;
    }

    private void printForm(PrintWriter out, ResultSet results) throws SQLException{
        String toolName = "";
        String type = "";
        String condition = "";
        String price = "";
        //Boolean qualification = "";
        Boolean freeFirstDay = false;
        String importantInformation = "";
        String maxDays = "";
        String delivered = "";
        String image = "";

        String toolID = "";

        while(results.next()){
            toolName = results.getString(2);
            type = results.getString(3);
            condition = results.getString(4);
            price = results.getString(5);
            //qualification = results.getBoolean(6);
            freeFirstDay = results.getBoolean(7);
            importantInformation = results.getString(8);
            maxDays = results.getString(9);
            delivered = results.getString(10);
            image = results.getString(11);
            toolID = results.getString(1);

        }

        out.println(
                "    <form action=\"EditToolInfoServlet\" method=\"post\">\n" +
                "        <label> Verktøy navn </label>\n" +
                "        <input type=\"text\" name = \"toolName\" value='" + toolName + "'>\n" +
                "        <br>\n" +
                "        <label> Type </label>\n" +
                "        <input type=\"text\" name = \"type\" value = '" + type + "'>\n" +
                "        <br>\n" +
                "        <label> Hvilken stand er verktøy i? </label>\n" +
                "        <input type=\"text\" name = \"condition\" value='" + condition + "'>\n" +
                "        <br>\n" +
                "        <label> Pris </label>\n" +
                "        <input type=\"text\" name = \"price\" value = '" + price + "'>\n" +
                "        <br>\n" +
                "        <label> Er verktøyet gratis første dagen? </label>\n");

                if(freeFirstDay) {
                    out.println("        <input type=\"radio\" id=\"buttonYes\" name=\"freeFirstDay\" value=\"true\" checked=\"checked\">\n" +
                            "        <label for=\"buttonYes\">Ja</label>\n" +
                            "        <input type=\"radio\" id=\"buttonNo\" name=\"freeFirstDay\" value=\"false\">\n" +
                            "        <label for=\"buttonNo\">Nei</label>\n");
                }
                else {
                    out.println("        <input type=\"radio\" id=\"buttonYes\" name=\"freeFirstDay\" value=\"true\">\n" +
                            "        <label for=\"buttonYes\">Ja</label>\n" +
                            "        <input type=\"radio\" id=\"buttonNo\" name=\"freeFirstDay\" value=\"false\" checked=\"checked\">\n" +
                            "        <label for=\"buttonNo\">Nei</label>\n");
                }
                out.println("        <br>\n" +
                "        <label> Viktig informasjon om verktøyet </label>\n" +
                "        <input type=\"text\" name = \"importantInformation\" value = '" + importantInformation + "'>\n" +
                "        <br>\n" +
                "        <label> Maksimalt antall dager </label>\n" +
                "        <input type=\"text\" name = \"maxDays\" value = '" + maxDays + "'>\n" +
                "        <br>\n" +
                "        <button type=\"submit\" value='" + toolID + "' name='toolID'> Endre </button>\n" +
                "    </form>\n" +
                "    <form action=\"DeleteToolServlet\" method=\"get\">\n" +
                "        <button type=\"submit\">Slett verktøy</button>\n" +
                "    </form>\n" +
                "    <form action=\"GetAllToolServlet\" method=\"get\">\n" +
                "        <button type=\"submit\">get all tools</button>\n" +
                "    </form>\n");
    }

}
