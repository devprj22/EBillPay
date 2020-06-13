package appPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//THIS PAGE IS CALLED WHEN THE ADMINISTRATOR WANTS TO DELETE A CUSTOMER RECORD

public class AdminDeleteCustData extends JPanel
{
	JLabel l1;
	JTextField id;
	JButton b1;
	
	public AdminDeleteCustData() 
	{
		l1 = new JLabel("ENTER THE ID : ");
		id = new JTextField(10);
		b1 = new JButton("DELETE RECORD", new ImageIcon("delete.png"));
		add(l1); add(id); add(b1);
		
		b1.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int flag=0;
				if(id.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(getParent(), "PLEASE FILL THE ID", "INCOMPLETE DATA", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query = "delete from custdata where id = ?";
					String query1 = "delete from billdata where id = ?";
					try
					{
						PreparedStatement ps = MyDConnection.con.prepareStatement(query);
						ps.setString(1, id.getText());
						PreparedStatement ps1 = MyDConnection.con.prepareStatement(query1);
						ps1.setString(1, id.getText());
						
					   flag = ps.executeUpdate();
						ps1.executeUpdate();
						if(flag==1)
						{
							JOptionPane.showMessageDialog(getParent(), "SUCCESSFULLY DELETED", "DELETE RECORD", JOptionPane.INFORMATION_MESSAGE);
						}
						
						if(flag==0)
						{
							JOptionPane.showMessageDialog(getParent(), "RECORD DOSEN'T EXIST","INCORRCET DATA",JOptionPane.ERROR_MESSAGE);
						}
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
