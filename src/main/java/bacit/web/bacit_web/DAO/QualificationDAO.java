package bacit.web.bacit_web.DAO;

import bacit.web.bacit_web.utilities.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class QualificationDAO extends AMVDatabaseDAO{
    private Logger logger = Logger.getLogger(String.valueOf(QualificationDAO.class));

    public boolean needsQualification(String tool_id){
        ToolDAO dao = new ToolDAO();
        return dao.getQualification(tool_id);
    }

    public boolean isQualified(String user_id, String tool_id){
        ArrayList<String> qualifications = new ArrayList<>();
        boolean qualified = false;
        ResultSet results = null;
        Connection db = null;
        PreparedStatement statement = null;
        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "select Tool_id from qualification where User_id = ?;";
            statement = db.prepareStatement(query);
            statement.setString(1, user_id);
            results = statement.executeQuery();
            while(results.next()){
                qualifications.add(results.getString(1));
            }
            if(qualifications.size() != 0) {
                for (int i = 0; i < qualifications.size(); i++) {
                    if (tool_id == qualifications.get(i)){
                        qualified = true;
                    }
                }
            }
        }
        catch (ClassNotFoundException| SQLException e) {
            logger.info("get tools: " + e.getMessage());
        }
        finally {
            closeConnections(db, results, statement);
        }
        return qualified;
    }

}
