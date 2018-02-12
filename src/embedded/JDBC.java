package embedded;

import java.sql.*;

import javax.swing.JOptionPane;

public class JDBC
{
   
	public static long output;
	 
	public static  String url="jdbc:mysql://localhost:3306/STUDENT";
    public static  String username="root";
    public static  String password="root";
       
     
	
	public static void insertIntoFileSystem() {
      
        String InsertQuery = "INSERT INTO STUDENT" + "(id, name, phone, email) values" + "(?,?,?,?)";
     
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
      
        PreparedStatement insertPreparedStatement = null; 
        
        
        //start 
        long lStartTime = System.nanoTime();

        insertPreparedStatement = connection.prepareStatement(InsertQuery);
       insertPreparedStatement.executeUpdate();
        insertPreparedStatement.close();
        
        //end
        long lEndTime = System.nanoTime();
        
        //time elapsed
        output = lEndTime - lStartTime;
      
        System.out.println("Elapsed time in milliseconds: " + output / 1000000);

        
        connection.close();
        }
     
        
       
        catch (Exception e)
        {
            System.out.println("Error: "+e);
            JOptionPane.showMessageDialog(null, "Unique Index Key or Primary Key Violation");;
            
        }
    }   
	
	public static void search() throws SQLException {
        

		Connection connection = DriverManager.getConnection(url, username, password);
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
	
}