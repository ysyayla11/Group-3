package bacit.web.bacit_web.DAO;

import bacit.web.bacit_web.models.UserModel;
import bacit.web.bacit_web.utilities.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class UserDAO extends AMVDatabaseDAO{

    Logger logger = Logger.getLogger(String.valueOf(UserDAO.class));

    public UserModel getUserFromPhoneNumber(String userPhoneNumber){

        UserModel user = null;
        Connection db = null;
        String query;
        PreparedStatement statement = null;
        ResultSet results = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();

            query = "select User_id, User_fullName, User_email, User_phoneNumber, User_password, User_address, User_Union, User_debt from user where User_phoneNumber = ?";
            statement = db.prepareStatement(query);
            statement.setString(1, userPhoneNumber);

            results = statement.executeQuery();

            user = resultsetToUserModelArrayList(results).get(0);
        }
        catch (SQLException | ClassNotFoundException e) {
            logger.info("getUserInfo: " + e);
        }
        finally {
            super.closeConnections(db, results, statement);
        }
        return user;
    }

    public ArrayList<UserModel> getAllUsers(){

        ArrayList<UserModel> users = null;
        Connection db = null;
        String query;
        PreparedStatement statement = null;
        ResultSet results = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();

            query = "select User_id, User_fullName, User_email, User_phoneNumber, User_password, User_address, User_union, User_debt from user;";
            statement = db.prepareStatement(query);
            results = statement.executeQuery();
            users = resultsetToUserModelArrayList(results);

        }
        catch (SQLException|ClassNotFoundException e){
            logger.info("getAllUsers " + e.getMessage());
        }
        finally {
            closeConnections(db, results, statement);
        }
        logger.info(users.toString());
        logger.info(users.toString());
        return users;
    }

    public boolean updateUserDebt(String user_id, int amount){
        Connection db = null;
        PreparedStatement statement = null;
        boolean success = false;
        try {
            db = DBUtils.getINSTANCE().getConnection();

            String query = "update user set User_debt = (select User_debt from user where User_id = ?) + ? where User_id = ?";
            statement = db.prepareStatement(query);
            statement.setString(1, user_id);
            statement.setInt(2, amount);
            statement.setString(3, user_id);
            statement.executeQuery();
            success = true;
        }
        catch (ClassNotFoundException | SQLException e){
            logger.info("addBooking " + e.getMessage());
        }
        finally {
            closeConnections(db, null, statement);
        }
        return success;
    }

    public void deleteUser(int userID){
        try {
            Connection db = DBUtils.getINSTANCE().getConnection();

            String query = "delete from user where User_id = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, userID);
            statement.executeQuery();
            db.close();
            statement.close();
        }
        catch (SQLException|ClassNotFoundException e){
            logger.info("deleteUser" + e.getMessage());
        }
    }

    public Boolean uploadNewUser(UserModel user){
        Connection db = null;
        PreparedStatement statement = null;
        String query;
        boolean success = false;
        try {
            db = DBUtils.getINSTANCE().getConnection();

            query = "insert into user (User_fullName, User_email, User_phoneNumber, User_password, User_address, User_union, User_debt)values(?, ?, ?, sha2(?, 256), ?, ?, ?)";
            statement = db.prepareStatement(query);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhoneNumber());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getAddress());
            statement.setBoolean(6, user.getUnion());
            statement.setInt(7, user.getDebt());

            statement.executeQuery();

            success = true;
        }
        catch (SQLException|ClassNotFoundException e){
            logger.info("deleteUser" + e.getMessage());
        }
        finally {
            super.closeConnections(db, null, statement);
        }
        return success;
    }

    public String getUserIdFromPhone(String user_phone){
        Connection db = null;
        PreparedStatement statement = null;
        String query;
        try {
            db = DBUtils.getINSTANCE().getConnection();

            query = "select User_id from user where User_phoneNumber = ?";
            statement = db.prepareStatement(query);
            statement.setString(1, user_phone);
            ResultSet results = statement.executeQuery();
            return getUserIDFromResultSet(results);
        }
        catch (SQLException|ClassNotFoundException e){
            logger.info("get user id" + e.getMessage());
        }
        finally {
            closeConnections(db, null, statement);
        }
        return null;
    }

    private String getUserIDFromResultSet(ResultSet results){

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

    private ArrayList<UserModel> resultsetToUserModelArrayList(ResultSet results){
        ArrayList<UserModel> users = new ArrayList<>();
        int id;
        String fullName;
        String email;
        String phoneNumber;
        String password;
        String address;
        boolean union;
        int debt;

        try {
            while (results.next()) {
                id = results.getInt(1);
                fullName = results.getString(2);
                email = results.getString(3);
                phoneNumber = results.getString(4);
                password = results.getString(5);
                address = results.getString(6);
                union = results.getBoolean(7);
                debt = results.getInt(8);
                users.add(new UserModel(id, fullName, email, phoneNumber, password, address, union, debt));
            }
        }
        catch(SQLException e){
            logger.info(e.getMessage());
        }

        return users;
    }



}
