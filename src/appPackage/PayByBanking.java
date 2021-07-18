package appPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PayByBanking extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JLabel lblEnterTheVerification;
	private JPasswordField passwordField_1;
	private JButton btnPay;
	private boolean isVerified;
	
	public PayByBanking(String msg,String cname, String cid, String cdob , String cmobile , String cgender , String caddress , String cemail , String csdate , String cenddate , String cunits , String camount, String ctoday) 
	{
		super(msg);
		isVerified = false;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(this);
		setBounds(100, 100, 616, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblOnlineBankingPayment = new JLabel("ONLINE BANKING PAYMENT FORM");
		
		JLabel lblEnterTheUser = new JLabel("ENTER THE USER NAME : ");
		
		textField = new JTextField();
		textField.setColumns(30);
		
		JLabel lblEnterThePassword = new JLabel("ENTER THE PASSWORD : ");
		
		passwordField = new JPasswordField();
		passwordField.setColumns(30);
		
		JLabel label = new JLabel("TOTAL AMOUNT : ");
		
		textField_1 = new JTextField();
		textField_1.setText("<dynamic>");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setText(camount);
		
		JButton btnGetVerified = new JButton("GET VERIFIED",new ImageIcon("verified.png"));
		btnGetVerified.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!(textField.getText().isEmpty()||String.copyValueOf(passwordField.getPassword()).isEmpty()))
				{
					isVerified = true;
					JOptionPane.showMessageDialog(getParent(), "YOU ARE VERIFIED", "VERIFICATION SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(getParent(), "PLEASE FILL USER ID AND PASSWORD", "INCOMPLETE DATA", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		lblEnterTheVerification = new JLabel("ENTER THE VERIFICATION CODE : ");
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(30);
		
		btnPay = new JButton("PAY",new ImageIcon("money.png"));
		btnPay.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(isVerified)
				{
					if(!(textField.getText().isEmpty()||textField_1.getText().isEmpty()||String.copyValueOf(passwordField.getPassword()).isEmpty()||String.copyValueOf(passwordField_1.getPassword()).isEmpty()))
					{
						JOptionPane.showMessageDialog(getParent(), "PAYMENT SUCCESSFUL,TRANSACTION ID : "+generateAndSetTID(cid), "CONFRMATION", JOptionPane.INFORMATION_MESSAGE);
						try {
							new PrintReciept(new PrintReceiptData(cname, cid, cdob , cmobile , cgender, caddress, cemail , csdate, cenddate, cunits, camount, ctoday , generateAndSetTID(cid)));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();

					}
					else
					{
						JOptionPane.showMessageDialog(getParent(), "PLEASE FILL ALL FIELDS", "DATA INCOMPLETE", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(getParent(), "YOU ARE NOT VERIFIED", "PLEASE VERIFY", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblOnlineBankingPayment)
							.addGap(176))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterTheUser)
								.addComponent(lblEnterThePassword)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(68))))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(189)
					.addComponent(btnGetVerified)
					.addContainerGap(310, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterTheVerification)
					.addGap(59)
					.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(115, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(524, Short.MAX_VALUE)
					.addComponent(btnPay)
					.addGap(25))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblOnlineBankingPayment)
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEnterTheUser)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterThePassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(btnGetVerified)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterTheVerification)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnPay)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public String generateAndSetTID(String uid)
	{
		String val="";
		for(int i=0;i<15;i++)
		{
			val+= (int)(Math.random()*10);
		}
		
		try
		{
			String query = "update billdata set transactionId = ? where id = ?";
			PreparedStatement ps = MyDConnection.con.prepareStatement(query);
			ps.setString(1, val);
			ps.setString(2, uid);
			ps.executeUpdate();
			String query1 = "update billdata set paid = ? where id = ?";
			PreparedStatement ps2 = MyDConnection.con.prepareStatement(query1);
			ps2.setString(1, "PAID");
			ps2.setString(2, uid);
			ps2.executeUpdate();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		
		return val;
	}
}


