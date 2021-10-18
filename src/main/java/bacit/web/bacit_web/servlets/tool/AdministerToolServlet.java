package bacit.web.bacit_web.servlets.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdministerToolServlet", value = "/AdministerToolServlet")
public class AdministerToolServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        response.setContentType("text/html");

        //String Tool_name = request.getParameter("Tool_name");
        PrintWriter out = response.getWriter();
        //try {
            //ToolModel model = getTool(Tool_name, out);

            //request.setAttribute("Tool_name", model.getName());


            out.println("<html><body>");
            out.println("<p>test</p>");
            out.println("<form action='GetToolServlet' method='get' enctype='multipart/form-data'>");
            out.println("<label for='Tool_Name'>Navn på verktøy: </label>");
            out.println("</form>");
            out.println("</body></html>");
        /*} catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }



    public void destroy(){}

}
