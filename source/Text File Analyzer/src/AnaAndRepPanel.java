package cse360;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

import javax.swing.text.*;

public class AnaAndRepPanel extends JPanel{
	//private ArrayList filelist;
	private JPanel panel, lowLeftPanel, lowRightPanel, lowwholepanel;
	private JLabel msg, msg2,lines, blankslines, spaces, words, 
	avechar, avewordlength, commonwords;
	private JTextField lines1, blankslines1, spaces1, words1, 
	avechar1, avewordlength1, commonwords1;
	private JScrollPane scroll;
	private JCheckBox temp;
	
	
	public AnaAndRepPanel() throws IOException 
	{
		msg = new JLabel("Analysis Report: ");
		msg2 = new JLabel("File List: ");
		   
			lines = new JLabel("The number of lines: ");
			blankslines = new JLabel("The number of blank lines: ");
			spaces = new JLabel("The number of spaces: ");
			words = new JLabel("The number of words: ");
			avechar = new JLabel("Average characters per line: ");
			avewordlength = new JLabel("Average word length: ");
			commonwords = new JLabel("Most common words: ");
			   
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
			
				lowLeftPanel = new JPanel();
				lowLeftPanel.setPreferredSize(new Dimension(400,300));
				lowLeftPanel.add(msg2);
				scroll = new JScrollPane(lowLeftPanel);
				
				setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			    add(scroll);
			    add(lowRightPanel);
			    
			    Fileinfo finfo = new Fileinfo();
			    JCheckBox temp = new JCheckBox(finfo.toString());
			    JCheckBox temp2 = new JCheckBox(finfo.toString());
		
			    temp.addItemListener(new CheckBoxListener());	
			    temp2.addItemListener(new CheckBoxListener());
			    lowLeftPanel.add(temp);
			    lowLeftPanel.add(temp2);
	}
	public void addCheckBox(Fileinfo finfo) //checkbox used to indicate whether or not the computer should be added to the purchase
	{
		JCheckBox temp = new JCheckBox(finfo.toString());
		JCheckBox temp2 = new JCheckBox(finfo.toString());
		temp.addItemListener(new CheckBoxListener());	 
		temp2.addItemListener(new CheckBoxListener());	 
		lowLeftPanel.add(temp);
		lowLeftPanel.add(temp2);
		}

private class CheckBoxListener implements ItemListener //listener to add the computer to the purchase amount when box is checked
				  {
					 public void itemStateChanged(ItemEvent event)
				        {		
						 int numoflines = 0;
						 int blanklines = 0;
						 int spaces = 0;
						 int words = 0;
						 int avgchars = 0;
						 int avgword = 0;
						 Fileinfo fileinfo = null;
						try 
						{
							fileinfo = new Fileinfo();
						} 
						catch (FileNotFoundException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						 numoflines = fileinfo.getnumoflines();  
						 blanklines = fileinfo.getnumofblanklines();
						 spaces = fileinfo.getnumofspaces();
						 words = fileinfo.getnumofwords();
						 avgchars = fileinfo.getaverageCperline();
						 avgword = fileinfo.getaverageWlength();
						 
						 
						 lines1.setText(String.valueOf(numoflines));
						 blankslines1.setText(String.valueOf(numoflines));
						 spaces1.setText(String.valueOf(numoflines));
						 words1.setText(String.valueOf(numoflines));
						 avechar1.setText(String.valueOf(numoflines));
						 avewordlength1.setText(String.valueOf(numoflines));
				        }
				  }	
			    
}
		//panel = new JPanel();
		//panel.setLayout(new BorderLayout());
		//panel.add(msg, BorderLayout.NORTH);
		
		//JTextArea textArea = new JTextArea();
		//textArea.setEditable(false);
		
		
		
		//panel.add(textArea);
		//textArea.setText("it is done");
		//add(panel);
		
