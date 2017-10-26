

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
   private OpenFilePanel openfilepanel;
   private AnaAndRepPanel anaandreepanel;
   private HelpInfoPanel helpinfopane;
 
 

  public MainOfAnalyzer()
   {
	  setTitle("Text File Analyzer");
	  
      JTabbedPane jtp = new JTabbedPane();
	  getContentPane().add(jtp);

	  openfilepanel = new OpenFilePanel();
	  anaandreepanel = new AnaAndRepPanel();
	  helpinfopane = new HelpInfoPanel();
	  
	  JPanel jp1 = new JPanel();
      JPanel jp2 = new JPanel();
      JPanel jp3 = new JPanel();
      
      JLabel label1 = new JLabel();
      label1.setText("You are in area of Tab1");
      JLabel label2 = new JLabel();
      label2.setText("You are in area of Tab2");
      JLabel label3 = new JLabel();
      label3.setText("You are in area of Tab3");
      
	  jtp.addTab("Open File ", jp1); // OpenFilePanel?
	  jtp.addTab("Analyzation Report", jp2);//AnaAndRepPanel?
	  jtp.addTab("Help", jp3);//HelpInfoPanel?

	 
   }
  
  public static void main(String[] args) {
      
	  MainOfAnalyzer tpanel = new MainOfAnalyzer();
      tpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      tpanel.setSize(900, 600);
      tpanel.setVisible(true);
       
  }
}

