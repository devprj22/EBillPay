package appPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PayByCard extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	private boolean OTPGenerated;

	/**
	 * Create the frame.
	 */
	public PayByCard(String msg,String cname, String cid, String cdob , String cmobile , String cgender , String caddress , String cemail , String csdate , String cenddate , String cunits , String camount, String ctoday) 
	{
		super(msg);
		OTPGenerated = false;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(this);
		setBounds(100, 100, 614, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCardPaymentForm = new JLabel("CARD PAYMENT FORM");
		
		JLabel lblEnterTheName = new JLabel("ENTER THE NAME OF CARD HOLDER : ");
		
		textField = new JTextField();
		textField.setColumns(30);
		
		JLabel lblEnterThe = new JLabel("ENTER THE 16 DIGIT CARD NUMBER : ");
		
		textField_1 = new JTextField();
		textField_1.setColumns(30);
		
		JLabel lblEnterCvv = new JLabel("ENTER CVV : ");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblEnterExpiryyyyymm = new JLabel("ENTER EXPIRY(yyyy-mm)");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT : ");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setText(camount);
		
		JButton btnSendOtp = new JButton("SEND OTP",new ImageIcon("letter.png"));
		btnSendOtp.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(!(textField.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()||textField_4.getText().isEmpty()))
				{
					 if(checkIfOnlyNumber(textField_1.getText())&&(textField_1.getText().length()==16)&&(textField_2.getText().length()==3)&&(checkIfOnlyNumber(textField_2.getText())))
					 {
						 JOptionPane.showMessageDialog(getParent(), "OTP SENT SUCCESSFULLY", "OTP REQUEST", JOptionPane.INFORMATION_MESSAGE);
						 OTPGenerated = true;
					 }
					 else
						 JOptionPane.showMessageDialog(getParent(), "ILLEGAL CARD NUMBER OR CVV", "WRONG INFORMATION", JOptionPane.ERROR_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(getParent(), "PLEASE FILL REQUIRED FIELDS", "INCOMPLETE INFORMATION", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JLabel lblEnetrOtp = new JLabel("ENETR OTP : ");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JButton btnPay = new JButton("PAY",new ImageIcon("money.png"));
		btnPay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(OTPGenerated)
				{
					if(!(textField.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()||textField_4.getText().isEmpty()||textField_5.getText().isEmpty()))
					{
						JOptionPane.showMessageDialog(getParent(), "PAYMENT SUCCESSFUL,TRANSACTION ID : "+generateAndSetTID(cid), "CONFRMATION", JOptionPane.INFORMATION_MESSAGE);
						try {
							new PrintReciept(cname, cid, cdob , cmobile , cgender, caddress, cemail , csdate, cenddate, cunits, camount, ctoday , generateAndSetTID(cid));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dispose();
					}
					else
						JOptionPane.showMessageDialog(getParent(), "PLEASE FILL REQUIRED FIELDS", "INCOMPLETE INFORMATION", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(getParent(), "YOU HAVE NOT GENERATED OTP", "GENERATE OTP", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		JLabel lblwillBeSent = new JLabel("(Will be sent to registered mobile)");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(218)
							.addComponent(lblCardPaymentForm))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnterTheName)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnterThe)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnterCvv)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblEnterExpiryyyyymm)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnetrOtp)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblTotalAmount, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(204)
									.addComponent(btnSendOtp)))
							.addGap(18)
							.addComponent(lblwillBeSent)))
					.addContainerGap(134, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(477, Short.MAX_VALUE)
					.addComponent(btnPay)
					.addGap(70))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCardPaymentForm)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterTheName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEnterThe)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterCvv)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterExpiryyyyymm)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalAmount)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSendOtp)
						.addComponent(lblwillBeSent))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnetrOtp)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPay)
					.addContainerGap(92, Short.MAX_VALUE))
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
	
	public boolean checkIfOnlyNumber(String cno)  //this function checks that the string contains only number or it has any alphabet in it
	{
		try
		{
			long val = Long.parseLong(cno);
			return true;
		}
		catch(NumberFormatException ne)
		{
			return false;
		}
	}
	
}
