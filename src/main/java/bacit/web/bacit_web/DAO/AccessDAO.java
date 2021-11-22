package bacit.web.bacit_web.DAO;

import bacit.web.bacit_web.utilities.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class AccessDAO extends AMVDatabaseDAO{
    Logger logger = Logger.getLogger(String.valueOf(AccessDAO.class));

    public void giveUserAccess(String phoneNumber){
        Connection db = null;
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();

            String query = "insert into access(User_phoneNumber, Access_level) values(?,'user')";
            statement = db.prepareStatement(query);
            statement.setString(1, phoneNumber);

            statement.executeQuery();
        }
        catch (SQLException |ClassNotFoundException e){
            logger.info("insert new access" + e.getMessage());
        }
        finally {
            closeConnections(db, null, statement);
        }
    }

    public void giveAdminAccess(String phoneNumber){
        Connection db = null;
        PreparedStatement statement = null;
            try {
                db = DBUtils.getINSTANCE().getConnection();

                String query = "insert into access(User_phoneNumber, Access_level) values(?,'administrator')";
                statement = db.prepareStatement(query);
                statement.setString(1, phoneNumber);

                statement.executeQuery();

            }
            catch (SQLException |ClassNotFoundException e){
                logger.info("insert new access" + e.getMessage());
            }
            finally {
                closeConnections(db, null, statement);
            }
        }

    public boolean IsAdmin(String phoneNumber){
        Connection db = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        boolean success = false;
        try {
            db = DBUtils.getINSTANCE().getConnection();

            String query = "select Access_level from access where User_phoneNumber = ? and Access_level = 'administrator'";
            statement = db.prepareStatement(query);
            statement.setString(1, phoneNumber);

            results = statement.executeQuery();
            while (results.next()){
                if (results.getBoolean(1)){
                    success = true;
                }
            }
        }
        catch (SQLException |ClassNotFoundException e){
            logger.info("insert new access" + e.getMessage());
        }
        finally {
            closeConnections(db, results, statement);
        }
        return success;
    }
}
