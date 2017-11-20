

import javax.swing.*;
import java.util.*;

public class MainOfAnalyzer extends JApplet
 {

   private int APPLET_WIDTH = 650, APPLET_HEIGHT = 350;

   private JTabbedPane tPane;
   private OpenFilePanel openpanel;
   private AnaAndRepPanel anapanel;
   private HelpInfoPanel helpinfopanel;
   private ArrayList filelist;

   public void init()
    {
    
	   filelist = new ArrayList();

	   openpanel = new OpenFilePanel(filelist, anapanel);

	   anapanel = new AnaAndRepPanel(filelist);

     tPane = new JTabbedPane();
     tPane.addTab("Open Files", openpanel);
     tPane.addTab("Analyzation", anapanel);
     tPane.addTab("Help Information", helpinfopanel);

     getContentPane().add(tPane);
     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
    }
}
