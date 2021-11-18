package bacit.web.bacit_web.servlets.files;

import bacit.web.bacit_web.DAO.FileDAO;
import bacit.web.bacit_web.models.FileModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

@WebServlet(name = "fileDownload", value = "/fileDownload")
public class FileDownloadServlet extends HttpServlet {

    Logger logger = Logger.getLogger(String.valueOf(FileUploadServlet.class));

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String stringId = request.getParameter("file_id");
        int id = Integer.parseInt(stringId);
        try{
            FileModel fileModel =  getFile(id);
            writeFileResult(response, fileModel);
        }
        catch(Exception ex)
        {
            logger.severe("getMethod "+ ex.getMessage());
        }
    }

    protected FileModel getFile(int id) throws Exception
    {
        return new FileDAO().getFile(id);
    }

    protected String getQueryStringParameter(HttpServletRequest request, String parameter)
    {
        return request.getParameter("id");
    }

    protected void writeFileResult(HttpServletResponse response, FileModel model) throws IOException
    {
        response.setContentType(model.getContentType());
        response.setHeader("Content-Disposition", "attachment; filename="+model.getName());
        OutputStream outStream = response.getOutputStream();
        outStream.write(model.getContents());
    }
}
