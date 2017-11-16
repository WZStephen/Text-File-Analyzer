//This class will be enable user to search and analysis
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class OpenFilePanel extends JPanel {
	
		private ArrayList filelist;
	   private JPanel toolpanel, subpanel, wholepanel;
	   private JLabel msg1, msg2;
	   private JTextField filename;
	   private JScrollPane scroll;
	   private JButton Analyze, Browse, loadmorefile;
	   private Fileinfo fileinfo;
	   private AnaAndRepPanel anaandreppanel;
	   
	   public OpenFilePanel(ArrayList filelist, AnaAndRepPanel apanel)
	   {
		   this.filelist = filelist;
		   this.anaandreppanel = apanel;
		   msg1 = new JLabel("Type/Select a file to be oprend: ");   
		   msg2 = new JLabel("Notification Window");
		   msg2.setForeground(Color.red);
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
			   //anaandreppanel = new AnaAndRepPanel(filelist);
			   
			   int linecounter = 0;
			   int blanklinecounter = 0;
			   int spacecounter = 0;
			   int numofwords = 0;
			   double avecharperline = 0.0;
			   double averagewordlength = 0.0;
			   char mostcommonword[];
			   
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
			        	Scanner in = new Scanner(file);
			        	
						BufferedReader br = new BufferedReader(new FileReader(file));
						BufferedReader br1 = new BufferedReader(new FileReader(file));
						BufferedReader br2 = new BufferedReader(new FileReader(file));
						BufferedReader br3 = new BufferedReader(new FileReader(file));
						BufferedReader br4 = new BufferedReader(new FileReader(file));
						
						String st,st1,st2,st3,st4;
						
						while((st = br.readLine()) != null)  //get # lines
						{
							linecounter++;		
						}
											
						while((st1 = br1.readLine())!= null) //get # blank lines
						{
							if(st1 != null && st1.trim().equals( "" ))
							{
								blanklinecounter++;
							}
						}
											
						while((st2 = br2.readLine()) != null) //get # spaces
						{
							for(int i = 0; i < st2.length(); i++) 
							{
							     if(Character.isWhitespace(st2.charAt(i))) 
							    	 spacecounter++;
							}
						}
						
															
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
						
						numofwords = spacecounter + 2;
						
						avecharperline = (spacecounter+2)/linecounter;   //set Average chars per line
						//msg2.setText(String.valueOf(averagewordlength)); //store the number of word length to fileinfo class
						
						averagewordlength = numofchar/ (spacecounter + 2); //set Average word length
						
						  			
						fileinfo.setnumoflies(linecounter); //store the number of line to fileinfo class
						fileinfo.setnumofblanklines(blanklinecounter); //store the number of blank lines to fileinfo class
						fileinfo.setnumofspaces(spacecounter); //store the number of space to fileinfo class
						fileinfo.setavecharperline(avecharperline); //store the number of characters per line to fileinfo class
						fileinfo.setnumofwords(numofwords);;
						fileinfo.setaverageWlength(averagewordlength);
						
						//msg2.setText(String.valueOf(linecounter));					
						filelist.add(fileinfo);
					
						anaandreppanel.addCheckBox(1);
						
						msg2.setText("Fileinfo Added");
						msg2.setVisible(true);
						
						
						BufferedWriter writer = null;	// writes to a textfile of the details of a file analyzed
						try 
						{
						    writer = new BufferedWriter( new FileWriter("Analysis list.txt", true));
						    writer.write("The name of the read textfile is:" + filename.getText() + "\n"); writer.newLine();
						    writer.write("The number of lines is:" + linecounter + "\n"); writer.newLine();
						    writer.write( "The number of blank lines is:" + blanklinecounter + "\n"); writer.newLine();
						    writer.write("The number of spaces is:" + spacecounter + "\n"); writer.newLine();
						    writer.write("The number of words is:" + numofwords + "\n"); writer.newLine();
						    writer.write("The average number of characters per line is:" + avecharperline + "\n"); writer.newLine();
						    writer.write("The average of word length is:" + averagewordlength + "\n"); writer.newLine();
						}
						catch (IOException ee)
						{}
						finally
						{
						    try
						    {
						        if ( writer != null)
						        writer.close( );
						    }
						    catch (IOException ee)
						    {
						    }
						}
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





















