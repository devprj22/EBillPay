package appPackage;

import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PrintReciept 
{
	JFileChooser obj = new JFileChooser();
	File f;
   public PrintReciept(String cname, String cid, String cdob , String cmobile , String cgender , String caddress , String cemail , String csdate , String cenddate , String cunits , String camount, String ctoday, String ctid) throws IOException 
   {
	   try
	   {
		   obj.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		   obj.setDialogTitle("SAVE TRANSACTION RECIEPT");
		   int val = obj.showSaveDialog(null);
		   if(val==JFileChooser.APPROVE_OPTION)
		   {
			   f = obj.getSelectedFile();
		   }
		   else if(val == JFileChooser.CANCEL_OPTION)
		   {
			   JOptionPane.showMessageDialog(null, "YOU CHOOSE CANCEL. FILE WILL BE SAVED IN D: WITH THE NAME SAME AS TRANSACTION ID");
			   f = new File("D:",ctid+".txt");
			   if(!f.exists())
				   f.createNewFile();
		   }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   PrintWriter pr = new PrintWriter(f);
	   pr.println("\t\t\tPAYMENT RECIEPT");
	   pr.println("NAME : "+cname);
	   pr.println("USER ID : "+cid);
	   pr.println("DATE OF BIRTH : "+cdob);
	   pr.println("MOBILE NUMBER : "+cmobile);
	   pr.println("GENDER : "+cgender);
	   pr.println("ADDRESS : "+caddress);
	   pr.println("EMAIL : "+cemail);
	   pr.print("BILL START DATE : "+csdate);
	   pr.println("\tBILL END DATE : "+cenddate);
	   pr.println("UNITS USED : "+ cunits);
	   pr.println("AMOUNT PAID : "+camount);
	   pr.println("DATE OF PAYMENT : "+ctoday);
	   pr.println("TRANSACTION ID : "+ctid);
	   pr.close();
   }
}
