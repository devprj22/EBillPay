package appPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillSetForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	public BillSetForm(String cname, String id, String address, String mobile, String msg)
	{
		super(msg);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 541, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		JLabel lblNewLabel = new JLabel(new ImageIcon("electricity.png"));
		
		JLabel name = new JLabel("CUSTOMER NAME : ");
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(cname);
		textField.setEditable(false);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID : ");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText(id);
		textField_1.setEditable(false);
		
		JLabel lblCustomerAddress = new JLabel("CUSTOMER ADDRESS : ");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText(address);
		textField_2.setEditable(false);
		
		JLabel lblMobileNumber = new JLabel("MOBILE NUMBER :");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setText(mobile);
		textField_3.setEditable(false);
		
		JLabel lblStartingDate = new JLabel("STARTING DATE : ");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label = new JLabel("-");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel label_1 = new JLabel("-");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblEndingDate = new JLabel("ENDING DATE :");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel label_2 = new JLabel("-");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel label_3 = new JLabel("-");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JLabel lblUnitsUsed = new JLabel("UNITS USED :");
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT :");
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setEditable(false);
		
		JButton btnSave = new JButton("SAVE",new ImageIcon("save.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!(textField_4.getText().isEmpty()||textField_5.getText().isEmpty()||textField_6.getText().isEmpty()||textField_7.getText().isEmpty()||textField_8.getText().isEmpty()||textField_9.getText().isEmpty()||textField_10.getText().isEmpty()||textField_11.getText().isEmpty()))
				{
					String query = "update billdata set pday = ? , pmonth = ? , pyear = ? ,cday = ? , cmonth = ? , cyear = ? , transactionId = ? , camount = ? , paid = ? , nunits = ? where id = ?";
					try
					{
						PreparedStatement ps = MyDConnection.con.prepareStatement(query);
						ps.setString(1, textField_4.getText());
						ps.setString(2, textField_5.getText());
						ps.setString(3, textField_6.getText());
						ps.setString(4, textField_7.getText());
						ps.setString(5, textField_8.getText());
						ps.setString(6, textField_9.getText());
						ps.setString(7, "0");
						ps.setString(8, textField_11.getText());
						ps.setString(9, "NOT PAID");
						ps.setString(10, textField_10.getText());
						ps.setString(11,id);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(getParent(), "RECORD SUCCESSFULLY SET", "BILL SET", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					catch(SQLException se)
					{
						se.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(getParent(), "PLEASE FILL ALL FIELDS", "INCOMPLETE DATA", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnReset = new JButton("RESET",new ImageIcon("undo.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				textField_9.setText(null);
				textField_10.setText(null);
				textField_11.setText(null);
			}
		});
		
		JButton btnQuit = new JButton("QUIT",new ImageIcon("cancel.png"));
		btnQuit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		
		JButton btnGetAmount = new JButton("Get Amount",new ImageIcon("money.png"));
		btnGetAmount.addActionListener(new ActionListener(){	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(!textField_10.getText().isEmpty())
				{
					textField_11.setText(generateAmount(textField_10.getText()));
				}
				else
					JOptionPane.showMessageDialog(getParent(), "PLEASE FILL UINTS USED");
			}
		});
		
		JLabel lblddmmyyyy = new JLabel("(dd-mm-yyyy)");
		
		JLabel label_4 = new JLabel("(dd-mm-yyyy)");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(name)
						.addComponent(lblCustomerId)
						.addComponent(lblCustomerAddress)
						.addComponent(lblMobileNumber)
						.addComponent(lblStartingDate)
						.addComponent(lblEndingDate)
						.addComponent(lblUnitsUsed)
						.addComponent(lblTotalAmount)
						.addComponent(btnSave))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
							.addComponent(btnQuit)
							.addGap(23))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblddmmyyyy))
										.addComponent(textField_3)
										.addComponent(textField_2)
										.addComponent(textField_1)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField_11)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
											.addGap(18)
											.addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addContainerGap(128, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
									.addComponent(btnGetAmount)
									.addGap(75))))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(144)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(name)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCustomerId)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCustomerAddress)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobileNumber)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartingDate)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblddmmyyyy))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEndingDate)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_3)
							.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_4)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnitsUsed)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGetAmount))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalAmount)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnQuit)
						.addComponent(btnReset))
					.addGap(69))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public String generateAmount(String unitUsed)
	{
		int basePrice = 5 ; 
		double finalPrice = 0;
		String fp = "";
		try
		{
		   finalPrice = ((Double.parseDouble(unitUsed))*basePrice);
		}
		catch(NumberFormatException ne)
		{
			finalPrice = 0;
			JOptionPane.showMessageDialog(getParent(), "ILLEGAL UNIT VALUE", "ERROR", JOptionPane.ERROR_MESSAGE);
			textField_10.setText(null);
		}
	    fp = Double.toString(finalPrice);
		return fp;
	}
}
