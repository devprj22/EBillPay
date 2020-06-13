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
	JPanel panel1,panel2,panel3;
	JLabel l1,l2;
	JButton b1,b2,b3,b4;
	Welcome emp;
	public Welcome() 
	{
		setLocation(300, 300);
		setUndecorated(true);
		setSize(700,200);
		setLayout(new GridLayout(2,1));
		setResizable(false);
		
		//creating the first panel for the display page
		panel1 = new JPanel(new GridLayout(2, 1));
		l1 = new JLabel("WELCOME TO EBILLPAY ");
		l2 = new JLabel("Please Select Any of the following : ");
		panel1.add(l1);
		panel1.add(l2);
		
		//creating the second panel that contains the buttons
		panel2 = new JPanel(new FlowLayout());
		b1 = new JButton("ADMIN",new ImageIcon("admin1m.png"));
		b2 = new JButton("CUSTOMER", new ImageIcon("customers.png"));
		b3 = new JButton("NEW USER", new ImageIcon("stock_people.png"));
		b4 = new JButton("EXIT",new ImageIcon("cancel.png"));
		
		panel2.add(b1);
		panel2.add(b2);
		panel2.add(b3);
		panel2.add(b4);
		
		//adding the panels
		add(panel1);
		add(panel2);
		
		//coding of the buttons
		emp = this;
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ExitFromWelcome obj = new ExitFromWelcome(emp, "EXIT....");
				obj.setVisible(true);
				dispose();
			}
		});
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Registration reg = new Registration("WELCOME TO REGISTRATION",emp);
				reg.setVisible(true);
				dispose();
			}
		});
		
		b1.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				AdminLogin obj = new AdminLogin("ADMIN LOGIN",emp);
				dispose();
				obj.setVisible(true);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
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
		Welcome obj = new Welcome();
		obj.setVisible(true);
	}
}
