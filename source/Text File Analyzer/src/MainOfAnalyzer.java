package cse360;
import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.io.IOException;
 
public class MainOfAnalyzer extends JFrame
{
	private int APPLET_WIDTH = 850, APPLET_HEIGHT = 500;
	
	private JPanel wholePanel;
	private JTabbedPane tabPane;
	private OpenFilePanel openfilepanel;
	private AnaAndRepPanel anaandreepanel;
	private HelpInfoPanel helpinfopane;

  public MainOfAnalyzer() throws IOException
   {  
	  setTitle("CSE360 Spring 2017"); //set the title in main page
	  JLabel label1 = new JLabel();
	  label1.setText("Text Analyzer");
      JTabbedPane jtp = new JTabbedPane();
      jtp.add(label1);
	  getContentPane().add(jtp);

      
   
      tabPane = new JTabbedPane();
	  openfilepanel = new OpenFilePanel();
	  anaandreepanel = new AnaAndRepPanel();
	  helpinfopane = new HelpInfoPanel();
    	 
      tabPane.addTab("Open File ", openfilepanel); // OpenFilePanel?
      tabPane.addTab("Analyzation Report", anaandreepanel);//AnaAndRepPanel?
	  tabPane.addTab("Help", helpinfopane);//HelpInfoPanel?
	  
	 
	  wholePanel = new JPanel(new BorderLayout());
	  //wholePanel.add(jtp, BorderLayout.CENTER);
	  wholePanel.add(tabPane);
	  getContentPane().add(wholePanel); //to make Panel visible
	  wholePanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{openfilepanel, tabPane, anaandreepanel, helpinfopane}));

	  setSize (APPLET_WIDTH, APPLET_HEIGHT); //set JFrame size
	  
	  
   }
  
  public static void main(String[] args) throws IOException {
      
	  MainOfAnalyzer tp = new MainOfAnalyzer();
      tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      tp.setVisible(true);
       
  }
}