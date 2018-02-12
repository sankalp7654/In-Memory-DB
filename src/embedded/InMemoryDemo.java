package embedded;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

// H2 In-Memory Database Example shows about storing the database contents into memory.

public class InMemoryDemo {

    private static String url = "jdbc:h2:mem:student;DB_CLOSE_DELAY=-1";
    private static String username = "";
    private static String password = "";
    public static long createTime;
    

  /*  
    public static void main(String[] args) throws Exception {
        try {
        	createDatabase();
   //       insertWithStatement();
            insertIntoIMDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
    

   

   public static void createDatabase () throws ClassNotFoundException, SQLException, FileNotFoundException {
  		Class.forName("org.h2.Driver");	
	    Connection connection =  DriverManager.getConnection(url, username, password);
	    
  
    //start 
    long startCreateTime = System.nanoTime();

    String CreateDB = "CREATE TABLE user_details (user_id int(11) NOT NULL AUTO_INCREMENT, user_name varchar(255) DEFAULT NULL, first_name varchar(50) DEFAULT NULL, last_name varchar(50) DEFAULT NULL, gender varchar(10) DEFAULT NULL, password varchar(50) DEFAULT NULL, status tinyint(10) DEFAULT NULL, PRIMARY KEY (user_id) ) AUTO_INCREMENT=10001";        		
    		
    		
    // Insert Default Data using File InsertDefaultData.txt
    @SuppressWarnings("resource")
	String InsertDefaultData = new Scanner(new File("/Users/Sandeep/Documents/eclipse-workspace/inMemoryApp/InsertDefaultData.txt")).useDelimiter("\\A").next();
    		       
    			
    PreparedStatement createTable = connection.prepareStatement(CreateDB);		
    createTable.executeUpdate();
    PreparedStatement insertDataToDB = connection.prepareStatement(InsertDefaultData);
            
    System.out.println(insertDataToDB.executeUpdate());
    
    long endCreateTime = System.nanoTime();
    
    //time elapsed
    createTime = endCreateTime - startCreateTime;
  
    System.out.println("Elapsed time in milliseconds: " + createTime/1000000);
   connection.close();
    }
    
    public static void insertIntoIMDB() throws SQLException, FileNotFoundException, ClassNotFoundException {
  
        String InsertQuery = "INSERT INTO user_details" + "(user_id, user_name, first_name, last_name, gender, password, status) values" + "(?,?,?,?,?,?,?)";
        String SelectQuery = "select * from STUDENT";
        
          
        try {
            
        	Class.forName("org.h2.Driver");	
    	    Connection connection =  DriverManager.getConnection(url, username, password);
    	    connection.setAutoCommit(false);
            
            PreparedStatement insertPreparedStatement = null; 
            PreparedStatement selectPreparedStatement = null;

            insertPreparedStatement = connection.prepareStatement(InsertQuery);
            insertPreparedStatement.setInt(1, GUI.user_id);
            insertPreparedStatement.setString(2, GUI.user_name);
            insertPreparedStatement.setString(3, GUI.first_name);
            insertPreparedStatement.setString(4, GUI.last_name);
            insertPreparedStatement.setString(5, GUI.gender);
            insertPreparedStatement.setString(6, GUI.password);
            insertPreparedStatement.setInt(7, GUI.status);
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();
            
       
            selectPreparedStatement = connection.prepareStatement(SelectQuery);
            ResultSet rs = selectPreparedStatement.executeQuery();
            System.out.println("H2 In-Memory Database inserted through PreparedStatement");
            System.out.println("Id	" +  "Name	" + "Phone	" + "Email	");
            while (rs.next()) {
            System.out.println(rs.getInt("id") + "  "+ rs.getString("name") + "  "+ rs.getInt("phone") + "  " + rs.getString("email"));
            }
            
            
            connection.close();
            selectPreparedStatement.close();

            connection.commit();
        } catch (SQLException e) {
        	
        	 JOptionPane.showMessageDialog(null, "Unique Index Key or Primary Key Violation");;
        
         System.out.println("Exception Message " + e.getLocalizedMessage());
      
        } catch (Exception e) {
            e.printStackTrace();
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