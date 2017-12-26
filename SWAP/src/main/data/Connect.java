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
			if (System.getProperty("user.name").equals("rokai")) {
				String PASSWORD1 = "pass";
				String URL1 = "localhost";
				String TABLE1 = "SWAP";
				String USERNAME1 = "user";
				Class.forName("org.mariadb.jdbc.Driver");
				Connection cn = DriverManager.getConnection("jdbc:mariadb://"+URL1+"/"+TABLE1+"?user="+USERNAME1+"&password="+PASSWORD1);
				return cn;
			}
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
