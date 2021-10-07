package bacit.web.bacit_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="EksempelServlet", value="/eksempelServlet")
public class EksempelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<form action='eksempelServlet' method='post'>\n" +
                "    <input type=\"text\" placeholder=\"navn\" name=\"inputName\">\n" +
                "    <input type=\"text\" placeholder=\"nummer\" name=\"inputNumber\">\n" +
                "    <button type=\"submit\">submit</button>\n" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String name = request.getParameter("inputName");
        String number = request.getParameter("inputNumber");

        out.println("hei hei: " + name + " veldig godt å høre fra deg. om det er nor trøbbel skal vi ringe deg på" + number);

    }
}
