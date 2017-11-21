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

public class AnaAndRepPanel extends JPanel{
	private JPanel lowLeftPanel, lowRightPanel, wholepanel;
	private JLabel msg, msg2,lines, blankslines, spaces, words, avechar, avewordlength, commonwords;
	private JTextField lines1, blankslines1, spaces1, words1, avechar1, avewordlength1, commonwords1;
	private JScrollPane scroll;
	private JButton view;
	public ArrayList<String> list;
	private String[] numoffiles;
	private JButton removepocess;
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
		add(removepocess);
	}
	
	public void addCheckBox(String fileinfo, Date d) //checkbox used to indicate whether or not the computer should be added to the purchase
	{
	
		String[] temp = fileinfo.trim().split(";");	
		
		
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
		commonwords1.setText(String.valueOf(temp[7]));;
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
			} catch (FileNotFoundException | NullPointerException eeee) {
				
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
			   else   //if user want to remove all punctuation and possession
			   {
				   
			   }
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

