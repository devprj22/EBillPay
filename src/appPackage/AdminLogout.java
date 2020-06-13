package appPackage;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminLogout extends JPanel
{
	JLabel l;
	JButton btn;
	JTextField tf;
	
	public AdminLogout() 
	{
		l = new JLabel("CLICK BUTTON FOR LOGOUT : ");
		btn = new JButton("LOGOUT",new ImageIcon("logout.png"));
		tf = new JTextField(30);
		tf.setEditable(false);
		
		addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseExited(MouseEvent me)
			{
				tf.setText("TAKE THE MOUSE ON ICON FOR MORE DETAILS");
			}
			
			@Override
			public void mouseEntered(MouseEvent me)
			{
				tf.setText("TAKE THE MOUSE ON ICON FOR MORE DETAILS");
			}
		});
		
		btn.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(getParent(), "LOGOUT SUCCESSFUL", "LOGOUT", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		
		btn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent me)
			{
				tf.setText("CLOSES THE CURRENT SESSION AND LOGS OUT");
			}
		});
		
		add(l); add(btn); add(tf); 
	}
}
