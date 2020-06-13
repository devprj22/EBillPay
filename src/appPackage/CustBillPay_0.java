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

//This is the main page that will come in the customer menu for the payment of bill

public class CustBillPay_0 extends JPanel
{
	JLabel l;
	JButton btn;
	public CustBillPay_0(String oldpass,String uid) 
	{
		l = new JLabel("CLICK ON THE BUTTON TO FETCH YOUR BILL RECORD");
		btn = new JButton("GET BILL", new ImageIcon("generate.png"));
		add(l); add(btn);
		
		btn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String query1 = "select * from custdata where id = ? ";
				String query2 = "select * from billdata where id = ?";
				try
				{
					PreparedStatement ps = MyDConnection.con.prepareStatement(query1);
					ps.setString(1, uid);
					ResultSet res = ps.executeQuery();
					PreparedStatement ps2 = MyDConnection.con.prepareStatement(query2);
					ps2.setString(1, uid);
					ResultSet res1 = ps2.executeQuery();
					while(res.next()&&res1.next())
					{
						if(res1.getString(10).equals("PAID"))
						{
							JOptionPane.showMessageDialog(getParent(), "CURRENT BILL PAID , NEW RECORD NOT SET, TID : "+res1.getString(8), "BILL PAID", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							CustBillPay_1 obj = new CustBillPay_1("BILL SUMMARY", res.getString(2), uid, res.getString(6)+"-"+res.getString(7)+"-"+res.getString(8), res.getString(9), res.getString(3), res.getString(4), res.getString(10), res1.getString(2)+"-"+res1.getString(3)+"-"+res1.getString(4), res1.getString(5)+"-"+res1.getString(6)+"-"+res1.getString(7), res1.getString(11), res1.getString(9), res1.getString(10));
							obj.setVisible(true);
						}
					}
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
			}
		});
		
	}
	
}
