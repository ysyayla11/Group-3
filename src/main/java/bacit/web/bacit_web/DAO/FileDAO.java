//https://github.com/espenlimi/UiA-bacit-skeleton
package bacit.web.bacit_web.DAO;


import bacit.web.bacit_web.models.FileModel;
import bacit.web.bacit_web.utilities.DBUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FileDAO {

    public void persistFile(FileModel file) throws Exception{
        Connection db = DBUtils.getINSTANCE().getConnection();
        String query3 = "insert into files (File_name, File_contents, File_type) values(?,?,?)";

        PreparedStatement statement = db.prepareStatement(query3);
        statement.setString(1, file.getName());
        statement.setBlob(2,  new SerialBlob(file.getContents()));
        statement.setString(3, file.getContentType());
        statement.executeUpdate();
        db.close();
    }

    public FileModel getFile(int id) throws Exception
    {
        Connection db = DBUtils.getINSTANCE().getConnection();
        String query3 = "select File_name, File_contents, File_type from files where File_id = ?";
        PreparedStatement statement = db.prepareStatement(query3);
        statement.setInt(1, id);
        ResultSet rs =  statement.executeQuery();
        FileModel model = null;
        if (rs.next()) {
            model = new FileModel(
                    rs.getString("File_name"),
                    rs.getBytes("File_contents"),
                    rs.getString("File_type")
            );
        }
        db.close();
        rs.close();
        statement.close();
        return model;

    }
}