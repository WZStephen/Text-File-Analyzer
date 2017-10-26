//
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.*;
import java.util.*;

public class TextAnalyzer extends JApplet {
	
	private int APPLET_WIDTH = 650, APPLET_HEIGHT = 500;
	
	private JTabbedPane tPane;
	private HelpInfoPanel helpInfoPanel;
	private OpeningAndValidatingPanel openingAndValidatingPanel;
	private HistoryPanel historyPanle;
	private ArrayList FileInfoList;
	
	public void init()
	{
		FileInfoList = new ArrayList();		
	}

	

}
