package appPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDConnection
{
	static Connection con;
	static
	{
		String url = "jdbc:mysql://localhost:3306/ebill";
		String uname = "root";
		String pass = "prj123";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println("Driver Loaded Successfully");
		//System.out.println("Connection Loaded : "+con);
	}
}
