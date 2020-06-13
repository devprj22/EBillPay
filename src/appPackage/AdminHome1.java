package appPackage;

//The first tab to be added in the tabbed pane of the AdminHome.java
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminHome1 extends JPanel
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	public AdminHome1() 
	{
		setLayout(new GridLayout(9,1));
		l1 = new JLabel("WELCOME ADMIN",JLabel.CENTER);
		l2 = new JLabel("CHANGE PASSWORD : Allows to change your password as per your convinience");
		l3 = new JLabel("UPDATE INFORMATION : Change any personal information about you.");
		l4 = new JLabel("SET CUSTOMER BILL : Set the data for the customer bill to be payed by him");
		l6 = new JLabel("VIEW CUSTOMER RECORD : View The record of a customer by entering its id");
		l7 = new JLabel("DELETE CUSTOMER RECORD : Delete the record of a customer by entering its id");
		l8 = new JLabel("VIEW PROFILE : Shows your personal information");
		l9 = new JLabel("SWITCH USER : Closes your account for log in by other user.");
		l5 = new JLabel("LOGOUT : Closes the session");
	
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l5);
	}
}
