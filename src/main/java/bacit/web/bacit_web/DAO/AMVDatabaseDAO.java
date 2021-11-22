package bacit.web.bacit_web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

public class AMVDatabaseDAO {

    Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    public void closeConnections(Connection db, ResultSet results, PreparedStatement statement){

        if (db != null){try {db.close();}catch (Exception e){logger.info(e.getMessage());}}
        if(statement != null){ try{ statement.close(); } catch (Exception e){ logger.info(e.getMessage());}}
        if(results != null){ try{ results.close();} catch (Exception e){ logger.info(e.getMessage());}}

    }
}
