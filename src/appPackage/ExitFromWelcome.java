package appPackage;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExitFromWelcome extends JFrame
{
	private JLabel labelExit;
	private JButton btnYes, btnStay;
	
	public ExitFromWelcome(Welcome obj, String msg)
	{
		super(msg);
		setLayout(new FlowLayout());
		setSize(300, 100);
		setResizable(false);
		setLocationRelativeTo(this);
		
		labelExit = new JLabel("CONFIRM EXIT");
		
		btnYes = new JButton("YES");
		btnStay = new JButton("STAY");
		
		btnYes.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
		
		btnStay.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
				obj.setVisible(true);
			}
		});
		
		add(labelExit);
		add(btnYes);
		add(btnStay);
	}
}
