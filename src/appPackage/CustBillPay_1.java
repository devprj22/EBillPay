package appPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class CustBillPay_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblTotalAmount;
	private JTextField textField_8;
	private JLabel lblStatus;
	private JTextField textField_9;
	private JLabel lblDob;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	Calendar obj = Calendar.getInstance();
	/**
	 * Create the frame.
	 */
	public CustBillPay_1(String msg, String cname, String cid, String cdob , String cmobile , String cgender , String caddress , String cemail , String csdate , String cenddate , String cunits , String camount , String cstatus) 
	{
		super(msg);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 569, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		setResizable(false);
		
		JLabel label = new JLabel(new ImageIcon("electricity.png"));
		
		JLabel lblName = new JLabel("NAME : ");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(cname);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("ID : ");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(cid);
		textField_1.setColumns(10);
		
		JLabel lblGender = new JLabel("GENDER : ");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setText(cgender);
		
		JLabel lblAddress = new JLabel("ADDRESS : ");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setText(caddress);
		
		JLabel lblEmail = new JLabel("EMAIL : ");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setText(cemail);
		
		JLabel lblStartDate = new JLabel("START DATE : ");
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setText(csdate);
		
		JLabel lblEndDate = new JLabel("END DATE : ");
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setText(cenddate);
		
		JLabel lblNewLabel = new JLabel("UNITS : ");
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setText(cunits);
		
		lblTotalAmount = new JLabel("TOTAL AMOUNT : ");
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setText(getTotalAmount(camount, cenddate));
		
		lblStatus = new JLabel("STATUS : ");
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setText(cstatus);
		
		lblDob = new JLabel("D.O.B : ");
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setText(cdob);
		
		JButton btnClose = new JButton("MAKE PAYMENT",new ImageIcon("money.png"));
		btnClose.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CustBillPay_2 obj = new CustBillPay_2("PAYMENT OPTIONS", cname, cid, cdob , cmobile , cgender , caddress ,  cemail ,  csdate ,  cenddate ,  cunits , getTotalAmount(camount, cenddate),getTodayDate());
				obj.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblMobile = new JLabel("MOBILE : ");
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setText(cmobile);
		
		JLabel lblTodaysDate = new JLabel("TODAY'S DATE : ");
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setText(getTodayDate());
		
		JLabel lblPanelty = new JLabel("PANELTY : ");
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setText(getPenalty(cenddate));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(128)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddress)
								.addComponent(lblStartDate)
								.addComponent(lblEmail)
								.addComponent(lblName)
								.addComponent(lblId)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_4)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblGender)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblMobile)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_11))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblDob)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField_7, Alignment.LEADING)
										.addComponent(textField_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblPanelty)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblEndDate)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_6)))))))
					.addContainerGap(60, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(295, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addGap(193))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTodaysDate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(372, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTotalAmount)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblStatus)
					.addGap(18)
					.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName)
						.addComponent(lblMobile)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGender)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDob)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartDate)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndDate)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTodaysDate)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPanelty)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalAmount)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStatus)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//This is the function created by me to get today's date
	public String getTodayDate()
	{
		String mdate = "";
		mdate  = Integer.toString(obj.get(Calendar.DATE));
		mdate+="-";
		mdate+= Integer.toString(obj.get(Calendar.MONTH)+1);
		mdate+="-";
		mdate+=Integer.toString(obj.get(Calendar.YEAR));
		return mdate;
	}
	
	public String getPenalty(String cenddate)
	{
		int mpenalty1 = 0;
		String mpenalty="";
		int day = Integer.parseInt(cenddate.substring(0, 2));
		int month = Integer.parseInt(cenddate.substring(3, 5));
		int year = Integer.parseInt(cenddate.substring(6, 10));
		
		if(obj.get(Calendar.YEAR) == year)
		{
			if((obj.get(Calendar.MONTH)+1)==month)
			{
				if(obj.get(Calendar.DATE)<=(day+10))
					mpenalty1 = 0;
				else
					mpenalty1 = (obj.get(Calendar.DATE) - (day+10))*5;
			}
			else if((obj.get(Calendar.MONTH)+1)==month+1)
			{
				if(obj.get(Calendar.DATE)+30-day>10)
					mpenalty1 =  (obj.get(Calendar.DATE)+30-(day+10) )* 5;
				else
					mpenalty1 = 0;
			}
		}
		else if(obj.get(Calendar.YEAR) == year+1)
		{
			if(obj.get(Calendar.DATE)+30-day>10)
				mpenalty1 =  (obj.get(Calendar.DATE)+30-(day+10)) * 5;
			else
				mpenalty1 = 0;
		}
		mpenalty = Integer.toString(mpenalty1);
		return mpenalty;
	}
	
	public String getTotalAmount(String camount, String cenddate)
	{
		String tamount = "";
		tamount = Double.toString(Double.parseDouble(camount)+Double.parseDouble(getPenalty(cenddate)));
		return tamount;
		
	}
}
