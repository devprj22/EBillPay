package appPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

//THIS IS THE PAGE ADDED AS TAB IN USER LOGIN AND IS USED WHEN THE USER WANTS TO CHANGE PASSWORD

public class CustChangePass extends JPanel
{
	JLabel l1;
	JPasswordField p1;
	JButton b1;
	String oldpass1;
	
	public CustChangePass(String oldpass, String uid) 
	{
		l1 = new JLabel("ENTER NEW PASSWORD");
		p1 = new JPasswordField(20);
		b1 = new JButton("CHANGE",new ImageIcon("key.png"));
		add(l1); add(p1); add(b1);
		oldpass1=oldpass;
		
		b1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(String.copyValueOf(p1.getPassword()).isEmpty())
				{
					JOptionPane.showMessageDialog(getParent(), "NULL PASSWORD NOT ALLOWED", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else
				{	
					try
					{
						String newpass = String.copyValueOf(p1.getPassword());
						String query = "update custdata set password = ? where password = ? and id = ?";
						PreparedStatement ps = MyDConnection.con.prepareStatement(query);
						ps.setString(1, newpass);
						ps.setString(2, oldpass1);
						ps.setString(3, uid);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(getParent(), "UPDATE SUCCESFUL", "PASSWORD UPDATE", JOptionPane.INFORMATION_MESSAGE);
						oldpass1 = newpass;
						p1.setText(null);
					}
					catch(SQLException se)
					{
						se.printStackTrace();
					}
				}
			}
		});
	}
}
