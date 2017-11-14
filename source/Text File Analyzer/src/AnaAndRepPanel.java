package cse360;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.text.*;

public class AnaAndRepPanel extends JPanel{
	//private ArrayList filelist;
	private JPanel panel;
	private JLabel msg;
	private JScrollPane scroll;
	private JFrame frame;
	
	
	public AnaAndRepPanel() throws FileNotFoundException 
	{
		msg = new JLabel("Analysis Report: ");
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(msg, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		//textArea.setText("hi");
		
		//JScrollPane scroll = new JScrollPane(textArea);
		//add(scroll);
		File file = new File("analysis.txt");
		
		try 
		{
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
		catch (IOException e)
		{
			 e.printStackTrace();
		}
		
		
		panel.add(textArea);
		//textArea.setText("it is done");
		add(panel);
		
		//panel.add(scroll);
		
//		scroll = new JScrollPane(textArea);
//		add(scroll);
//		
//		File file = new File("analysis.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		try
//		{
//			String str, display;
//			
//			while ((str = br.readLine()) != null)
//			{
//				display += str
//			}
//			//pane.setText("A detailed analysis file has been created: analysis.txt");
//			textArea.setText(displaystr);
//			
//
//		}
//		catch (IOException ex)
//		{
//			textArea.setText("No analysis file has been created yet");
//		}
		
	}
	
	

}
