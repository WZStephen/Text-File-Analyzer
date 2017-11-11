

import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
 
public class MainOfAnalyzer extends JFrame
{
	private int APPLET_WIDTH = 600, APPLET_HEIGHT = 550;
	
	private JPanel wholePanel;
	private JTabbedPane tabPane;
	private OpenFilePanel openfilepanel;
	private AnaAndRepPanel anaandreepanel;
	private HelpInfoPanel helpinfopane;
	private ArrayList filelist;
 

  public MainOfAnalyzer()
   {
	  
	 filelist = new ArrayList();
	  
	  setTitle("CSE360 Spring 2017"); //set the title in main page
	  JLabel label1 = new JLabel();
	  label1.setText("Text Analyzer");
      JTabbedPane jtp = new JTabbedPane();
      jtp.add(label1);
	  getContentPane().add(jtp);

      
      
      tabPane = new JTabbedPane();
	  openfilepanel = new OpenFilePanel(filelist);
	  anaandreepanel = new AnaAndRepPanel(filelist, openfilepanel);
	  helpinfopane = new HelpInfoPanel();
    	 
      tabPane.addTab("Open File ", openfilepanel); // OpenFilePanel?
      tabPane.addTab("Analyzation Report", anaandreepanel);//AnaAndRepPanel?
	  tabPane.addTab("Help", helpinfopane);//HelpInfoPanel?
	  
	 
	  wholePanel = new JPanel(new BorderLayout());
	  wholePanel.add(jtp, BorderLayout.CENTER);
	  wholePanel.add(tabPane);
	  getContentPane().add(wholePanel); //to make Panel visible

	  setSize (APPLET_WIDTH, APPLET_HEIGHT); //set JFrame size
	  
	  
   }
  
  public static void main(String[] args) {
      
	  MainOfAnalyzer tp = new MainOfAnalyzer();
      tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      tp.setVisible(true);
       
  }
}

