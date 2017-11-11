//This class show help information
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AnaAndRepPanel extends JPanel{
	private ArrayList filelist;
	private JPanel wholepanel, lowLeftPanel, lowRightPanel, lowwholepanel;
	private JLabel msg, lines, blankslines, spaces, words, avechar, avewordlength, commonwords;
	private JTextField lines1, blankslines1, spaces1, words1, avechar1, avewordlength1, commonwords1;
	private JScrollPane scroll;
	private OpenFilePanel openfilepanel;
	
	public AnaAndRepPanel(ArrayList filelist)
	{
		
		   msg = new JLabel("Analysis Details: ");
		   
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
		
		wholepanel = new JPanel();
		wholepanel.setLayout(new BoxLayout(wholepanel, BoxLayout.Y_AXIS)); //set the general layout for whole analysis abd report panel
		wholepanel.add(msg);
		
		lowLeftPanel = new JPanel();
		lowLeftPanel.setPreferredSize(new Dimension(400,300));
		
	
		
		scroll = new JScrollPane(lowLeftPanel);
		
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
			
		lowwholepanel = new JPanel();
		lowwholepanel.setLayout(new BoxLayout(lowwholepanel, BoxLayout.X_AXIS));
		lowwholepanel.add(lowLeftPanel);
		lowwholepanel.add(lowRightPanel);
		lowwholepanel.add(scroll);
				
		wholepanel.add(lowwholepanel);
		scroll = new JScrollPane(wholepanel);
		add(scroll);
		
		
		
	}
	
	public void addCheckBox(Fileinfo finfo) //checkbox used to indicate whether or not the computer should be added to the purchase
	{
		JCheckBox temp=new JCheckBox(finfo.toString());
		temp.addItemListener(new CheckBoxListener());
		lowLeftPanel.add(temp);
	}
	
	private class CheckBoxListener implements ItemListener //listener to add the computer to the purchase amount when box is checked
	  {
		 public void itemStateChanged(ItemEvent event)
	        {
			 	
			 
	        }
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
