

import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainOfAnalyzer extends JFrame
{
	private int APPLET_WIDTH = 700, APPLET_HEIGHT = 650;
	
	private JTabbedPane tabPane;
   private OpenFilePanel openfilepanel;
   private AnaAndRepPanel anaandreepanel;
   private HelpInfoPanel helpinfopane;
 
 

  public MainOfAnalyzer()
   {
	  setTitle("Text File Analyzer");
	  
	  openfilepanel = new OpenFilePanel();
	  anaandreepanel = new AnaAndRepPanel();
	  helpinfopane = new HelpInfoPanel();
      
      tabPane = new JTabbedPane();
	 
      tabPane.addTab("Open File ", openfilepanel); // OpenFilePanel?
      tabPane.addTab("Analyzation Report", anaandreepanel);//AnaAndRepPanel?
	  tabPane.addTab("Help", helpinfopane);//HelpInfoPanel?
	  getContentPane().add(tabPane);
	  setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size

   }
  
  public static void main(String[] args) {
      
	  MainOfAnalyzer tp = new MainOfAnalyzer();
      tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      tp.setVisible(true);
       
  }
}

