package utils;

import com.mysql.cj.protocol.x.ResultMessageListener;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {
    public static Connection getConnection(){
        //reading the config.prop to get the values we need
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        //set connection to null local var
        Connection connection=null;
        try {
            //allows use to create a connection
            //reads prop file to connect database using dburl, un, pw
            connection=DriverManager.getConnection(ConfigReader.getPropertyValue("dbUrl"),
                    ConfigReader.getPropertyValue("dbUserName"),
                    ConfigReader.getPropertyValue("dbPassword"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static ResultSet getResultSet(String query){
        Connection connection=getConnection();
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //executes our query
            statement=connection.createStatement();
            //provides result from the db
            resultSet=statement.executeQuery(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public static List<Map<String,String>> getTableDataAsList(String query){

        //executes query and stores in result set
        ResultSet resultSet=getResultSet(query);


        ResultSetMetaData resultSetMetaData=null;
        List<Map<String,String>> tableList=new ArrayList<>();
        Map<String,String> rowMap=null;
        try {
            //stores the data retrieved from sql query in result set meta data
            resultSetMetaData=resultSet.getMetaData();
            while(resultSet.next()){
                //a new map created per row
                rowMap=new HashMap<>();
                //loop starts at 1 bc header is skipped use <= bc skips header
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    //map putting key= header columns value= data
                    rowMap.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));
                }
                //each map is stored in list
                tableList.add(rowMap);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tableList;
    }
}
