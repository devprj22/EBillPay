package appPackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLoginUI extends JFrame
{
	private JTextField id;
	private JPasswordField pass;
	private JLabel labelUserId, labelPassword;
	private JButton btnAdmin, btnUndo, btnBack;
	private JPanel panel1;
	
	public AdminLoginUI(String msg, Welcome parentObj)
	{
		super(msg);
		initLayoutProperties();
		createAndAddElementsToLayout();
		initEventListeners(parentObj);
	}
	
	private void initLayoutProperties() {
		setSize(400,200);
		setLayout(new FlowLayout());
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void createAndAddElementsToLayout() {
		labelUserId = new JLabel("ENTER USER ID :");
		labelPassword = new JLabel("ENTER PASSWORD : ");
		
		id = new JTextField(20);
		pass = new JPasswordField(20);
		
		btnAdmin = new JButton("LOGIN", new ImageIcon("admin.jpg"));
		btnUndo = new JButton("RESET" , new ImageIcon("undo.png"));
		btnBack = new JButton("BACK" , new ImageIcon("back.png"));
		
		add(labelUserId); add(id);
		add(labelPassword); add(pass);
		
		panel1 = new JPanel(new FlowLayout());
		panel1.add(btnAdmin);
		panel1.add(btnUndo);
		panel1.add(btnBack);
		
		add(panel1);
	}
	
	private void initEventListeners(Welcome parentObj) {
		
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				id.setText(null);
				pass.setText(null);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				parentObj.setVisible(true);
			}
		});
		
		btnAdmin.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(IsAnyFormFieldEmpty())
				{
					JOptionPane.showMessageDialog(getParent(), "PLEASE FILL ALL THE FIELDS", "INCOMPLETE DATA", JOptionPane.ERROR_MESSAGE);
				}
				else
				{

					AdminLoginProcessor adminLoginProcessor = new AdminLoginProcessor(id.getText(), String.copyValueOf(pass.getPassword()));

					if(adminLoginProcessor.IsValidAdmin())
					{
						// Do the work if login is successful
						AdminHome obj = new AdminHome(adminLoginProcessor.GetAdminPassword(), "HELLO " + adminLoginProcessor.GetAdminName().toUpperCase(), adminLoginProcessor.GetAdminId(), parentObj);
						obj.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(getParent(), "INCORRECT DATA PLEASE TRY AGAIN", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
	
	private boolean IsAnyFormFieldEmpty()
	{
		return (id.getText().isEmpty())
				|| (String.copyValueOf(pass.getPassword()).isEmpty());
	}
}
