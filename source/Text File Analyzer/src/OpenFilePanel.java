package cse360;

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
	   private Fileinfo fileaddresslist;
	   private JTextPane pane;
	   public OpenFilePanel()
	   {
		   msg1 = new JLabel("Type/Select a file to be opened: ");   
		   msg2 = new JLabel("File Analysis:");
		   Analyze = new JButton("Analyze");		  //create a 'Analyze' button and add listener on it
		   Analyze.addActionListener(new ButtonListener());
		   Browse = new JButton("Browse");            //create a 'Browse' button and add listener on it
		   Browse.addActionListener(new ButtonListener());
		   loadmorefile = new JButton("...");
		   loadmorefile.addActionListener(new ButtonListener());
		   
		   filename = new JTextField("Type filename here...");
			   pane = new JTextPane();
			   pane.setEditable(false);
		   
		   toolpanel = new JPanel();	
		   toolpanel.setLayout(new GridLayout(15,15));
		   
		   subpanel = new JPanel();
		   subpanel.setLayout(new GridLayout(1,5));
		   subpanel.add(filename);
		   subpanel.add(Browse);
		   
		   toolpanel.add(msg1);
		   toolpanel.add(subpanel);
		   toolpanel.add(loadmorefile);
		   toolpanel.add(Analyze);
	   	   toolpanel.add(msg2);
	   	   toolpanel.add(pane);

	   	   scroll = new JScrollPane(toolpanel);
		   	
		   add(scroll);
				 	   
	   }   
	   private class ButtonListener implements ActionListener
	   {
		   
		   public void actionPerformed(ActionEvent e)
		     {
			   int linecounter = 0;
			   int blanklines = 0;
			   int spaces = 0;
			   int words = 0;
			   int characters = 0;
			   int avgchars = 0;
			   int avgword = 0;
			   
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
			        //String[] tokens = fileaddress.split("\\.(?=[^\\.]+$)");
			        msg2.setText(fileaddress);      
			        
			   }  
			   
			   else if(e.getSource() == Analyze)  //analysis the file by address
			   {
				   File file = new File(filename.getText()); //read the file by address
				   try {
			        	Scanner in = new Scanner(file);
						BufferedReader br = new BufferedReader(new FileReader(file));
						String str;
						
						while((str = br.readLine()) != null)  // while there exists lines to read in the text file
						{
							linecounter++;		// increment amount of lines for each line read in file
						
							
							for (char c : str.toCharArray())	// takes strings read in from file into char arrays
							{
								if (c == ' ')	// if any characters are read as ' ', increment amount of spaces
								{
									spaces++;
								}
								else
								{
									characters++;
								}
							}
							
							str = in.nextLine();	// set string "str" to be the scanned next line
							words += new StringTokenizer(str, " ,").countTokens();	// increment amount of words
							 	
						    if(str.trim().isEmpty()) // counts blank lines, increment amount of blank lines
						    {
						        blanklines++;
						    }
						    
						    avgchars = characters/linecounter;
						    avgword = words/linecounter;
						}
						//br.close();
						
						pane.setText("The number of lines is: " + linecounter + 
								"\nThe number of blank lines is: " + blanklines +
								"\nThe number of spaces is: " + spaces +
								"\nThe number of words is: " + words +
								"\nThe average number of characters per line is: " + avgchars +
								"\nThe average of word length is: " + avgword);
						
						
						BufferedWriter writer = null;	// writes to a textfile of the details of a file analyzed
						//for (int i = 1; i <= 10; i++)
						//{
							try 
							{
							    writer = new BufferedWriter(new FileWriter("analysis.txt", true));	// creates analysis files per files read
							    //writer.write(filename.getText() + "\n"); writer.newLine();	// name of textfile
							    writer.write(linecounter + "\n"); writer.newLine();			// number of lines
							    writer.write(blanklines + "\n"); writer.newLine();			// number of blank lines
							    writer.write(spaces + "\n"); writer.newLine();				// number of spaces
							    writer.write(words + "\n"); writer.newLine();				// number of words
							    writer.write(avgchars + "\n"); writer.newLine();			// average number of chars per line
							    writer.write(avgword + "\n"); writer.newLine();				// average word length
							    writer.write("*" + "\n");  writer.newLine(); // * indicates the next file read does not belong to previous file read
							}
							catch (IOException eee)
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
						System.out.println("File not found");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			   }
		     }		
	   }
}
