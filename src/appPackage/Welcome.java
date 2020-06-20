package appPackage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//This is the first screen that will come when the project is started.
//Only this will contain the main method 
//rest all things are linked to it

public class Welcome extends JFrame
{
	private static Welcome s_globalAppInstance = null;
	
	private JPanel panel1,panel2;
	private JLabel labelWelcome, labelOptions;
	private JButton btnAdmin, btnCustomer, btnNewUser, btnExit;
	
	public static Welcome GetInstance() {
		if (s_globalAppInstance == null)
				s_globalAppInstance = new Welcome();
		return s_globalAppInstance;
	}
	
	private Welcome() 
	{
		initLayoutProperties();
		
		createAndAddElementsToLayout();
		
		initEventListeners(this);
	}
	
	private void initLayoutProperties() {
		setLocation(300, 300);
		setUndecorated(true);
		setSize(700,200);
		setLayout(new GridLayout(2,1));
		setResizable(false);
	}
	
	private void createAndAddElementsToLayout()
	{
		//creating the first panel for the display page
		panel1 = new JPanel(new GridLayout(2, 1));
		labelWelcome = new JLabel("WELCOME TO EBILLPAY ");
		labelOptions = new JLabel("Please Select Any of the following : ");
		
		panel1.add(labelWelcome);
		panel1.add(labelOptions);
		
		//creating the second panel that contains the buttons
		panel2 = new JPanel(new FlowLayout());
		btnAdmin = new JButton("ADMIN", new ImageIcon("admin1m.png"));
		btnCustomer = new JButton("CUSTOMER", new ImageIcon("customers.png"));
		btnNewUser = new JButton("NEW USER", new ImageIcon("stock_people.png"));
		btnExit = new JButton("EXIT", new ImageIcon("cancel.png"));
		
		panel2.add(btnAdmin);
		panel2.add(btnCustomer);
		panel2.add(btnNewUser);
		panel2.add(btnExit);
		
		//adding the panels
		add(panel1);
		add(panel2);
	}
	
	private void initEventListeners(Welcome emp) {
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ExitFromWelcome obj = new ExitFromWelcome(emp, "EXIT....");
				obj.setVisible(true);
				dispose();
			}
		});
		
		btnNewUser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Registration reg = new Registration("WELCOME TO REGISTRATION", emp);
				reg.setVisible(true);
				dispose();
			}
		});
		
		btnAdmin.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				AdminLogin obj = new AdminLogin("ADMIN LOGIN", emp);
				dispose();
				obj.setVisible(true);
			}
		});
		
		btnCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				UserLogin uobj = new UserLogin("CUSTOMER LOGIN", emp);
				uobj.setVisible(true);
				dispose();
			}
		});
	}
	
	public static void main(String args[])
	{
		Welcome obj = Welcome.GetInstance();
		obj.setVisible(true);
	}
}
