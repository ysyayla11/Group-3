package bacit.web.bacit_web.servlets.tools;

import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.DAO.UserDAO;
import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.models.ToolModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.attribute.UserPrincipal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

@WebServlet(name = "BookToolPageServlet", value = "/SiteUser/BookToolPageServlet")
public class BookToolPageServlet extends HttpServlet {

    StringBuffer outString = new StringBuffer();
    Logger logger = Logger.getLogger(String.valueOf(BookToolPageServlet.class));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        outString.delete(0, outString.length());

        String toolID = request.getParameter("Tool_id");
        String user_id = getUserId(request.getUserPrincipal().getName());

        outString.append(HtmlModel.getHeader("book verktøy"));
        addHtml(toolID, user_id);
        outString.append(HtmlModel.getFooter());

        out.println(outString);
    }

    public String getUserId(String phoneNumber){
        UserDAO dao = new UserDAO();
        return dao.getUserIdFromPhone(phoneNumber);
    }

    private void addHtml(String toolId, String userId){
        addToolInfo(toolId);
        addCalendar();
        addBookingForm(toolId, userId);
        addScript(toolId);
    }

    private void addToolInfo(String toolId){
        ToolDAO dao = new ToolDAO();
        ToolModel tool = dao.getToolById(toolId);

        outString.append("<h1>" + tool.getName() + "</h1>");
        if(!tool.getName().equals("null")) {
            outString.append("<h2>Viktig info:</h2>" + tool.getImportantInformation() + "<br>");
        }
    }

    public void addBookingForm(String toolId, String userId){

        outString.append("<h2>Book dette verktøyet</h2>" +
                "<form action=\"BookingServlet\" method=\"post\">\n" +
                "\n" +
                "    <input type=\"hidden\" name=\"Tool_id\" value = '" + toolId + "'> <br/>\n" +
                "\n" +
                "    <input type=\"hidden\" name=\"User_id\" value = '" + userId + "'> <br/>\n" +
                "\n" +
                "    <label>Startdato</label>\n" +
                "    <input type=\"date\" name=\"Booking_dateStart\" class=\"dateInput\" id=\"dateStartInput\" required> <br/> <br/>\n" +
                "\n" +
                "    <label>Sluttdato</label>\n" +
                "    <input type=\"date\" name=\"Booking_dateEnd\" class=\"dateInput\" id=\"dateEndInput\" required> <br/> <br/>\n" +
                "\n" +
                "    <label>Booking paid:</label> <br/>\n" +
                "    <label>Ja</label>\n" +
                "    <input type=\"radio\" name=\"Booking_paid\" value=\"true\"> <br/>\n" +
                "    <label>Nei</label>\n" +
                "    <input type=\"radio\" name=\"Booking_paid\" value=\"false\" checked> <br/>\n" +
                "\n" +
                "\n" +
                "    <a href=\"../index.jsp\"><button type=\"submit\" value=\"Register\" onclick=\"showMessage()\">Registrer</button> <br/></a>\n" +
                "</form>");


    }

    private void addScript(String toolID){

        ToolDAO dao = new ToolDAO();
        ArrayList<Date> dateArrayList =  dao.getDatesUnavailable(toolID);
        ArrayList<String> dateStringArrayList = new ArrayList<>();
        String pattern = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        for(int i = 0; i<dateArrayList.size(); i++){
            dateStringArrayList.add("\"" + dateFormat.format(dateArrayList.get(i))  + "\"");
        }

        outString.append("<script>\n" +
                "var input1 = document.getElementById(\"dateStartInput\");\n" +
                "    var input2 = document.getElementById(\"dateEndInput\")\n" +
                "\n" +
                "    input1.oninput = function checkDate(){\n" +
                "        var GivenDate = input1.value;\n" +
                "        var CurrentDate = new Date();\n" +
                "        GivenDate = new Date(GivenDate);\n" +
                "        CurrentDate.setHours(0,0,0,0);\n" +
                "        if(input2.value!=null){\n" +
                "            var endDate = input2.value;\n" +
                "            endDate = new Date(endDate);\n" +
                "            if(endDate<GivenDate){\n" +
                "                alert(\"Startdato kan ikke være etter sluttdato\");\n" +
                "                input1.value = null;\n" +
                "            }\n" +
                "        }\n" +
                "        if(input1.value < CurrentDate){\n" +
                "            alert(\"Denne datoen har passert\");\n" +
                "            input1.value = null;\n" +
                "        }\n" +
                "        for (let i = 0; i < busyDates.length; i++) {\n" +
                "            if (input1.value == busyDates[i]) {\n" +
                "                alertOverlappingBookings();\n" +
                "            }\n" +
                "        }\n" +
                "        if (input2.value != \"\") {\n" +
                "            checkDatesBetween(selectedDate, dateEndInput.value);\n" +
                "        }\n" +
                "    }\n" +
                "    input2.oninput = function checkOverLappingDate(){\n" +
                "        var startDate = input1.value;\n" +
                "        var endDate = input2.value;\n" +
                "        startDate = new Date(startDate);\n" +
                "        endDate = new Date(endDate);\n" +
                "        if (endDate < startDate){\n" +
                "            alert(\"Sluttdato må være samme dato som, eller etter startdatoen\");\n" +
                "            input2.value = null;\n" +
                "        }\n" +
                "       for (let i = 0; i < busyDates.length; i++) {\n" +
                "            if (input2.value == busyDates[i]) {\n" +
                "                alertOverlappingBookings();\n" +
                "            }\n" +
                "        }\n" +
                "        if(dateStartInput.value != \"\"){\n" +
                "            checkDatesBetween(dateStartInput.value, endDate);\n" +
                "        }" +
                "    }" +
                "\n headerMonth = document.getElementById(\"headerMonth\");\n" +
                "let selectedMonth = new Date();\n" +
                "\n" +
                "let nameOfMonthNO = selectedMonth.toLocaleString(\n" +
                "    'no-NO', {month: 'long'}\n" +
                ");\n" +
                "\n" +
                "weekDays = ['man', 'tir', 'ons', 'tor', 'fre', 'lør', 'søn'];\n" +
                "busyDates =" + dateStringArrayList + "\n" +
                "console.log(busyDates);"+
                "\n" +
                "headerMonth.innerHTML = nameOfMonthNO;\n" +
                "loadDates();\n" +
                "\n" +
                "function getFirstDate(){\n" +
                "    var firstDay = new Date(selectedMonth.getFullYear(), selectedMonth.getMonth(), 1);\n" +
                "    return firstDay;\n" +
                "}\n" +

                "\n" +
                "function getDayName(dateStr)\n" +
                "{\n" +
                "    var date = new Date(dateStr);\n" +
                "    return date.toLocaleDateString('en-EN', { weekday: 'long' });\n" +
                "}\n" +
                "\n" +
                "function initWeekDays(){\n" +
                "    weekDays = ['man', 'tir', 'ons', 'tor', 'fre', 'lør', 'søn'];\n" +
                "}\n" +
                "\n" +
                "function sortWeekDays(){\n" +
                "    initWeekDays()\n" +
                "    var day = getDayName(getFirstDate(selectedMonth.toString()));\n" +
                "    if(day == 'Monday'){\n" +
                "    }\n" +
                "    else if(day =='Tuesday'){\n" +
                "        pushArray(pushArray(1));\n" +
                "    }\n" +
                "    else if (day =='Wednesday'){\n" +
                "        pushArray(2);\n" +
                "\n" +
                "    }\n" +
                "    else if (day == 'Tuesday'){\n" +
                "        pushArray(3)\n" +
                "    }\n" +
                "    else if (day == \"Friday\"){\n" +
                "        pushArray(4);\n" +
                "\n" +
                "    }\n" +
                "    else if (day == \"Saturday\"){\n" +
                "        pushArray(5);\n" +
                "\n" +
                "    }\n" +
                "    else if (day == \"Sunday\"){\n" +
                "        pushArray(6);\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "function pushArray(times){\n" +
                "    for(var i = 0; i < times; i++){\n" +
                "        weekDays.push(weekDays.shift());\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "function daysInMonth (month, year) {\n" +
                "    date = new Date(year, month+1, 0);\n" +
                "    return date.getDate();\n" +
                "}\n" +
                "\n" +
                "function loadDates(){\n" +
                "    var maxDays = daysInMonth(selectedMonth.getMonth(), selectedMonth.getFullYear());\n" +
                "    var counter = 1;\n" +
                "    var counter2 = 1;\n" +
                "    var table = document.getElementById(\"calendarTable\");\n" +
                "    for (var i = 0, row; row = table.rows[i]; i++) {\n" +
                "\n" +
                "        for (var j = 0, col; col = row.cells[j]; j++) {\n" +
                "        col.classList.remove(\"next-month\");" +
                "            if(i==0){\n" +
                "                col.innerHTML = weekDays[j];\n" +
                "\n" +
                "            }\n" +
                "            else{\n" +
                "                if (counter <= maxDays) {\n" +
                "                    col.innerHTML = counter;\n" +
                "                    col.classList.remove(\"current-day\")\n" +
                "                       for(let k = 0; k <busyDates.length; k++){\n" +
                "                           var datenew = new Date(busyDates[k]);\n" +
                "                           if(selectedMonth.getMonth() == datenew.getMonth() && datenew.getDate()==counter){\n" +
                "                               col.classList.toggle(\"current-day\")" +
                "                           }\n" +
                "                       }"+
                "                    counter++;\n" +
                "                }\n" +
                "                else{\n" +
                "                    col.classList.toggle(\"next-month\")\n" +
                "                    col.innerHTML = counter2;\n" +
                "                    counter2++;\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "function checkDatesBetween(startDate, endDate){\n" +
                "        let datesBetween = getDatesBetween(startDate, endDate);\n" +
                "\n" +
                "        for (let i = 0; i < datesBetween.length; i++) {\n" +
                "            if (busyDates.includes(datesBetween[i].toISOString().split('T')[0])){\n" +
                "                alertOverlappingBookings();\n" +
                "                return;\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    function alertOverlappingBookings(){\n" +
                "        alert(\"Du har valgt en booking som strider med andre bookinger.\\nVennligst velg andre datoer.\");\n" +
                "        dateStartInput.value = null;\n" +
                "        dateEndInput.value = null;\n" +
                "    }\n" +
                "\n" +
                "    function getDatesBetween(startDate, endDate){\n" +
                "        let currentDay = new Date(startDate);\n" +
                "        endDate = new Date(endDate);\n" +
                "\n" +
                "        let datesBetween = [];\n" +
                "\n" +
                "        while(currentDay <= endDate){\n" +
                "            datesBetween.push(currentDay);\n" +
                "            currentDay = currentDay.addDays(1);\n" +
                "        }\n" +
                "        return datesBetween;\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    Date.prototype.addDays = function(days) {\n" +
                "        let date = new Date(this.valueOf());\n" +
                "        date.setDate(date.getDate() + days);\n" +
                "        return date;\n" +
                "    }" +
                "\n" +
                "document.getElementById(\"btn-next\").onclick = function (){\n" +
                "    let nextMonth = new Date(selectedMonth);\n" +
                "    nextMonth.setMonth(selectedMonth.getMonth() + 1);\n" +
                "    selectedMonth = nextMonth;\n" +
                "    let nameOfMonthNO = selectedMonth.toLocaleString(\n" +
                "        'no-NO', {month: 'long'}\n" +
                "    );\n" +
                "    headerMonth.innerHTML = nameOfMonthNO;\n" +
                "    sortWeekDays();\n" +
                "    loadDates();\n" +
                "}\n" +
                "\n" +
                "document.getElementById(\"btn-prev\").onclick = function (){\n" +
                "    let nextMonth = new Date(selectedMonth);\n" +
                "    nextMonth.setMonth(selectedMonth.getMonth() - 1);\n" +
                "    selectedMonth = nextMonth;\n" +
                "    let nameOfMonthNO = selectedMonth.toLocaleString(\n" +
                "        'no-NO', {month: 'long'}\n" +
                "    );\n" +
                "    headerMonth.innerHTML = nameOfMonthNO;\n" +
                "    sortWeekDays();\n" +
                "    loadDates();\n" +
                "}" +
                "</script>");
    }

    private void addCalendar(){
        outString.append("<p>" +
                "<div class=\"container\">\n" +
                "\n" +
                "    <div class=\"calendar\">\n" +
                "\n" +
                "        <header>\n" +
                "\n" +
                "            <h2 id=\"headerMonth\"></h2>\n" +
                "\n" +
                "            <button class=\"btn-prev fontawesome-angle-left\" id=\"btn-prev\">forrige måned</button>\n" +
                "            <button class=\"btn-next fontawesome-angle-right\" id=\"btn-next\">neste måned</button>\n" +
                "\n" +
                "        </header>\n" +
                "\n" +
                "        <table id=\"calendarTable\">\n" +
                "            <thead>\n" +
                "            <tr>\n" +
                "                <td>*</td>\n" +
                "                <td>*</td>\n" +
                "                <td>*</td>\n" +
                "                <td>*</td>\n" +
                "                <td>*</td>\n" +
                "                <td>*</td>\n" +
                "                <td>*</td>\n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "\n" +
                "            <tbody>\n" +
                "            <tr>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "                <td class=\"date\">*</td>\n" +
                "            </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</div>" +
                "</p>");
    }
}
