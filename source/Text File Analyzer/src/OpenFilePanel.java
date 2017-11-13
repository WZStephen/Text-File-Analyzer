//This class will be enable user to search and analysis
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class OpenFilePanel extends JPanel {
	
		private ArrayList filelist;
		 private AnaAndRepPanel anaandreppanel;
	   private JPanel toolpanel, subpanel, wholepanel;
	   private JLabel msg1, msg2;
	   private JTextField filename;
	   private JScrollPane scroll;
	   private JButton Analyze, Browse, loadmorefile;
	  	   
	   public OpenFilePanel(ArrayList filelist, AnaAndRepPanel anapanel)
	   {
		   this.filelist = filelist;
		   this.anaandreppanel = anapanel;
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
	   	toolpanel.setPreferredSize(new Dimension(400,300));
		   scroll = new JScrollPane(toolpanel);
		   add(scroll);
				 	   
	   }   
	   private class ButtonListener implements ActionListener
	   {
		   
		   public void actionPerformed(ActionEvent e)
		     {
			   
			   int linecounter = 0;
			   int blanklinecounter = 0;
			   int spacecounter = 0;
			   double numofcharperline = 0.0;
			   double averagewordlength = 0.0;
			   
			   if(e.getSource() == Browse)  //find the location of file, get address
			   {
				   String fileaddress;
				   JFileChooser fileChooser = new JFileChooser();		
				   FileFilter filter = new FileNameExtensionFilter("Text/CSV file", "txt", "csv");//set the types of files
				   fileChooser.addChoosableFileFilter(filter);				   				   
			       int rVal = fileChooser.showOpenDialog(null);
			        if (rVal == JFileChooser.APPROVE_OPTION) 
			        	filename.setText(fileChooser.getSelectedFile().toString());	
			        
			        fileaddress = filename.getText();
			        msg2.setText(fileaddress);			        			      		        
			   }  			   
			   else if(e.getSource() == Analyze)  //analysis the file by address
			   {
				   File file = new File(filename.getText()); //read the file by address
				   Fileinfo fileinfo = new Fileinfo();
			        try {
						BufferedReader br = new BufferedReader(new FileReader(file));
						BufferedReader br1 = new BufferedReader(new FileReader(file));
						BufferedReader br2 = new BufferedReader(new FileReader(file));
						BufferedReader br3 = new BufferedReader(new FileReader(file));
						BufferedReader br4 = new BufferedReader(new FileReader(file));
						
						String st,st1,st2,st3,st4;
						
						while((st = br.readLine()) != null)  //count the number of lines
						{
							linecounter++;		
						}
						//msg2.setText(String.valueOf(linecounter));
						
						
						while((st1 = br1.readLine())!= null) //count the number of blank lines
						{
							if(st1 != null && st1.trim().equals( "" ))
							{
								blanklinecounter++;
							}
						}
						//msg2.setText(String.valueOf(blanklinecounter));
						fileinfo.setnumofblanklines(blanklinecounter); //store the number of blank lines to fileinfo class
						
						while((st2 = br2.readLine()) != null) //count the number of space 
						{
							for(int i = 0; i < st2.length(); i++) 
							{
							     if(Character.isWhitespace(st2.charAt(i))) 
							    	 spacecounter++;
							}
						}
						//msg2.setText(String.valueOf(spacecounter));
						fileinfo.setnumofblanklines(spacecounter); //store the number of space to fileinfo class
						
						int numofchar = 0;
						while((st3 = br3.readLine()) != null)  //count the the average character perline
						{
							
							for(int i = 0; i < st3.length(); i++) 
							{								
								if(Character.isWhitespace(st3.charAt(i))) 
								{
									continue;	
								}
								numofchar++;
							}							
						}
						//msg2.setText(String.valueOf(numofcharperline));
						numofcharperline = numofchar/linecounter;   //calculate number of characters per line.
						fileinfo.setavecharperline(numofcharperline); //store the number of characters per line to fileinfo class
						
						averagewordlength = numofchar/ (spacecounter + 2); //calculate average word length
						//msg2.setText(String.valueOf(averagewordlength)); //store the number of word length to fileinfo class
						
						
						  

						fileinfo.setnumoflies(linecounter); //store the number of line to fileinfo class	
						int testvalue = fileinfo.getnumoflines();
						msg2.setText(String.valueOf(testvalue));	
						//msg2.setText(String.valueOf(linecounter));					
						filelist.add(fileinfo);
						
						 AnaAndRepPanel anaandreppanel = new AnaAndRepPanel(filelist);
						anaandreppanel.addCheckBox(testvalue);						
						//msg2.setText("fileinfo added");
										
						msg2.setVisible(true);
						filename.setText("  ");		
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			         catch(NumberFormatException ex)
			        {
			   		 msg2.setText("Invalid File Address!");
			   		 msg2.setVisible(true);
			   	  }
			   }
			   else if(e.getSource() == loadmorefile)
			   {
				   //the '...' button for handling more files
			   }
		     }		
	   }
}