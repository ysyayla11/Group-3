package bacit.web.bacit_web.models;

public class HtmlModel {
    private static String headerPart1 = "\n" + "<html>\n" + "<head>\n" + "    <title>";

    private static String getHeaderPart2 = "</title>\n" +
            "    <link href=\"../styles.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
            "    <meta charset=\"UTF-8\">" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "<br>\n" +
            "\n" +
            "\n" +
            "<nav>\n" +
            "    <a class=\"active\" href=\"../SiteUser/home.jsp\">Hjemme</a>\n" +
            "    <a href=\"../index.jsp\">Log inn</a>\n" +
            "    <a href=\"../SiteUser/DinProfil.jsp\">Din Profil</a>\n" +
            "    <a href=\"../SiteUser/DineBestillinger.jsp\">Dine Bestillinger</a>\n" +
            "</nav>";

    private static String footer = "</body>\n" +
            "</html>";

    public static String getHeader(String title){
        return headerPart1 + title + getHeaderPart2;
    }

    public static String getFooter() {
        return footer;
    }
}
