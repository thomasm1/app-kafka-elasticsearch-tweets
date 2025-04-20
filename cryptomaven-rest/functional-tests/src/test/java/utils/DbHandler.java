package helpers;

import net.minidev.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbHandler {

    private static String connectionUrl = "jdbc:sqlserver://localhost:14330;database=Pubs;user=dailytech;password=abc123!!";

    public static void addNewJobWithName(String jobName){
        try(Connection connect = DriverManager.getConnection(connectionUrl)){
            connect.createStatement().execute("INSERT INTO [Pubs].[dbo].[jobs] (job_desc, min_lvl, max_lvl) VALUES ('"+jobName+"', 80, 120)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getMinAndMaxLevelsForJob(String jobName){
        JSONObject json = new JSONObject();

        try(Connection connect = DriverManager.getConnection(connectionUrl)){
            ResultSet rs = connect.createStatement().executeQuery("SELECT * FROM [Pubs].[dbo].[jobs] where job_desc = '"+jobName+"'");
            rs.next();
            json.put("minLvl", rs.getString("min_lvl"));
            json.put("maxLvl", rs.getString("max_lvl"));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return json;
    }
    
}
