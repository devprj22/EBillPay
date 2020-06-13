package appPackage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//This is the home page for the customer if the login is successful

public class CustHome extends JFrame
{
	JTabbedPane tpane1;
	public CustHome(String oldpass,String msg, String cid, Welcome obj) 
	{
		super(msg);
		setSize(700, 500);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		tpane1 = new JTabbedPane();
		tpane1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);  //causes the tabs to scroll if they don't fit in the screen
		tpane1.setTabPlacement(JTabbedPane.LEFT);	
		tpane1.addTab("HOME", new ImageIcon("home.png"), new CustHome1());
		tpane1.addTab("CHANGE PASSWORD",new ImageIcon("key.png"),new CustChangePass(oldpass, cid));
		tpane1.addTab("UPDATE INFORMATION",new ImageIcon("update.png"),new CustUpdateInfo(oldpass,cid));
		tpane1.addTab("PAY YOUR BILL",new ImageIcon("generate.png"),new CustBillPay_0(oldpass, cid));
		tpane1.addTab("VIEW PROFILE",new ImageIcon("search.png"),new ViewProfile(oldpass, cid, "custdata"));
		tpane1.addTab("SWITCH USER",new ImageIcon("SwitchUser.png"),new SwitchUser1(obj,this));
		tpane1.addTab("LOGOUT",new ImageIcon("logout.png"),new AdminLogout()); //for logout i am using the same file that i have created for admin
		
		add(tpane1);
	}
}
