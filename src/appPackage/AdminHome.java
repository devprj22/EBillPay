package appPackage;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//THI IS THE PAGE THAT COMES WHEN USER ADMIN IS SUCCESSFULL
//HERE I AM USING JTabbedPane

public class AdminHome extends JFrame
{
	JTabbedPane tpane1;
	public AdminHome(String oldpass,String msg, String uid, Welcome obj)
	{
		super(msg);
		setSize(700, 500);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		tpane1 = new JTabbedPane();
		tpane1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);  //causes the tabs to scroll if they don't fit in the screen
		tpane1.setTabPlacement(JTabbedPane.LEFT);
		
		tpane1.addTab("HOME", new ImageIcon("home.png"), new AdminHome1());
		tpane1.addTab("CHANGE PASSWORD",new ImageIcon("key.png"),new AdminChangePass(oldpass, uid));
		tpane1.addTab("UPDATE INFORMATION",new ImageIcon("update.png"),new AdminUpdateRecord(oldpass,uid));
		tpane1.addTab("SET CUSTOMER BILL",new ImageIcon("generate.png"),new AdminCustRecordSet());
		tpane1.addTab("VIEW CUSTOMER RECORD",new ImageIcon("display.png"), new AdminViewRecord());
		tpane1.addTab("DELETE CUSTOMER RECORD",new ImageIcon("delete.png"),new AdminDeleteCustData());
		tpane1.addTab("VIEW PROFILE",new ImageIcon("search.png"),new ViewProfile(oldpass, uid, "admindata"));
		tpane1.addTab("SWITCH USER",new ImageIcon("SwitchUser.png"),new SwitchUser(obj,this));
		tpane1.addTab("LOGOUT",new ImageIcon("logout.png"),new AdminLogout());
		add(tpane1);
	}
}
