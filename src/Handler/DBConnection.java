package Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String host="localhost", user="root" ,password="root", port="3306",dbName="brilliantstudentmgmt";
	 
	public static Connection openConnection()
	{
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String mySqlURL="jdbc:mysql://"+host+":"+port+"/"+dbName;
			con=DriverManager.getConnection(mySqlURL,user,password);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String args[])
	{
		Connection con = DBConnection.openConnection();
		
		try {
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}