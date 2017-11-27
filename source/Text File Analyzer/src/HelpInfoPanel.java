

//This class show help information
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HelpInfoPanel extends JPanel{
	//private ArrayList filelist;
	private JPanel upPane, lowPanel;
	private JLabel msg, msg1;
	private JScrollPane scroll;
	private JEditorPane textpane;
	
	public HelpInfoPanel()
	{
		//msg = new JLabel("Help Information: ");
		
		upPane = new JPanel();
		scroll = new JScrollPane(textpane);
		setLayout(new BorderLayout());
		//upPane.add(msg);
		//scroll = new JScrollPane(upPane);
		//add(scroll);
		setPreferredSize(new Dimension(800, 800));
		add(scroll, BorderLayout.CENTER);
		
		textpane = new JEditorPane("text/html", "");
		textpane.setEditable(false);
		
		
		textpane.setText("<h1><b>Welcome to the Help Panel!</b></h1>" + 
				"\n <h2><b>How to Open File(s)</b></h2>" + 
					"<p> To open a file, go to the <b>Open File</b> tab and select a file to be opened using the <i>Browse</i> button. </p>" + 
					"<p> To open more files, simply use the <i>Browse</i> button again to select a new file. The previous file's details will be stored and the new file to be analyzed will replace the previous. </p> <br></br>" + 
				"<h2><b>How to Analyze File(s)</b></h2>" +
					"<p> To analyze files, press the <i>Analyze</i> button located in the <b>Open File</b> tab and the file will be analyzed one at a time </p>" + 
				"<h2><b>How to See File Analysis Data</b></h2>" +
					"<p> To see the history of files analyzed, go to the <b>Analyzation Report</b> tab. There, you will be able to see the specific details of the file(s) you have previously chosen to analyze.</p>");
		
		add(textpane);
	}

}