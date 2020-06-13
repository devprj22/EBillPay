package appPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CustBillPay_2 extends JFrame {

	private JPanel contentPane;
	
	ButtonGroup bg;
	
	public CustBillPay_2(String msg,String cname, String cid, String cdob , String cmobile , String cgender , String caddress , String cemail , String csdate , String cenddate , String cunits , String camount, String ctoday) 
	{
		super(msg);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		bg = new ButtonGroup();
		JLabel lblPleaseSelectFrom = new JLabel("PLEASE SELECT FROM ANY OF THE FOLLOWING : ");
		
		JCheckBox chckbxCreditdebitCard = new JCheckBox("Credit/Debit Card");
		
		JCheckBox chckbxPayThroughSbi = new JCheckBox("Pay Through SBI Internet Banking");
		
		bg.add(chckbxPayThroughSbi);
		bg.add(chckbxCreditdebitCard);
		
		JButton btnContinue = new JButton("CONTINUE");
		
		btnContinue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!(chckbxCreditdebitCard.isSelected()||chckbxPayThroughSbi.isSelected()))
					JOptionPane.showMessageDialog(getParent(), "PLEASE SELECT ANY OPTION", "ERROR", JOptionPane.ERROR_MESSAGE);
				else if(chckbxCreditdebitCard.isSelected())
				{
					PayByCard obj = new PayByCard("PAY THROUGH CARD",cname, cid, cdob , cmobile , cgender , caddress ,  cemail ,  csdate ,  cenddate ,  cunits ,  camount,  ctoday);
					obj.setVisible(true);
					dispose();
				}
				else
				{
					PayByBanking obj = new PayByBanking("PAY BY ONLINE BANKING", cname, cid, cdob, cmobile, cgender, caddress, cemail, csdate, cenddate, cunits, camount, ctoday);
					obj.setVisible(true);
					dispose();
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chckbxCreditdebitCard)
							.addGap(78)
							.addComponent(chckbxPayThroughSbi))
						.addComponent(lblPleaseSelectFrom))
					.addContainerGap(232, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(412, Short.MAX_VALUE)
					.addComponent(btnContinue)
					.addGap(25))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblPleaseSelectFrom)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxCreditdebitCard)
						.addComponent(chckbxPayThroughSbi))
					.addGap(35)
					.addComponent(btnContinue)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
