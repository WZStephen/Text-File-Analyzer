//This class show help information
//
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.io.*;
//This class will be enable user to search and analysis
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class AnaAndRepPanel extends JPanel{
	private JPanel lowLeftPanel, lowRightPanel, wholepanel;
	private JLabel msg, msg2,lines, blankslines, spaces, words, avechar, avewordlength, commonwords;
	private JTextField lines1, blankslines1, spaces1, words1, avechar1, avewordlength1, commonwords1;
	private JScrollPane scroll;
	private JButton view, removepocess, cleanup;
	public ArrayList<String> list;
	private String[] numoffiles;
	private String[] temp;
	public AnaAndRepPanel(ArrayList filelist)
	{
		
			list = new ArrayList<String>();
		
		   msg = new JLabel("Please Choose File to Show Details:  ");
		   msg.setForeground(Color.red);
		   
		   lines = new JLabel("The number of lines: ");
		   blankslines = new JLabel("The number of blank lines: ");
		   spaces = new JLabel("The number of spaces: ");
		   words = new JLabel("The number of words: ");
		   avechar = new JLabel("Average characters per line: ");
		   avewordlength = new JLabel("Average word length: ");
		   commonwords = new JLabel("Most common words: ");
		   
		   view= new JButton("Click to view all files!");
		   view.addActionListener(new ButtonListener());
		   
		   lines1 = new JTextField(10);
		   blankslines1 = new JTextField(10);
		   spaces1 = new JTextField(10);
		   words1 = new JTextField(10);
		   avechar1 = new JTextField(10);
		   avewordlength1 = new JTextField(10);
		   commonwords1 = new JTextField(10);
		   		
		lowRightPanel = new JPanel();	
		lowRightPanel.setLayout(new GridLayout(7,2));
		lowRightPanel.add(lines);
		lowRightPanel.add(lines1);
		lowRightPanel.add(blankslines);
		lowRightPanel.add(blankslines1);
		lowRightPanel.add(spaces);
		lowRightPanel.add(spaces1);
		lowRightPanel.add(words);
		lowRightPanel.add(words1);
		lowRightPanel.add(avechar);
		lowRightPanel.add(avechar1);
		lowRightPanel.add(avewordlength);
		lowRightPanel.add(avewordlength1);
		lowRightPanel.add(commonwords);
		lowRightPanel.add(commonwords1);
		lowRightPanel.setPreferredSize(new Dimension(400,500));
		
		lowLeftPanel = new JPanel();
		lowLeftPanel.add(msg);
		lowLeftPanel.add(view);
		lowLeftPanel.setLayout(new BoxLayout(lowLeftPanel, BoxLayout.Y_AXIS));
		//lowLeftPanel.setPreferredSize(new Dimension(400,300));
		
		wholepanel = new JPanel();
		wholepanel.setLayout(new BoxLayout(wholepanel, BoxLayout.X_AXIS));	
		scroll = new JScrollPane(wholepanel);
		
		add(scroll);
		add(lowLeftPanel);
		add(lowRightPanel);	
		removepocess = new JButton("Click to remove all punctuation and possession ");
		removepocess.addActionListener(new ButtonListener());
		cleanup = new JButton("Click this and view to clean up history ");
		cleanup.addActionListener(new ButtonListener());
		add(removepocess);
		add(cleanup);
	}
	
	public void addCheckBox(String fileinfo, Date d) //checkbox used to indicate whether or not the computer should be added to the purchase
	{
	
		 temp = fileinfo.trim().split(";");	
		
		
		JCheckBox temp1=new JCheckBox(temp[0] + " || " +temp[8]);
		
		//temp1.addItemListener(new CheckBoxListener());
		lowLeftPanel.add(temp1);	
	
		
		//display the infomation on displaying panel
		try {
		lines1.setText(temp[1]);
		blankslines1.setText(temp[2]);
		spaces1.setText(temp[3]);
		words1.setText(temp[4]);
		avechar1.setText(temp[5]);
		avewordlength1.setText(temp[6]);
		if(temp[7] != null)
		{
			commonwords1.setText(String.valueOf(temp[7]));;
		}
		else if(temp[7] == " ")
		{
			commonwords1.setText("There is no most common words");
		}
		
		}
		catch(ArrayIndexOutOfBoundsException exception)
		{			
		}
		
	}
	private class ButtonListener implements ActionListener
	   {	   
		   public void actionPerformed(ActionEvent event)
		     { 
			  
			  
			   
			   if(event.getSource() == view)
			{
			   Date d = new Date(); //curent time when ayalysis the file
			  
			   //read the information from annlysis file
			   String content = null;
			  try {
				 content = new Scanner(new File("Analysis list.txt")).useDelimiter("\\Z").next();
				 if(content == null)
				 {
					 msg.setText("There is no analysis file!");
				 }
				 else {}
			} catch (FileNotFoundException | NullPointerException | NoSuchElementException eeee ) {
				
				msg.setText("There is no analysis file! ");
			}

			  
			  numoffiles = content.trim().split("~");
			  msg.setText("Success!");
			  
			  for(int i = 0; i < numoffiles.length; i++)
			  {
				  addCheckBox(numoffiles[i], d);
				  //list.add(numoffiles[i+1]);
			  }	  
			  
			}	
			   
			   else if(event.getSource() ==  removepocess)   //if user want to remove all punctuation and possession
			   {
				   File file = new File(temp[0]); //read the file by address		 				  
				   String st;
				   BufferedReader br; 
				   BufferedWriter writer1 = null;
				   FileOutputStream writer2 = null;
				   try {
			        	br = new BufferedReader(new FileReader(file));
			        	
			        	//clean up previous analyzed file
			        	writer2 = new FileOutputStream("AfterRemoving.txt");
						   writer2.write(("").getBytes());
						   writer2.close();
						   
			        	writer1 = new BufferedWriter( new FileWriter("AfterRemoving.txt", true));
			        	while((st = br.readLine()) != null)  //get # lines
						{	        		 
			        		String words = st.replaceAll("[(){},.;!?<>%':=-]", "");
			        		writer1.write(words);
						}	   
			        	File file1 = new File("AfterRemoving.txt"); 
			        	msg.setText("The input file has been successfully analyzed ");
			        	java.awt.Desktop.getDesktop().edit(file1);
				   	  }
				   catch (IOException e) 
			        {
			            e.printStackTrace();
			        }
				   finally 
					{
					    try
					    {
					        if ( writer1 != null)
					        writer1.close( );
					    }
					    catch (IOException ee)
					    {
					    }
					}
			  }	 
			   else
			   {
				   FileOutputStream writer = null;
				   try{

					   writer = new FileOutputStream("Analysis list.txt");
					   writer.write(("").getBytes());
					   writer.close();
					   lines1.setText("");
					   blankslines1.setText("");
					   spaces1.setText("");
					   words1.setText("");
					   avechar1.setText("");
					   avewordlength1.setText("");
					   commonwords1.setText("");;
			    	}catch(Exception e){

			    		e.printStackTrace();

			    	} 
				   msg.setText("All solution has successfully cleaned up ");
			   }
	   }
	private class CheckBoxListener implements ItemListener //listener to add the computer to the purchase amount when box is checked
	  {
		 public void itemStateChanged(ItemEvent event)
	        {	
			 String[] temp = null;
			 for(int i=0; i<numoffiles.length; i++)
			 {
				 if(((JCheckBox)lowLeftPanel.getComponent(i)).isSelected())
				 {
					//temp = numoffiles[i].trim().split(";");
				 }
			 }
			 lines1.setText(String.valueOf("ss"));
			 
	        }
	  }	
}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

