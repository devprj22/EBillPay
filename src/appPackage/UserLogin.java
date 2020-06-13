package appPackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLogin extends JFrame
{
	JTextField id;
	JPasswordField pass;
	JLabel l1,l2;
	JButton b1,b2,b3;
	JPanel panel1;
	Welcome welo;
	public UserLogin(String msg, Welcome obj) 
	{
		super(msg);
		welo = obj;
		setSize(400,200);
		setLayout(new FlowLayout());
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		l1 = new JLabel("ENTER USER ID :");
		l2 = new JLabel("ENTER PASSWORD : ");
		
		id = new JTextField(20);
		pass = new JPasswordField(20);
		
		b1 = new JButton("LOGIN", new ImageIcon("admin.jpg"));
		b2 = new JButton("RESET" , new ImageIcon("undo.png"));
		b3 = new JButton("BACK" , new ImageIcon("back.png"));
		
		add(l1); add(id);
		add(l2); add(pass);
		
		panel1 = new JPanel(new FlowLayout());
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				id.setText(null);
				pass.setText(null);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				welo.setVisible(true);
			}
		});
		
		//Coding for the login button
		
		b1.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if((id.getText().isEmpty())||(String.copyValueOf(pass.getPassword()).isEmpty()))
				{
					JOptionPane.showMessageDialog(getParent(), "PLEASE FILL ALL THE FIELDS", "INCOMPLETE DATA", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int flag = 0;
					String uid="",upass="";
					String cust_name="";
					String query = "select * from custdata where id = ? and password = ?";
					try 
					{
						PreparedStatement ps = MyDConnection.con.prepareStatement(query);
						ps.setString(1, id.getText());
						ps.setString(2, String.copyValueOf(pass.getPassword()));
						ResultSet res = ps.executeQuery();
						while(res.next())
						{
							flag = 1;
							uid = res.getString(1);
							upass = res.getString(5);
							cust_name = res.getString(2);
						}
						if(id.getText().equals(uid)&&(String.copyValueOf(pass.getPassword()).equals(upass)))
						{
							//Do the work if login is successful
							CustHome obj = new CustHome(upass,"HELLO "+cust_name.toUpperCase(), uid,welo);
							obj.setVisible(true);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(getParent(), "INCORRECT DATA PLEASE TRY AGAIN", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
						}
					} 
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		add(panel1);
		
	}
}
