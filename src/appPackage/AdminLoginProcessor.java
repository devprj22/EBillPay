package appPackage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginProcessor 
{
	private PreparedStatement m_preparedStatement = null;
	private final static String query = "select * from admindata where id = ? and password = ?";
	private String m_adminId, m_adminPassword, m_adminName;
	
	public AdminLoginProcessor(String adminId, String adminPassword) 
	{	
		this.m_adminId = adminId;
		this.m_adminPassword = adminPassword;
		
		try 
		{
			m_preparedStatement = MyDConnection.con.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public boolean IsValidAdmin()
	{
		boolean fSuccess = IsLoginCredentialValid(ExecuteQuery());		
		return fSuccess;
	}
	
	public String GetAdminId()
	{
		return m_adminId;
	}
	
	public String GetAdminPassword()
	{
		return m_adminPassword;
	}
	
	public String GetAdminName()
	{
		return m_adminName;
	}
	
	private boolean IsLoginCredentialValid(ResultSet resultSet)
	{
		boolean isLoginCredentailValid = false;
		
		String resultAdminId = "", resultAdminPassword ="", resultAdminName ="";
		
		try 
		{
			while (resultSet.next())
			{
				resultAdminId = resultSet.getString(1);
				resultAdminPassword = resultSet.getString(5);
				resultAdminName = resultSet.getString(2);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		isLoginCredentailValid =	m_adminId.equals(resultAdminId)
								&&	m_adminPassword.equals(resultAdminPassword);
		
		
		m_adminName = resultAdminName;
		
		return isLoginCredentailValid;
	}
	
	private ResultSet ExecuteQuery()
	{
		ResultSet resultSet = null;
		
		try 
		{
			m_preparedStatement.setString(1, m_adminId);
			m_preparedStatement.setString(2, m_adminPassword);
			
			resultSet = m_preparedStatement.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return resultSet;
	}
}
