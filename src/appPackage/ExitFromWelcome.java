package appPackage;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExitFromWelcome extends JFrame
{
	JLabel l1;
	JButton b1,b2;
	Welcome prev;
	public ExitFromWelcome(Welcome obj,String msg)
	{
		super(msg);
		setLayout(new FlowLayout());
		setSize(300, 100);
		setResizable(false);
		setLocationRelativeTo(this);
		l1 = new JLabel("CONFIRM EXIT");
		b1 = new JButton("YES");
		b2 = new JButton("STAY");
		prev = obj; //reference of the welcome page that called it.
		b1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
				prev.setVisible(true);
			}
		});
		
		add(l1);
		add(b1);
		add(b2);
	}
}
