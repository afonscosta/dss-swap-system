package main.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    
    private static final String URL = "localhost";
    private static final String TABLE = "SWAP";         //nome do schema da db
    private static final String PASSWORD = "password";
    private static final String USERNAME = "usertest";
    
    public static Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://"+URL+"/"
                    +TABLE+"?user="+USERNAME+"&password="+PASSWORD);
            return cn;
        } catch(Exception e){e.printStackTrace();}
        
        return null;
    }
    
    public static void close(Connection connection){
        try{
            connection.close();
        }catch(Exception e){e.printStackTrace();}
    }
}
