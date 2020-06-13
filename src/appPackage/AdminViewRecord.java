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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//This page will come when the administrator want to view any data regarding the customer

public class AdminViewRecord extends JPanel
{
	JPanel panel1 , panel2;
	JLabel l1;
	JButton b1;
	JTextField f1;
	
	public AdminViewRecord() 
	{
		//Layout of the first panel
		panel1 = new JPanel(new FlowLayout());
		l1 = new JLabel("ENTER THE ID : ");
		f1 = new JTextField(10);
		b1 = new JButton("VIEW RECORD", new ImageIcon("display.png"));
		panel1.add(l1); panel1.add(f1); panel1.add(b1);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(f1.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(getParent(), "PLEASE FILL THE ID", "INCOMPLETE DATA", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					//Here we need to access data from two tables
					String query1 = "select * from custdata where id = ? ";
					String query2 = "select * from billdata where id = ?";
					try
					{
						int flag = 0;
						PreparedStatement ps = MyDConnection.con.prepareStatement(query1);
						ps.setString(1, f1.getText());
						ResultSet res = ps.executeQuery();
						PreparedStatement ps2 = MyDConnection.con.prepareStatement(query2);
						ps2.setString(1, f1.getText());
						ResultSet res1 = ps2.executeQuery();
						
						while(res.next()&&res1.next())
						{
							flag=1;
							AdminCustViewFrame obj = new AdminCustViewFrame("CUSTOMER RECORD", res.getString(2), f1.getText(), res.getString(6)+"-"+res.getString(7)+"-"+res.getString(8), res.getString(9), res.getString(3), res.getString(4), res.getString(10), res1.getString(2)+"-"+res1.getString(3)+"-"+res1.getString(4), res1.getString(5)+"-"+res1.getString(6)+"-"+res1.getString(7), res1.getString(11), res1.getString(9), res1.getString(10));
							obj.setVisible(true);
						}
						if(flag == 0)
						{
							JOptionPane.showMessageDialog(getParent(), "CORRESPONDING RECORT DON'T EXIST", "DATA NOT FOUND", JOptionPane.ERROR_MESSAGE);
							f1.setText(null);

						}
						
					}
					catch(SQLException se)
					{
						se.printStackTrace();
					}
				}
			}
		});
		
		
		add(panel1);
	}
}
