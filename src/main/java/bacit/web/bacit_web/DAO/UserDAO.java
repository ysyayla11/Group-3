package bacit.web.bacit_web.DAO;

import bacit.web.bacit_web.models.UserModel;
import bacit.web.bacit_web.utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserDAO {

    Logger logger = Logger.getLogger(String.valueOf(UserDAO.class));

    public UserModel getUserInfo(PrintWriter out, String userID) throws SQLException, ClassNotFoundException{

        Connection db = DBUtils.getINSTANCE().getConnection(out);

        String query = "select * from user where User_phoneNumber = ?";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, userID);

        ResultSet results = statement.executeQuery();

        UserModel user = createUserModelFromResultSet(results, out);

        return user;
    }

    private UserModel createUserModelFromResultSet(ResultSet results, PrintWriter out) {
        String fullName = "";
        String email = "";
        String phoneNumber = "";
        Boolean union = false;
        String debt = "";
        String password = "";
        String address = "";
        String userID = "";

        try{
            while(results.next()){
                userID = results.getString(1);
                fullName = results.getString(2);
                email = results.getString(3);
                phoneNumber = results.getString(4);
                password = results.getString(5);
                address = results.getString(6);
                union = results.getBoolean(7);
                debt = results.getString(8);
            }
        }
        catch (SQLException e){
            out.println(e);
        }

        UserModel user = new UserModel(Integer.parseInt(userID), fullName, email,
                phoneNumber, password, address, union, Integer.parseInt(debt));

        return user;
    }

}
