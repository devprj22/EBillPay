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
import javax.swing.JTextField;

import java.sql.ResultSet;

//THIS IS THE PAGE TO BE CALLED WHEN WE WANT TO SET THE RECORD FOR THE BILL OF A CUSTOMER

public class AdminCustRecordSet extends JPanel
{
	JLabel l1;
	JTextField id;
	JButton b1;
	
	public AdminCustRecordSet() 
	{
		l1 = new JLabel("ENTER THE ID : ");
		id = new JTextField(10);
		b1 = new JButton("SET RECORD", new ImageIcon("generate.png"));
		
		add(l1); add(id); add(b1);
		
		b1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(id.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(getParent(), "PLEASE FILL THE ID", "INCOMPLETE DATA", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query = "select * from custdata where id = ?";
					try
					{
						PreparedStatement ps = MyDConnection.con.prepareStatement(query);
						ps.setString(1, id.getText());
						ResultSet res =  ps.executeQuery();
						int flag = 0;
						while(res.next())
						{
							flag = 1;
							BillSetForm obj = new BillSetForm(res.getString(2), res.getString(1), res.getString(4), res.getString(9),"CUSTOMER BILL FORM");
							obj.setVisible(true);
						}
						if(flag==0)
						{
							JOptionPane.showMessageDialog(getParent(), "CORRESPONDING RECORT DON'T EXIST", "DATA NOT FOUND", JOptionPane.ERROR_MESSAGE);
							id.setText(null);
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
