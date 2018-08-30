package com.shoppingcart.DAO;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import com.shoppingcart.model.Customer;


public class LoginDAO {

	Connection con;
	
	public void loadDB() throws ClassNotFoundException, SQLException {	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=cochin;integratedSecurity=true;", "SYADAVELLI01", "Geethasrinu@19");
con = DriverManager.getConnection("jdbc:sqlserver://saicharan.database.windows.net:1433;database=cochin;user=cherry@saicharan;password=saicharan@19;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
	}
	
	public boolean CheckDB(Customer c){  
		boolean status=false; 
		
		try{  
		 loadDB();
		PreparedStatement ps=con.prepareStatement(  
		"select * from [dbo].[UserDetail] where userName=? and userPassword=?");  
		ps.setString(1,c.getName());  
		ps.setString(2,c.getPassword());  
		ResultSet rs=ps.executeQuery();
		status=rs.next();  
		          
		}catch(Exception e){
			System.out.println("Connection to database failed");
			System.out.println(e);
			}  
		return status;  
		}

 
	
	
	
	
	
}
