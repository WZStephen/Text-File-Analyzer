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

public class OpenFilePanel extends JPanel {
	
	 
	   private JPanel toolpanel, subpanel, wholepanel;
	   private JLabel msg1, msg2;
	   private JTextField filename;
	   private JScrollPane scroll;
	   private JButton Analyze, Browse, loadmorefile;

	   public OpenFilePanel()
	   {
		   msg1 = new JLabel("Type/Select a file to be oprend: ");   
		  
		   Analyze = new JButton("Analyze!");		  //create a 'Analyze' button and add listener on it
		   Analyze.addActionListener(new ButtonListener());
		   Browse = new JButton("Browse");            //create a 'Browse' button and add listener on it
		   Browse.addActionListener(new ButtonListener());
		   loadmorefile = new JButton("...");
		   loadmorefile.addActionListener(new ButtonListener());
		   
		   filename = new JTextField("Type Filename here...");
		   
		   
		   toolpanel = new JPanel();	
		   toolpanel.setLayout(new GridLayout(4,1));
		   
		   subpanel = new JPanel();
		   subpanel.setLayout(new GridLayout(1,2));
		   subpanel.add(filename);
		   subpanel.add(Browse);
		   
		   toolpanel.add(msg1);
		   toolpanel.add(subpanel);
		   toolpanel.add(loadmorefile);
		   toolpanel.add(Analyze);
	   	   
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
			       fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			       fileChooser.setAcceptAllFileFilterUsed(false);
			       int rVal = fileChooser.showOpenDialog(null);
			        if (rVal == JFileChooser.APPROVE_OPTION) 
			        	filename.setText(fileChooser.getSelectedFile().toString());		        						
			   }   
		     }		
	   }
}





















