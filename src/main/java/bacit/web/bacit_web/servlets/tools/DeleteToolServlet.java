package bacit.web.bacit_web.servlets.tools;



import bacit.web.bacit_web.utilities.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DeleteToolServlet", value = "/DeleteToolServlet")
public class DeleteToolServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        Connection db = null;
        PrintWriter out = null;
        try{
            db = DBUtils.getINSTANCE().getConnection(out);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println("Error i connection");
        }
        try{
            //Henter og oppdaterer fra db
            String query = "UPDATE tools SET Tool_name = 'nytt' Where Tool_id = ?";
            PreparedStatement preparedStatement = db.prepareStatement(query);
            int i = preparedStatement.executeUpdate();
            if(i!=0){
                printWriter.println("Deleting row ");

            }
            else if(i==0){
                printWriter.println("<br>Row has been deleted succesfully."+
                        "    <form action=\"GetAllToolServlet\" method=\"get\">\n" +
                        "        <button type=\"submit\">get all tools</button>\n" +
                        "    </form>\n");
            }
        }
        catch (SQLException sqlException){
            printWriter.println(sqlException);
        }
    }
    private Connection getDBConnection(PrintWriter out){
        Connection db = null;
        try{
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println("Error i connection");
        }
        return db;
    }
}
