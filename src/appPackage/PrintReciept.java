package appPackage;

import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PrintReciept 
{
	JFileChooser obj = new JFileChooser();
	File f;
   public PrintReciept(PrintReceiptData printReceiptData) throws IOException 
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
			   f = new File("D:",printReceiptData.ctid+".txt");
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
	   pr.println("NAME : "+ printReceiptData.cname);
	   pr.println("USER ID : "+printReceiptData.cid);
	   pr.println("DATE OF BIRTH : "+printReceiptData.cdob);
	   pr.println("MOBILE NUMBER : "+printReceiptData.cmobile);
	   pr.println("GENDER : "+ printReceiptData.cgender);
	   pr.println("ADDRESS : "+ printReceiptData.caddress);
	   pr.println("EMAIL : "+ printReceiptData.cemail);
	   pr.print("BILL START DATE : "+ printReceiptData.csdate);
	   pr.println("\tBILL END DATE : "+ printReceiptData.cenddate);
	   pr.println("UNITS USED : "+  printReceiptData.cunits);
	   pr.println("AMOUNT PAID : "+ printReceiptData.camount);
	   pr.println("DATE OF PAYMENT : "+ printReceiptData.ctoday);
	   pr.println("TRANSACTION ID : "+ printReceiptData.ctid);
	   pr.close();
   }
}
