package bacit.web.bacit_web.utilities;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBUtils {
    private static final DBUtils INSTANCE = new DBUtils();
    static Connection connection;

    Logger logger = Logger.getLogger(DBUtils.class.getName());

    /**
     * initiates the class as a singleton.
     *
     * @return DbTool
     */
    public static DBUtils getINSTANCE() {
        return INSTANCE;
    }


    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try{
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource)envCtx.lookup("jdbc/database");

            return ds.getConnection();
        }
        catch(NamingException ex)
        {
            logger.info("connect to db failed " + ex.getMessage());
        }
        return null;
    }
}


