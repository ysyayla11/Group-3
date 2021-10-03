package bacit.web.bacit_web;

public class HtmlModel {
    private static String headerPart1 = "\n" + "<html>\n" + "<head>\n" + "    <title>";

    private static String getHeaderPart2 = "</title>\n" +
            "    <link href=\"styles.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "<br>\n" +
            "\n" +
            "\n" +
            "<div class=\"topnav\">\n" +
            "    <a id=\"hjemme\" href=\"index.jsp\">Hjemme</a>\n" +
            "    <a id=\"Log\" href=\"Logg inn.jsp\">Log inn</a>\n" +
            "    <a id=\"Profil\" href=\"DinProfil.jsp\">Din Profil</a>\n" +
            "    <a id=\"Bestilling\" href=\"DineBestillinger.jsp\">Dine Bestillinger</a>\n" +
            "</div>";

    private static String footer = "</body>\n" +
            "</html>";

    public static String getHeader(String title){
        return headerPart1 + title + getHeaderPart2;
    }

    public static String getFooter() {
        return footer;
    }
}
