//This class will be enable user to search and analysis
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;

public class OpenFilePanel extends JPanel 
{

	   private ArrayList filelist;
	   private JPanel toolpanel, subpanel;
	   private JLabel msg1, msg2;
	   private JTextField filename;
	   private JScrollPane scroll;
	   private JButton Analyze, Browse, loadmorefile;
	   private AnaAndRepPanel anaandreppanel;
	   
	   public OpenFilePanel(ArrayList filelist, AnaAndRepPanel apanel)
	   {
		   this.filelist = filelist;
		   this.anaandreppanel = apanel;
		   
		   msg1 = new JLabel("Type/Select a file to be oprend: ");   
		   msg1.setFont(new Font("Serif", Font.BOLD, 30));
		   
		   msg2 = new JLabel("Notification Window");
		   msg2.setForeground(Color.red);
		   msg1.setFont(new Font("Serif", Font.PLAIN, 20));
		   Analyze = new JButton("Analyze!");		  //create a 'Analyze' button and add listener on it
		   Analyze.addActionListener(new ButtonListener());
		   Browse = new JButton("Browse");            //create a 'Browse' button and add listener on it
		 
		   Browse.addActionListener(new ButtonListener());
		   loadmorefile = new JButton("...");
		   loadmorefile.addActionListener(new ButtonListener());
		   
		   filename = new JTextField("Type Filename here...");
		   	   
		   toolpanel = new JPanel();	
		   toolpanel.setLayout(new GridLayout(5,1));
		   
		   subpanel = new JPanel();
		   subpanel.setLayout(new GridLayout(1,2));
		   subpanel.add(filename);
		   subpanel.add(Browse);
		   
		   toolpanel.add(msg1);
		   toolpanel.add(subpanel);
		   toolpanel.add(loadmorefile);
		   toolpanel.add(Analyze);
	   	   toolpanel.add(msg2);
	   	   toolpanel.setPreferredSize(new Dimension(500	,400));
		   scroll = new JScrollPane(toolpanel);
		   add(scroll);
				 	   
	   }   
	   
	   
	   private class ButtonListener implements ActionListener
	   {
		   
