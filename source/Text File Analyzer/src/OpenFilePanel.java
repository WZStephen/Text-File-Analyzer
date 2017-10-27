//This class will be enable user to search and analysis
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class OpenFilePanel extends JPanel {
	
	 
	   private JPanel toolpanel;
	   private JLabel msg1, msg2;
	   private JTextField filename;
	   private JScrollPane scroll;
	   private JButton Analyze, Browse;

	   public OpenFilePanel(ArrayList filelist)
	   {
		   msg1 = new JLabel("Type/Select a file to be oprend: ");
		   
		   filename = new JTextField();
		   Analyze = new JButton("Analyze!");		  //create a 'Analyze' button and add listener on it
		   Analyze.addActionListener(new ButtonListener());
		   Browse = new JButton("Browse");            //create a 'Browse' button and add listener on it
		   Browse.addActionListener(new ButtonListener());
		   
		   toolpanel = new JPanel();
		   toolpanel.setLayout(new BoxLayout(toolpanel, BoxLayout.Y_AXIS));		  
		   toolpanel.add(msg1);
		   
		   
	   }
	   
	   private class ButtonListener implements ActionListener
	   {
		   public void actionPerformed(ActionEvent event)
		     {
			   
		     }
		   
	   }
}
