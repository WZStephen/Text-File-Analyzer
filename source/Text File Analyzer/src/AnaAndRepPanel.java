//This class show help information
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class AnaAndRepPanel extends JPanel{
	//private ArrayList filelist;
	private JPanel wholepanel, lowLeftPanel, lowRightPanel;
	private JLabel msg, lines, blankslines, spaces, words, avechar, avewordlength, commonwords;
	private JLabel lines1, blankslines1, spaces1, words1, avechar1, avewordlength1, commonwords1;
	private JScrollPane scroll;
	private OpenFilePanel openfilepanel;
	//private OpenFilePanel purchasePanel;
	
	public AnaAndRepPanel(ArrayList filelist, OpenFilePanel openfilepanel)
	{
		
		   msg = new JLabel("Analysis Details: ");
		   lines = new JLabel("The number of lines: ");
		   blankslines = new JLabel("The number of blank lines: ");
		   spaces = new JLabel("The number of spaces: ");
		   words = new JLabel("The number of words: ");
		   avechar = new JLabel("Average characters per line: ");
		   avewordlength = new JLabel("Average word length: ");
		   commonwords = new JLabel("Most common words: ");
		
		wholepanel = new JPanel();
		lowLeftPanel = new JPanel();
		lowRightPanel = new JPanel();
		
		wholepanel.setLayout(new BoxLayout(wholepanel, BoxLayout.Y_AXIS)); //set the general layout for whole analysis abd report panel
		wholepanel.add(msg);
		
		lowLeftPanel = new JPanel();
		lowRightPanel.setLayout(new GridLayout(7,2));
		
		
		
		

		
		
		
		
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
