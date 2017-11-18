//This class show help information
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class AnaAndRepPanel extends JPanel{
	private ArrayList filelist;
	private JPanel lowLeftPanel, lowRightPanel;
	private JLabel msg, msg2,lines, blankslines, spaces, words, avechar, avewordlength, commonwords;
	private JTextField lines1, blankslines1, spaces1, words1, avechar1, avewordlength1, commonwords1;
	private JScrollPane scroll;
	private JCheckBox temp;
	private OpenFilePanel openfilepanel;
	
	public AnaAndRepPanel(ArrayList filelist)
	{
		
		   msg = new JLabel("Analysis Details: ");
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
		scroll = new JScrollPane(lowLeftPanel);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(scroll);
		add(lowRightPanel);
//-----------------------------------------------finished setting layout
//-----------------------------------------------begin to read Analysis.txt		

		JTextArea textArea = new JTextArea();

		File file = new File("Analysis list.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str;
			while((str = br.readLine()) != null)  // while there exists lines to read in the text file
			{
				textArea.append(str);
				textArea.append(System.getProperty("line.separator"));
			}
			//textArea.append(str);
			br.close();
				
		}		
		catch(IOException ee)
		{
			 msg.setForeground(Color.red);
			 msg.setText("No analysis file has been created yet");
		}
		
		
		lowLeftPanel.add(textArea);
		
		Fileinfo finfo = new Fileinfo();
		lowLeftPanel.setPreferredSize(new Dimension(650,300));
		JCheckBox temp = new JCheckBox(finfo.toString());
		lowLeftPanel.add(temp);
		
		
		
	}
	
	public void addCheckBox(int test) //checkbox used to indicate whether or not the computer should be added to the purchase
	{
		//finfo = new Fileinfo();
		 int numoflines3 = 0;  //testing
		// numoflines3 = fileinfo.getnumoflines(); //testing
		 lines1.setText("nihao");//testing
		 
		 
		JCheckBox temp=new JCheckBox(String.valueOf(test));
		temp.addItemListener(new CheckBoxListener());
		 
		lowLeftPanel.add(temp);
		//return true;
	}
	
	private class CheckBoxListener implements ItemListener //listener to add the computer to the purchase amount when box is checked
	  {
		 public void itemStateChanged(ItemEvent event)
	        {		
			 int numoflines2 = 0;
			 for(int i=0; i<filelist.size(); i++)
	            {
					if(((JCheckBox)lowLeftPanel.getComponent(i)).isSelected())
					{
						 numoflines2 = ((Fileinfo)filelist.get(i)).getnumoflines();
						
					}
	            }
			 		lines1.setText(String.valueOf(numoflines2));
	        }
	  }	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

