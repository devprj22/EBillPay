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
	private JTextField id;
	private JPasswordField pass;
	private JLabel labelUserId, labelPass;
	private JButton btnLogin, btnReset, btnBack;
	private JPanel panel1;
	
	private static String query = "select * from custdata where id = ? and password = ?";
	
	public UserLogin(String msg, Welcome welo) 
	{
		super(msg);
		
		setSize(400,200);
		setLayout(new FlowLayout());
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		labelUserId = new JLabel("ENTER USER ID :");
		labelPass = new JLabel("ENTER PASSWORD : ");
		
		id = new JTextField(20);
		pass = new JPasswordField(20);
		
		btnLogin = new JButton("LOGIN", new ImageIcon("admin.jpg"));
		btnReset = new JButton("RESET" , new ImageIcon("undo.png"));
		btnBack = new JButton("BACK" , new ImageIcon("back.png"));
		
		add(labelUserId); add(id);
		add(labelPass); add(pass);
		
		panel1 = new JPanel(new FlowLayout());
		panel1.add(btnLogin);
		panel1.add(btnReset);
		panel1.add(btnBack);
		
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				id.setText(null);
				pass.setText(null);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				welo.setVisible(true);
			}
		});
		
		//Coding for the login button
		
		btnLogin.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(IsAnyFormFieldEmpty())
				{
					JOptionPane.showMessageDialog(getParent(), "PLEASE FILL ALL THE FIELDS", "INCOMPLETE DATA", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String uid="",upass="";
					String cust_name="";
					
					try 
					{
						PreparedStatement ps = MyDConnection.con.prepareStatement(query);
						
						ps.setString(1, id.getText());
						ps.setString(2, String.copyValueOf(pass.getPassword()));
						
						ResultSet res = ps.executeQuery();
						
						while(res.next())
						{
							uid = res.getString(1);
							upass = res.getString(5);
							cust_name = res.getString(2);
						}
						
						if(id.getText().equals(uid)&&(String.copyValueOf(pass.getPassword()).equals(upass)))
						{
							// Do the work if login is successful
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
	
	private boolean IsAnyFormFieldEmpty() {
		return (id.getText().isEmpty())
				|| (String.copyValueOf(pass.getPassword()).isEmpty());
	}
}
