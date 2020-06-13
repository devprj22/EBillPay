package appPackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustUpdateInfo extends JPanel
{
	//THIS PAGE IS ADDED AS TAB IN THE ADMIN LOGIN AND IS USED WHEN THE CUSTOMER WANTS TO CHANGE HIS PERSONAL INFO
	JPanel panel1,panel2;
	JButton b1,b2,b3,b4,b5,b6;
	JTextField field;
	
	public CustUpdateInfo(String pass, String uid) 
	{
		setLayout(new FlowLayout());
		b1 = new JButton("NAME", new ImageIcon("name.png"));
		b2 = new JButton("GENDER", new ImageIcon("name.png"));
		b3 = new JButton("ADDRESS", new ImageIcon("home.png"));
		b4 = new JButton("D.O.B", new ImageIcon("calendar.png"));
		b5 = new JButton("MOBILE NUMBER", new ImageIcon("mobile.png"));
		b6 = new JButton("EMAIL", new ImageIcon("letter.png"));
		panel1 = new JPanel(new FlowLayout());
		panel2 = new JPanel(new FlowLayout());
		panel1.add(b1); panel1.add(b2); panel1.add(b3);
		panel2.add(b4); panel2.add(b5); panel2.add(b6);
		add(panel1);
		add(panel2);
		
		//IF DOSEN'T WORK THEN THE FOLLOWING CODE CAN BE DELETED
		field = new JTextField(40);
		
		addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent me1)
			{
				field.setText("TAKE MOUSE ON ANY ICON FOR MORE INFO");
			}
		});
		
		add(field);
		field.setEditable(false);  //No One could edit this
		b1.addMouseListener(new MouseAdapter()   //using the adpater classes for mouse listener
		{
			public void mouseEntered(MouseEvent me)
			{
				field.setText("ALLOWS YOU TO CHANGE THE NAME");
			}
		});
		
		b2.addMouseListener(new MouseAdapter()   
		{
			public void mouseEntered(MouseEvent me)
			{
				field.setText("ALLOWS YOU TO CHANGE THE GENDER");
			}
		});
		
		b3.addMouseListener(new MouseAdapter()   
		{
			public void mouseEntered(MouseEvent me)
			{
				field.setText("ALLOWS YOU TO CHANGE THE ADDRESS");
			}
		});
		
		b4.addMouseListener(new MouseAdapter()   
		{
			public void mouseEntered(MouseEvent me)
			{
				field.setText("ALLOWS YOU TO CHANGE THE DATE OF BIRTH");
			}
		});
		
		b5.addMouseListener(new MouseAdapter()   
		{
			public void mouseEntered(MouseEvent me)
			{
				field.setText("ALLOWS YOU TO CHANGE THE MOBILE NUMBER");
			}
		});
		
		b6.addMouseListener(new MouseAdapter()   
		{
			public void mouseEntered(MouseEvent me)
			{
				field.setText("ALLOWS YOU TO CHANGE THE EMAIL ADDRESS");
			}
		});
		
		
		//ADDING THE CODE FOR THE ACTION LISTENERS
		
		b1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String newName = JOptionPane.showInputDialog("ENTER THE NEW NAME");
				
				updateRecord(pass, uid ,"uname" , newName.toUpperCase());
			}
		});
		
		
		b2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String newName = JOptionPane.showInputDialog("ENTER THE GENDER");
				
				updateRecord(pass, uid ,"gender" , newName);
			}
		});
		
		b3.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String newName = JOptionPane.showInputDialog("ENTER THE NEW ADDRESS");
				
				updateRecord(pass, uid ,"address" , newName);
			}
		});
		
		b4.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String newDay = JOptionPane.showInputDialog("ENTER THE NEW DAY FOR D.O.B");
			
				updateRecord(pass, uid , "ddob" , newDay);
				String newMonth = JOptionPane.showInputDialog("ENTER THE NEW MONTH FOR D.O.B");
	
				updateRecord(pass, uid ,"mdob" , newMonth);
				String newYear = JOptionPane.showInputDialog("ENTER THE NEW YEAR FOR D.O.B");
				
				updateRecord(pass, uid , "ydob" , newYear);
			}
		});
		

		b5.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String newName = JOptionPane.showInputDialog("ENTER THE NEW MOBILE NUMBER");
		
				updateRecord(pass, uid , "mobile" , newName);
			}
		});
		
		b6.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String newName = JOptionPane.showInputDialog("ENTER THE NEW EMAIL ADDRESS");
			
				updateRecord(pass, uid , "email" , newName);
			}
		});
	}
	
	public void updateRecord(String oldpass , String userId ,String field ,String newVal)
	{
		if(newVal == null)
		{
			JOptionPane.showMessageDialog(getParent(), field+" previous value retained", "UPDATE INFORMATION", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			String query = "update custdata set "+field+" = "+"\""+newVal+"\""+" where password = "+"\""+oldpass+"\""+" and id = "+"\""+userId+"\"";
			try
			{
				PreparedStatement ps = MyDConnection.con.prepareStatement(query);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(getParent(), field+" successfully updated", "UPDATE INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}

}
