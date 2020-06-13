package appPackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//This is the common page used by both admin and customer to view their respective profile details
//It calls the CommonProfileView.java JFrame to show the data 

public class ViewProfile extends JPanel
{
	JLabel l1;
	JButton b1;
	
	ViewProfile(String oldpass, String uid , String type)
	{
		setLayout(new FlowLayout());
		l1 = new JLabel("CLICK ON THE BUTTON TO VIEW PROFILE INFO");
		b1 = new JButton("VIEW PROFILE", new ImageIcon("search.png"));
		b1.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String query = "select * from "+type+" where id = ? and password = ?";
				try
				{
					PreparedStatement ps = MyDConnection.con.prepareStatement(query);
					ps.setString(1,uid);
					ps.setString(2, oldpass);
					
					ResultSet res = ps.executeQuery();
					while(res.next())
					{
						CommonProfileView obj = new CommonProfileView("USER PROFILE", res.getString(2), res.getString(1), res.getString(3), res.getString(4), res.getString(6)+"-"+res.getString(7)+"-"+res.getString(8), res.getString(9), res.getString(10));
						obj.setVisible(true);
					}
					
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
			}
		});
		
		add(l1); add(b1);
	}
}
