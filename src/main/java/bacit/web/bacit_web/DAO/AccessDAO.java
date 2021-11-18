package bacit.web.bacit_web.DAO;

import bacit.web.bacit_web.utilities.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class AccessDAO {
    Logger logger = Logger.getLogger(String.valueOf(AccessDAO.class));

    public void giveUserAccess(String phoneNumber){
        try {
            Connection db = DBUtils.getINSTANCE().getConnection();

            String query = "insert into access(User_phoneNumber, Access_level) values(?,'user')";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, phoneNumber);

            statement.executeQuery();

        }
        catch (SQLException |ClassNotFoundException e){
            logger.info("insert new access" + e.getMessage());
        }
    }

    public void giveAdminAccess(String phoneNumber){
            try {
                Connection db = DBUtils.getINSTANCE().getConnection();

                String query = "insert into access(User_phoneNumber, Access_level) values(?,'administrator')";
                PreparedStatement statement = db.prepareStatement(query);
                statement.setString(1, phoneNumber);

                statement.executeQuery();

            }
            catch (SQLException |ClassNotFoundException e){
                logger.info("insert new access" + e.getMessage());
            }

        }
}
