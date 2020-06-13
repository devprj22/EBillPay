package appPackage;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

//The first tab to be added in the tabbed pane of the CustHome.java

public class CustHome1 extends JPanel
{
	JLabel l1,l3,l4,l5,l6,l7,l8;
	public CustHome1() 
	{
		setLayout(new GridLayout(7,1));
		l1 = new JLabel("WELCOME USER", JLabel.CENTER);
		l3 = new JLabel("UPDATE INFORMATION : Change any personal information about you");
		l4 = new JLabel("CHANGE PASSWORD : Allows to change your password as per your convinience");
		l5 = new JLabel("PAY BILL : Allows you to pay your electricity bill");
		l7 = new JLabel("VIEW PROFILE : Shows your personal information");
		l6 = new JLabel("LOGOUT : Closes the session");
		l8 = new JLabel("SWITCH USER : Closes your account for log in by other user.");
		
		add(l1); add(l4); add(l3);  add(l5); add(l7); add(l8); add(l6);
	}
}
