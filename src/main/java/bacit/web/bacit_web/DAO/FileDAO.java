//https://github.com/espenlimi/UiA-bacit-skeleton
        package bacit.web.bacit_web.DAO;


import bacit.web.bacit_web.models.ImageModel;
import bacit.web.bacit_web.utilities.DBUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FileDAO {

    public void persistFile(ImageModel file, PrintWriter out) throws Exception{
        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query3 = "insert into files (Name, Content, ContentType) values(?,?,?)";

        PreparedStatement statement = db.prepareStatement(query3);
        statement.setString(1, file.getName());
        statement.setBlob(2,  new SerialBlob(file.getContents()));
        statement.setString(3, file.getContentType());
        statement.executeUpdate();
        db.close();
    }

    public ImageModel getFile(int id, PrintWriter out) throws Exception
    {
        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query3 = "select Name, Content, ContentType from files where id = ?";
        PreparedStatement statement = db.prepareStatement(query3);
        statement.setInt(1, id);
        ResultSet rs =  statement.executeQuery();
        ImageModel model = null;
        if (rs.next()) {
            model = new ImageModel(
                    rs.getString("Name"),
                    rs.getBytes("Content"),
                    rs.getString("ContentType")
            );
        }
        db.close();
        return model;

    }
}