		   public void actionPerformed(ActionEvent event)
		     { 
			   File file = new File(filename.getText()); //read the file by address
			   if(event.getSource() == Browse)  //find the location of file, get address
			   {
				   String fileaddress;
				   JFileChooser fileChooser = new JFileChooser();		
				   FileFilter filter = new FileNameExtensionFilter("Text/CSV file", "txt", "csv");//set the types of files
				   fileChooser.addChoosableFileFilter(filter);				   				   
			       int rVal = fileChooser.showOpenDialog(null);
			        if (rVal == JFileChooser.APPROVE_OPTION) 
			        	filename.setText(fileChooser.getSelectedFile().toString());	
			        
			        fileaddress = filename.getText();
			        msg2.setText(fileaddress);			        			      		        
			   }  
			   else if (event.getSource() == loadmorefile)
			   {
				   String fileaddress;
				   JFileChooser fileChooser = new JFileChooser();		
				   FileFilter filter = new FileNameExtensionFilter("Text/CSV file", "txt", "csv");//set the types of files
				   fileChooser.addChoosableFileFilter(filter);				   				   
			       int rVal = fileChooser.showOpenDialog(null);
			        if (rVal == JFileChooser.APPROVE_OPTION) 
			        	filename.setText(fileChooser.getSelectedFile().toString());	
			        
			        fileaddress = filename.getText();
			        msg2.setText(fileaddress);	
			   }
			   else if(event.getSource() == Analyze)  //analysis the file by address
			   {
			    	   int linecounter = 0;
					   int blanklinecounter = 0;
					   int spacecounter = 0;
					   int numofwords = 0;
					   double avecharperline = 0.0;
					   double averagewordlength = 0.0;
					   String mostcommonword = "?";
					   Date anadate = null;
					  
					   
					   String st,st1,st2,st3,st4;
						BufferedReader br;
						BufferedReader br1;
						BufferedReader br2 ;
						BufferedReader br3 ;
					  //BufferedReader br4;				
					 					
				        try {

							
				        	//in = new Scanner(file);
				        	br = new BufferedReader(new FileReader(file));
				        	br1 = new BufferedReader(new FileReader(file));
				        	br2 = new BufferedReader(new FileReader(file));
				        	br3 = new BufferedReader(new FileReader(file));
				          //br4 = new BufferedReader(new FileReader(file));
				        	
							while((st = br.readLine()) != null)  //get # lines
							{
								linecounter++;		
							}
							//msg2.setText(String.valueOf(linecounter));	
							
							while((st1 = br1.readLine())!= null) //get # blank lines
							{
								if(st1 != null && st1.trim().equals( "" ))
								{
									blanklinecounter++;
								}
							}
												
							while((st2 = br2.readLine()) != null) //get # spaces
							{
								for(int i = 0; i < st2.length(); i++) 
								{
								     if(Character.isWhitespace(st2.charAt(i))) 
								    	 spacecounter++;
								}
							}
							
																
							int numofchar = 0;
							while((st3 = br3.readLine()) != null)  //count the the average character perline
							{
								
								for(int i = 0; i < st3.length(); i++) 
								{								
									if(Character.isWhitespace(st3.charAt(i))) 
									{
										continue;	
									}
									numofchar++;
								}							
							}
							
							numofwords = spacecounter + 2;
							
							avecharperline = numofchar/linecounter;   //set Average chars per line
							//msg2.setText(String.valueOf(averagewordlength)); //store the number of word length to fileinfo class
							
							averagewordlength = numofchar/ (spacecounter + 2); //set Average word length
							
							
							//count the most common word
					        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();				  
					        BufferedReader reader = null;      
					        try
					        {
					            //Creating BufferedReader object
					             
					            reader = new BufferedReader(new FileReader(file));
					             
					            //Reading the first line into currentLine
					             
					            String currentLine = reader.readLine();
					             
					            while (currentLine != null)
					            {    
					                //splitting the currentLine into words
					                 
					                String[] words = currentLine.toLowerCase().split(" ");
					                 
					                //Iterating each word
					                 
					                for (String word : words)
					                {
					                    //if word is already present in wordCountMap, updating its count
					                     
					                    if(wordCountMap.containsKey(word))
					                    {    
					                        wordCountMap.put(word, wordCountMap.get(word)+1);
					                    }
					                     
					                    //otherwise inserting the word as key and 1 as its value
					                    else
					                    {
					                        wordCountMap.put(word, 1);
					                    }
					                }
					                 
					                //Reading next line into currentLine
					                 
					                currentLine = reader.readLine();
					            }
					             
					            //Getting the most repeated word and its occurrence
					             
					            String mostRepeatedWord = null;
					             
					            int count = 0;
					             
					            Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
					             
					            for (Entry<String, Integer> entry : entrySet)
					            {
					                if(entry.getValue() > count)
					                {
					                    mostRepeatedWord = entry.getKey();
					                     
					                    count = entry.getValue();
					                }
					            }
					             
					            mostcommonword = mostRepeatedWord;
					           // msg2.setText(mostRepeatedWord);
					            //System.out.println("The most repeated word in input file is : "+mostRepeatedWord);
					             
					            //System.out.println("Number Of Occurrences : "+count);
					        } 
					        catch (IOException e) 
					        {
					            e.printStackTrace();
					        }
					        finally
					        {
					            try
					            {
					                reader.close();           //Closing the reader
					            }
					            catch (IOException e) 
					            {
					                e.printStackTrace();
					            }
					        }
					        
					        //record the current analysis time
					        anadate = new Date();					
							  
  //--------------------------------------------------------------------------------------------------------
							BufferedWriter writer = null;	// writes to a textfile of the details of a file analyzed
							try 
							{
							    writer = new BufferedWriter( new FileWriter("Analysis list.txt", true));
							    writer.write(filename.getText() + ";");
							    writer.write(linecounter + ";");
							    writer.write(blanklinecounter + ";");
							    writer.write(spacecounter + ";"); 
							    writer.write(numofwords + ";");
							    writer.write(avecharperline + ";");
							    writer.write(averagewordlength + ";");
							    writer.write(mostcommonword+ ";");
							    writer.write(anadate+"~");
							}
							catch (IOException eee)
							{}
							finally 
							{
							    try
							    {
							        if ( writer != null)
							        writer.close( );
							    }
							    catch (IOException ee)
							    {
							    }
							}
						} 
				         catch(NumberFormatException | IOException ex)
				        {
				   		 msg2.setText("Invalid File Address!");
				   		 msg2.setVisible(true);
				   	   	}
				        
				        msg2.setText("File Added");
				        msg2.setVisible(true);
				        

				
			   }
			   else 			
			   {
				   //the '...' button for handling more files
			   }
		     }		
	   }
}





















