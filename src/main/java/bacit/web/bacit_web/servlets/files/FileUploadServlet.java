//https://github.com/espenlimi/UiA-bacit-skeleton
package bacit.web.bacit_web.servlets.files;

import bacit.web.bacit_web.DAO.FileDAO;
import bacit.web.bacit_web.DAO.ToolDAO;
import bacit.web.bacit_web.models.FileModel;
import bacit.web.bacit_web.models.HtmlModel;
import bacit.web.bacit_web.servlets.SuperServlet;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.logging.Logger;


@WebServlet(name = "fileUpload", value = "/SiteAdmin/fileUpload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadServlet extends SuperServlet {

    Logger logger = Logger.getLogger(FileUploadServlet.class.getName());

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String tool_id = request.getParameter("tool_id");
        String image_id = null;

        out.println(HtmlModel.getHeader("upload file"));

        try{
            Part filePart = request.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();

            byte[] fileBytes = convertInputStreamToByteArray(fileContent);

            FileModel fileModel = new FileModel(
                    fileName,
                    fileBytes,
                    filePart.getContentType());

            FileDAO dao = new FileDAO();
            dao.persistFile(fileModel);
            dao.getImageIdFromName(fileName);
            addImage(tool_id, image_id);

            logger.info("Received file with name: " + fileModel.getName()+ "with the length of: "+fileModel.getContents().length+" bytes");
            out.println("takk for din opplastning");
        }
        catch(Exception ex)
        {
            logger.severe(ex.getMessage());
            outString.append("det skjedde noe feil vennligst gå tilbake og prøv igjen,\neller prøv igjen senere");
        }


        out.println(HtmlModel.getFooter());

    }

    private void addImage(String tool_id, String image_id){
        ToolDAO dao = new ToolDAO();
        dao.updateToolImage(tool_id, image_id);
    }

    private byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException{

        // Taking the InputStream data into a byte array
        // output stream

        // Buffer size taken to be 1000 say.
        byte[] buffer = new byte[1000];

        // Creating an object of ByteArrayOutputStream class
        ByteArrayOutputStream byteArrayOutputStream
                = new ByteArrayOutputStream();

        // Try block to check for exceptions

            int temp;

            while ((temp = inputStream.read(buffer))
                    != -1) {
                byteArrayOutputStream.write(buffer, 0,
                        temp);
            }

        // Mow converting byte array output stream to byte
        // array
        byte[] byteArray
                = byteArrayOutputStream.toByteArray();

        return byteArray;
    }
}
