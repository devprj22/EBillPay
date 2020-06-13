package appPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//SwitchUser for customer

public class SwitchUser1 extends JPanel
{
	JLabel l1;
	JButton b1;
	
	public SwitchUser1(Welcome obj, CustHome obj1) 
	{
		l1 = new JLabel("Click on the button to close your session and allow other user to log in ");
		b1 = new JButton("SWITCH USER",new ImageIcon("SwitchUser.png"));
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				obj.setVisible(true);
				obj1.dispose();
			}
		});
		
		add(l1); add(b1);
	}
}
