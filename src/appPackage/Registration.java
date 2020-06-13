package appPackage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;

public class Registration extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private ButtonGroup bg,bg1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private Welcome obj;
	public Registration(String msg, Welcome welo) 
	{
		super(msg);
		obj = welo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		setResizable(false);
		
		bg = new ButtonGroup();
		bg1 = new ButtonGroup();
		JLabel label = new JLabel(new ImageIcon("admin1.png"), JLabel.CENTER);
		
		JLabel lblNewLabel = new JLabel("Name : ");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password : ");
		
		passwordField = new JPasswordField();
		
		JLabel lblRetypePassword = new JLabel("Re-Type Password : ");
		
		passwordField_1 = new JPasswordField();
		
		JLabel lblUserId = new JLabel("User Id : ");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setText(Integer.toString(gid()));
		
		JLabel lblAccountType = new JLabel("Account Type : ");
		
		JCheckBox chckbxAdmin = new JCheckBox("ADMIN");
		JCheckBox chckbxCustomer = new JCheckBox("CUSTOMER");
		
		bg.add(chckbxAdmin);
		bg.add(chckbxCustomer);
		
		JLabel lblGender = new JLabel("Gender : ");
		
		JCheckBox chckbxMale = new JCheckBox("MALE");
		
		JCheckBox chckbxFemale = new JCheckBox("FEMALE");
		bg1.add(chckbxFemale);
		bg1.add(chckbxMale);
		
		JLabel lblAddress = new JLabel("Address :");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth :");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_1 = new JLabel("-");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label_2 = new JLabel("-");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile : ");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email id :");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT",new ImageIcon("save.png"));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Inserting if for the validation check that all the details are filled
				if(!((textField.getText().isEmpty())||(textField_1.getText().isEmpty())||(textField_3.getText().isEmpty())||(textField_4.getText().isEmpty())||(textField_5.getText().isEmpty())||(textField_6.getText().isEmpty())||(textField_7.getText().isEmpty())||(String.copyValueOf(passwordField.getPassword()).isEmpty())||(String.copyValueOf(passwordField_1.getPassword()).isEmpty())||((!chckbxAdmin.isSelected())&&(!chckbxCustomer.isSelected()))||((!chckbxFemale.isSelected())&&(!chckbxMale.isSelected()))))
				{
					if(chckbxAdmin.isSelected())
					{
						String query = "insert into admindata values(?,?,?,?,?,?,?,?,?,?)";
						try 
						{
							String gen="";
							String pass="";
							if(chckbxMale.isSelected())
								gen="M";
							if(chckbxFemale.isSelected())
								gen="F";
					
							String p1 = String.copyValueOf(passwordField.getPassword());
							String p2 = String.copyValueOf(passwordField_1.getPassword());
							if(p1.equals(p2))
							{
								pass=p2;
							}
							else
							{
								JOptionPane.showMessageDialog(getParent(), "Password Field Mismatch Retry Again", "ERROR", JOptionPane.ERROR_MESSAGE);
								dispose();
								obj.setVisible(true);
							}
					
							PreparedStatement ps = MyDConnection.con.prepareStatement(query);
							ps.setString(1, textField_1.getText());
							ps.setString(2, textField.getText().toUpperCase());
							ps.setString(3, gen);
							ps.setString(4, textField_2.getText());
							ps.setString(5, pass);
							ps.setString(6, textField_3.getText());
							ps.setString(7, textField_4.getText());
							ps.setString(8, textField_5.getText());
							ps.setString(9, textField_6.getText());
							ps.setString(10, textField_7.getText());
							ps.executeUpdate();
							JOptionPane.showMessageDialog(getParent(),"REGISTRATION SUCCESSFUL");
							dispose();
							obj.setVisible(true);
						} 
						catch (Exception e2) 
						{
					
						}
					}
					else if(chckbxCustomer.isSelected())
					{
						String query = "insert into custdata values(?,?,?,?,?,?,?,?,?,?)";
						try 
						{
							String gen="";
							String pass="";
							if(chckbxMale.isSelected())
								gen="M";
							if(chckbxFemale.isSelected())
								gen="F";
					
							String p1 = String.copyValueOf(passwordField.getPassword());
							String p2 = String.copyValueOf(passwordField_1.getPassword());
							if(p1.equals(p2))
							{
								pass=p2;
							}
							else
							{
								JOptionPane.showMessageDialog(getParent(), "Password Field Mismatch Retry Again", "ERROR", JOptionPane.ERROR_MESSAGE);
								dispose();
								obj.setVisible(true);
							}
					
							PreparedStatement ps = MyDConnection.con.prepareStatement(query);
							ps.setString(1, textField_1.getText());
							ps.setString(2, textField.getText().toUpperCase());
							ps.setString(3, gen);
							ps.setString(4, textField_2.getText());
							ps.setString(5, pass);
							ps.setString(6, textField_3.getText());
							ps.setString(7, textField_4.getText());
							ps.setString(8, textField_5.getText());
							ps.setString(9, textField_6.getText());
							ps.setString(10, textField_7.getText());
							ps.executeUpdate();
							JOptionPane.showMessageDialog(getParent(),"REGISTRATION SUCCESSFUL");
							
							//THIS IS THE MODIFICATION TO ADD THE ID IN THE BILL DATA TABLE
							String query1 = "insert into billdata values(?,?,?,?,?,?,?,?,?,?,?)";
							ps = MyDConnection.con.prepareStatement(query1);
							ps.setString(1, textField_1.getText());
							ps.setString(2, "00");
							ps.setString(3, "00");
							ps.setString(4, "2015");
							ps.setString(5, "00");
							ps.setString(6, "00");
							ps.setString(7, "2015");
							ps.setString(8, "0");
							ps.setString(9, "0");
							ps.setString(10, "PAID");
							ps.setString(11, "0");
							ps.executeUpdate();
							dispose();
							obj.setVisible(true);
						} 
						catch (Exception e2) 
							{
					
							}
						}
					}
				else
				{
					JOptionPane.showMessageDialog(getParent(), "FIELD INCOMPLETE", "Please fill all the fields", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnReset = new JButton("RESET",new ImageIcon("undo.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				passwordField.setText(null);
				passwordField_1.setText(null);
			}
		});
		
		JButton btnBack = new JButton("BACK",new ImageIcon("back.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				obj.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblDdmmyyyy = new JLabel("(dd-mm-yyyy)");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblPassword)
								.addComponent(lblRetypePassword)
								.addComponent(lblUserId)
								.addComponent(lblAccountType)
								.addComponent(lblGender)
								.addComponent(lblAddress)
								.addComponent(lblDateOfBirth)
								.addComponent(lblMobile)
								.addComponent(lblEmailId)
								.addComponent(btnSubmit))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(33)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
										.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
											.addGap(8)
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblDdmmyyyy))
										.addComponent(textField_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
										.addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
										.addComponent(passwordField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
										.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
										.addComponent(passwordField, Alignment.TRAILING, 263, 286, Short.MAX_VALUE)
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(chckbxAdmin)
												.addComponent(chckbxMale))
											.addPreferredGap(ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(chckbxFemale)
												.addComponent(chckbxCustomer))
											.addGap(24))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(55)
									.addComponent(btnReset)
									.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
									.addComponent(btnBack)
									.addGap(25)))))
					.addGap(39))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRetypePassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserId)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountType)
						.addComponent(chckbxAdmin)
						.addComponent(chckbxCustomer))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(chckbxMale)
						.addComponent(chckbxFemale))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfBirth)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDdmmyyyy))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobile)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmailId)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnReset)
						.addComponent(btnBack))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public int gid()  //function that creates an id of 7 digits
	{
		int id;
		String val="";
		for(int i=0;i<7;i++)
		{
			val+= (int)(Math.random()*10);
		}
		id = Integer.parseInt(val);
		return id;
	}
}
