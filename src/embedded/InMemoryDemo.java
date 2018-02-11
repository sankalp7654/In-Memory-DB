package embedded;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

// H2 In-Memory Database Example shows about storing the database contents into memory.

public class InMemoryDemo {

    private static String url = "jdbc:h2:mem:student;DB_CLOSE_DELAY=-1";
    private static String username = "";
    private static String password = "";
    public static long createTime;
    

    
    public static void main(String[] args) throws Exception {
        try {
     //       insertWithStatement();
            insertIntoIMDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoIMDB() throws SQLException, FileNotFoundException, ClassNotFoundException {
      
    		Class.forName("org.h2.Driver");	
    	    Connection connection =  DriverManager.getConnection(url, username, password);
    	    
        PreparedStatement createPreparedStatement = null; 
        PreparedStatement insertPreparedStatement = null; 
        PreparedStatement selectPreparedStatement = null;

        //start 
        long startCreateTime = System.nanoTime();

        String CreateDB = "CREATE TABLE user_details (   user_id int(11) NOT NULL AUTO_INCREMENT,   username varchar(255) DEFAULT NULL,   first_name varchar(50) DEFAULT NULL,   last_name varchar(50) DEFAULT NULL,   gender varchar(10) DEFAULT NULL,   password varchar(50) DEFAULT NULL,   status tinyint(10) DEFAULT NULL,   PRIMARY KEY (user_id) ) AUTO_INCREMENT=10001";        		
        		
        		
        // Insert Default Data using File InsertDefaultData.txt
        @SuppressWarnings("resource")
		String InsertDefaultData = new Scanner(new File("/Users/Sandeep/Documents/eclipse-workspace/inMemoryApp/InsertDefaultData.txt")).useDelimiter("\\A").next();
        		       
        			
        PreparedStatement createTable = connection.prepareStatement(CreateDB);		
        createTable.executeUpdate();
        PreparedStatement insertDataToDB = connection.prepareStatement(InsertDefaultData);
                
        System.out.println( insertDataToDB.executeUpdate());
        
        long endCreateTime = System.nanoTime();
        
        //time elapsed
        createTime = endCreateTime - startCreateTime;
      
        System.out.println("Elapsed time in milliseconds: " + createTime/1000000);
       
        
        
        String InsertQuery = "INSERT INTO STUDENT" + "(id, name, phone, email) values" + "(?,?,?,?)";
        String SelectQuery = "select * from STUDENT";
        
          
        try {
            connection.setAutoCommit(false);
            
            // Runs for the first Time when user clicks "Insert into IMDB"
             if(GUI.createDb == 1) {
            	    createPreparedStatement = connection.prepareStatement(CreateDB);
                createPreparedStatement.executeUpdate();
                createPreparedStatement.close();
            }
    
            insertPreparedStatement = connection.prepareStatement(InsertQuery);
            insertPreparedStatement.setInt(1, GUI.id);
            insertPreparedStatement.setString(2, GUI.name);
            insertPreparedStatement.setInt(3, GUI.phone);
            insertPreparedStatement.setString(4, GUI.email);
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();
            
       
            selectPreparedStatement = connection.prepareStatement(SelectQuery);
            ResultSet rs = selectPreparedStatement.executeQuery();
            System.out.println("H2 In-Memory Database inserted through PreparedStatement");
            System.out.println("Id	" +  "Name	" + "Phone	" + "Email	");
            while (rs.next()) {
            System.out.println(rs.getInt("id") + "  "+ rs.getString("name") + "  "+ rs.getInt("phone") + "  " + rs.getString("email"));
            }
            
            
            selectPreparedStatement.close();

            connection.commit();
        } catch (SQLException e) {
        	
        	 JOptionPane.showMessageDialog(null, "Unique Index Key or Primary Key Violation");;
        
         System.out.println("Exception Message " + e.getLocalizedMessage());
      
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    /*
     public static void search() throws SQLException {

    	     Connection connection = getDBConnection();
         PreparedStatement searchPreparedStatement = null;
         String SearchQuery = "select * from STUDENT where id = ? ";
     	 searchPreparedStatement = connection.prepareStatement(SearchQuery);
     	 searchPreparedStatement.setInt(1, GUI.search);
     	 
         ResultSet rs = searchPreparedStatement.executeQuery();
         Boolean found = false;
         while (rs.next()) {
        	 	if(rs.getInt("id") == GUI.search) {
        	 		
        	 		System.out.println(rs.getInt("id") + "  "+ rs.getString("name") + "  "+ rs.getInt("phone") + "  " + rs.getString("email"));
        	 		found = true;
        	 	}	

           }
         
         if(found == false) {
        		JOptionPane.showMessageDialog(null, "Data Not Found !");
           	 
         }
         searchPreparedStatement.close();
         connection.close();

    }
  */ 
 
}