//This class will be enable user to search and analysis
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class OpenFilePanel extends JPanel {
	
	 
	   private JPanel toolpanel, subpanel, wholepanel;
	   private JLabel msg1, msg2;
	   private JTextField filename;
	   private JScrollPane scroll;
	   private JButton Analyze, Browse, loadmorefile;
	   private FileAddressList fileaddresslist;
	   public OpenFilePanel()
	   {
		   msg1 = new JLabel("Type/Select a file to be oprend: ");   
		   msg2 = new JLabel("Testing window");
		   Analyze = new JButton("Analyze!");		  //create a 'Analyze' button and add listener on it
		   Analyze.addActionListener(new ButtonListener());
		   Browse = new JButton("Browse");            //create a 'Browse' button and add listener on it
		   Browse.addActionListener(new ButtonListener());
		   loadmorefile = new JButton("...");
		   loadmorefile.addActionListener(new ButtonListener());
		   
		   filename = new JTextField("Type Filename here...");
		   
		   
		   toolpanel = new JPanel();	
		   toolpanel.setLayout(new GridLayout(5,1));
		   
		   subpanel = new JPanel();
		   subpanel.setLayout(new GridLayout(1,2));
		   subpanel.add(filename);
		   subpanel.add(Browse);
		   
		   toolpanel.add(msg1);
		   toolpanel.add(subpanel);
		   toolpanel.add(loadmorefile);
		   toolpanel.add(Analyze);
	   	   toolpanel.add(msg2);
		   scroll = new JScrollPane(toolpanel);
		   add(scroll);
				 	   
	   }   
	   private class ButtonListener implements ActionListener
	   {
		   public void actionPerformed(ActionEvent e)
		     {
			   
			   if(e.getSource() == Browse)
			   {
				   JFileChooser fileChooser = new JFileChooser();
		
				   FileFilter filter = new FileNameExtensionFilter("Text/CSV file", "txt", "csv");//set the types of files
				   fileChooser.addChoosableFileFilter(filter);				   
				   
			       int rVal = fileChooser.showOpenDialog(null);
			        if (rVal == JFileChooser.APPROVE_OPTION) 
			        	filename.setText(fileChooser.getSelectedFile().toString());	
			        msg2.setText(filename.getText());
			        
			        File file = new File(filename.getText()); //read the file by address
			        try {
						BufferedReader br = new BufferedReader(new FileReader(file));
						String st;
						while((st = br.readLine()) != null)
						{
							msg2.setText(st);
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        
			        //Array a[] = "", "2";
					//fileaddresslist = new FileAddressList(a);

			       //we can get directory of selected file from user then open it by StreamReader.
			        
			     /*  File filen = new File(filename.getText());
			        
			       
						InputStreamReader reader = new InputStreamReader(new FileInputStream(filen));
						BufferedReader bufferedReader = new BufferedReader(reader);   
						String lineTXT = null;
						while ((lineTXT = bufferedReader.readLine()) != null) {   
							msg2.setText(lineTXT.toString().trim());
						}
				*/	
			        
			   }  
			   else if(e.getSource() == Analyze)
			   {
				   
			   }
		     }		
	   }
}





















