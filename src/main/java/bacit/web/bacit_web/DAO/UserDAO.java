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

        Connection db = DBUtils.getINSTANCE().getConnection();

        String query = "select User_id, User_fullName, User_email, User_password, User_address, User_Union, User_debt from user where User_phoneNumber = ?";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, userID);

        ResultSet results = statement.executeQuery();

        UserModel user = createUserModelFromResultSet(results, out);

        return user;
    }

    public ResultSet getAllUsers(){
        try {
            Connection db = DBUtils.getINSTANCE().getConnection();

            String query = "select * from user";
            PreparedStatement statement = db.prepareStatement(query);
            ResultSet results = statement.executeQuery();
            return results;
        }
        catch (SQLException|ClassNotFoundException e){
            logger.info("getAllUsers " + e.getMessage());
        }
        return null;
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

    public void deleteUser(int userID){
        try {
            Connection db = DBUtils.getINSTANCE().getConnection();

            String query = "delete from user where User_id = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, userID);
            statement.executeQuery();
            db.close();
        }
        catch (SQLException|ClassNotFoundException e){
            logger.info("deleteUser" + e.getMessage());
        }
    }

    public Boolean uploadNewUser(UserModel user){
        try {
            Connection db = DBUtils.getINSTANCE().getConnection();

            String query = "insert into user (User_fullName, User_email, User_phoneNumber, User_password, User_address, User_union, User_debt)values(?, ?, ?, sha2(?, 256), ?, ?, ?)";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhoneNumber());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getAddress());
            statement.setBoolean(6, user.getUnion());
            statement.setInt(7, user.getDebt());

            statement.executeQuery();

            db.close();

            return true;
        }
        catch (SQLException|ClassNotFoundException e){
            logger.info("deleteUser" + e.getMessage());
        }
        return false;
    }

    public String getUserIdFromPhone(String user_phone){
        try {
            Connection db = DBUtils.getINSTANCE().getConnection();

            String query = "select User_id from user where User_phoneNumber = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, user_phone);
            ResultSet results = statement.executeQuery();
            return getUserIDFromResultSet(results);
        }
        catch (SQLException|ClassNotFoundException e){
            logger.info("get user id" + e.getMessage());
        }
        return null;
    }

    public String getUserIDFromResultSet(ResultSet results){

        try{
            while (results.next()){
                return results.getString(1);
            }
        }
        catch (SQLException e){
            logger.info(e.getMessage());
        }

        return null;
    }

    public Boolean isAdmin(String phoneNumber){
        return false;
    }

}
