//https://github.com/espenlimi/UiA-bacit-skeleton
package bacit.web.bacit_web.servlets.files;

import bacit.web.bacit_web.DAO.FileDAO;
import bacit.web.bacit_web.models.FileModel;
import bacit.web.bacit_web.models.HtmlModel;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.logging.Logger;


@WebServlet(name = "fileUpload", value = "/fileUpload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadServlet extends HttpServlet {

    Logger logger = Logger.getLogger(FileUploadServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println(HtmlModel.getHeader("upload file"));
        writeFileUploadForm(out,null);
        out.println(HtmlModel.getFooter());
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
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

            logger.info("Received file with name: " + fileModel.getName()+ "with the length of: "+fileModel.getContents().length+" bytes");
        }
        catch(Exception ex)
        {
            logger.severe(ex.getMessage());
            writeFileUploadForm(out, ex.getMessage());
        }
        out.println(HtmlModel.getFooter());
    }

    private byte[] convertInputStreamToByteArray(InputStream inputStream){

        // Taking the InputStream data into a byte array
        // output stream

        // Buffer size taken to be 1000 say.
        byte[] buffer = new byte[1000];

        // Creating an object of ByteArrayOutputStream class
        ByteArrayOutputStream byteArrayOutputStream
                = new ByteArrayOutputStream();

        // Try block to check for exceptions
        try {
            int temp;

            while ((temp = inputStream.read(buffer))
                    != -1) {
                byteArrayOutputStream.write(buffer, 0,
                        temp);
            }
        }
        // Catch block to handle the exceptions
        catch (IOException e) {
            // Display the exception/s on the console
            System.out.println(e);
        }

        // Mow converting byte array output stream to byte
        // array
        byte[] byteArray
                = byteArrayOutputStream.toByteArray();

        return byteArray;
    }

    private void writeFileUploadForm(PrintWriter out, String errorMessage) {

        if(errorMessage!=null)
        {
            out.println("<h3>"+errorMessage+"</h3>");
        }
        out.println("<form action='fileUpload' method='POST' enctype='multipart/form-data'>");
        out.println("<label for='file'>Upload a file</label> ");
        out.println("<input type='file' name='file' accept='.pdf, .png' required/>");
        out.println("<input type='submit' value='Upload file'/>");
        out.println("</form>");
    }
}
