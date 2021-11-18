package bacit.web.bacit_web.DAO;

import bacit.web.bacit_web.models.BookingModel;
import bacit.web.bacit_web.models.ToolModel;
import bacit.web.bacit_web.utilities.DBUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

public class ToolDAO {
    private Logger logger = Logger.getLogger(String.valueOf(ToolDAO.class));

    public String deliverTool(String tool_id){
        Connection db = null;
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "update tools set Tool_delivered = 1 where Tool_id = ?;";
            statement = db.prepareStatement(query);
            statement.setString(1, tool_id);
            statement.executeQuery();

            return "levering vellykket";
        } catch (ClassNotFoundException| SQLException e)  {
            logger.info("deliver tool: " + e.getMessage());
        }
        finally {
            closeConnections(db, null, statement);
        }
        return "error";
    }

    public ArrayList<ToolModel> getAllTools() {
        ArrayList<ToolModel> toolModels = null;
        ResultSet results = null;
        Connection db = null;
        PreparedStatement statement = null;

        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "select * from MytestDB.tools";
            statement = db.prepareStatement(query);
            results = statement.executeQuery();
            toolModels = ResultSetToToolModelArray(results);

        }
        catch (ClassNotFoundException|SQLException e) {
            logger.info("get tools: " + e.getMessage());
        }
        finally {

            closeConnections(db, results, statement);
        }
        return toolModels;
    }

    public ToolModel getToolById(String toolID){
        ToolModel tool = null;
        ResultSet results = null;
        Connection db = null;
        PreparedStatement statement = null;
        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "select * from MytestDB.tools where Tool_id = ?";
            statement = db.prepareStatement(query);
            statement.setString(1, toolID);
            results = statement.executeQuery();

            tool = ResultSetToToolModelArray(results).get(0);
        }
        catch (ClassNotFoundException|SQLException e) {
            logger.info("get tools: " + e.getMessage());
        }
        finally {
            closeConnections(db, results, statement);
        }
        return tool;
    }

    public ArrayList<Date> getDatesUnavailable(String toolID){
        ArrayList<Date> dateArrayList = new ArrayList<>();
        BookingDAO dao = new BookingDAO();
        ArrayList<BookingModel> bookings= dao.getBookingDatesFromToolID(toolID);

        for (int i = 0; i<bookings.size(); i++){
            String dateStart = bookings.get(i).getBooking_dateStart();
            String dateEnd = bookings.get(i).getBooking_dateEnd();
            ArrayList<Date> datesBetween = getDatesBetween(dateStart, dateEnd);
            addAllvaluesFromTo(datesBetween, dateArrayList);
        }

        return dateArrayList;

    }

    public boolean getQualification(String toolID){
        boolean qualification = false;
        ResultSet results = null;
        Connection db = null;
        PreparedStatement statement = null;
        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "select Tool_qualification from tools where Tool_id = ?;";
            statement = db.prepareStatement(query);
            statement.setString(1, toolID);
            results = statement.executeQuery();
            while(results.next()){
                qualification = results.getBoolean(1);
            }
        }
        catch (ClassNotFoundException|SQLException e) {
            logger.info("get tools: " + e.getMessage());
        }
        finally {
            closeConnections(db, results, statement);
        }
        return qualification;
    }

    public String getToolName(String tool_id){
        String name = null;
        ResultSet results = null;
        Connection db = null;
        PreparedStatement statement = null;
        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "select Tool_name from tools where Tool_id = ?;";
            statement = db.prepareStatement(query);
            statement.setString(1, tool_id);
            results = statement.executeQuery();
            while(results.next()){
                name = results.getString(1);
            }
        }
        catch (ClassNotFoundException|SQLException e) {
            logger.info("get tools: " + e.getMessage());
        }
        finally {
            closeConnections(db, results, statement);
        }
        return name;
    }

    private ArrayList<ToolModel> ResultSetToToolModelArray(ResultSet results){

        String Tool_id;
        String Tool_Name;
        String Tool_type;
        String Tool_condition;
        int Tool_price;
        int Tool_freeFirstDay;
        String Tool_importantInformation;
        String Tool_image;
        boolean Tool_delivered;

        ArrayList<ToolModel> toolModels = new ArrayList<>();

        try {
            while (results.next()) {
                Tool_id = results.getString(1);
                Tool_Name = results.getString(2);
                Tool_type = results.getString(3);
                Tool_condition = results.getString(4);
                Tool_price = results.getInt(5);
                Tool_freeFirstDay = results.getInt(7);
                Tool_importantInformation = results.getString(8);
                Tool_delivered = results.getBoolean(10);
                Tool_image = results.getString(11);


                ToolModel model = new ToolModel(Tool_id, Tool_Name, Tool_type, Tool_condition, Tool_price, Tool_freeFirstDay, Tool_importantInformation, Tool_image, Tool_delivered);
                toolModels.add(model);
            }
            return toolModels;
        }
        catch (SQLException e){
            logger.info("createToolModel" + e.getMessage());
        }
        return null;
    }

    private void closeConnections(Connection db, ResultSet results, PreparedStatement statement){

        if (db != null){try {db.close();}catch (Exception e){logger.info(e.getMessage());}}
        if(statement != null){ try{ statement.close(); } catch (Exception e){ logger.info(e.getMessage());}}
        if(results != null){ try{ results.close();} catch (Exception e){ logger.info(e.getMessage());}}

    }

    private void addAllvaluesFromTo(ArrayList<Date> arrayListFrom, ArrayList<Date> arrayListTo){
        for (int i = 0; i < arrayListFrom.size(); i++){
            arrayListTo.add(i, arrayListFrom.get(i));
        }
    }

    private ArrayList<Date> getDatesBetween(String startDate, String endDate){

        Date formattedDateStart = null;
        Date formattedDateEnd = null;

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formattedDateStart = formatter.parse(startDate);
            formattedDateEnd = formatter.parse(endDate);
        }
        catch (ParseException e){
            Logger logger = Logger.getLogger("HtmlModel");
            logger.info(e.getMessage());
        }
        ArrayList<Date> dateList = new ArrayList<>();

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(formattedDateStart);

        while (calendar.getTime().before(formattedDateEnd))
        {
            Date result = calendar.getTime();
            dateList.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        dateList.add(formattedDateEnd);

        return dateList;
    }
}
