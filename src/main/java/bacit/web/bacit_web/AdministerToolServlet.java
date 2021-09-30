package bacit.web.bacit_web;

import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "AdministerToolServlet", value = "/AdministerToolServlet")

public class AdministerToolServlet extends HttpServlet {
    private void getTool(String Tool_id, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        System.out.println("Hei");
    }

}
