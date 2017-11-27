//This class is to store all inputed address and information of file by user
package cse360;

import java.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.*;

public class Fileinfo {

	private int numoflines;
	private int numofblanklines;
	private int numofspaces;
	private int numofwords;
	private int averageCperline;
	private int averageWlength;
	private String mostcommonword;
	

	
	public Fileinfo() throws IOException
	{
		
		/*numoflines = 0;
		numofblanklines = 0;
		numofspaces = 0;
		numofwords = 0;
		averageCperline = 0;
		averageWlength = 0.0;
		averageCperline = 0.0;
		mostcommonword = "?";*/	
		
		File file = new File("analysis.txt"); //hello
		// reads the textfile 'analysis.txt' that contained the detailed analysis of each file 
		
		String[] data = new String[100];
		
		
			BufferedReader br = new BufferedReader(new FileReader(file));
			//ArrayList<Integer> numbers = new ArrayList<Integer>();	
			String str;
			int i = 0;
			while((str = br.readLine()) != null)  // while there exists lines to read in the text file
			{
				data[i] = str;
				System.out.println(data[i]);
				i++;
			}
			br.close();
			
			/*String[][] root;
			
			List<String> list = Files.readAllLines(Paths.get("analysis.txt"), StandardCharsets.UTF_8);
			
			root = new String[list.size()][];
			
			list.removeAll(Arrays.asList("", null)); 	// removes empty lines
			
			for (int a = 0; a < list.size(); a++)
			{
				root[a] = list.get(a).split(" ");
			}
			
			String changedlines;
			
			for (int c = 0; c < list.size(); c++)
			{
				changedlines.equals(list.get(c).replaceAll(" ", "")); 	// remove all white/null space
				list.set(c, changedlines);
			}
			for (int k = 0; k < list.get(0).size(); k++)
			{
				try {
					Integer.parseInt(list.get(0).substring(k, k+1));
				}
				catch (NumberFormatException e)
				{
					
				}
			}*/
		
		/*int j = 1;
		Scanner scanner = new Scanner(new File("analysis.txt"));
		int [] data = new int [100];
		String str;
		int i = 0;
		
		while(scanner.hasNextInt())
		{
			//str = "file" + j;
			data[i++] = scanner.nextInt();
			
		}
		j++;*/
		/*
		numoflines = data[1];
		numofblanklines = data[2];
		numofspaces = data[3];
		numofwords = data[4];
		averageCperline = data[5];
		averageWlength = data[6];
		averageCperline = data[7];*/
		//mostcommonword = "?";	
		
		//scanner.close();
		
		/*try 
		{

			String str;
			//while((str = br.readLine()) != null)  // while there exists lines to read in the text file
			{
				//textArea.append(str);
				//textArea.append(System.getProperty("line.separator"));
			}
			//br.close();
		}
		catch (IOException e)
		{
			 e.printStackTrace();
		}*/
	
	}
    /*public static void readFile(File file, StringBuffer buf)
            throws IOException
        {
        FileReader fr = null;
        for (int i = 1; i < 10; i++)
        {
            try {
                fr = new FileReader("analysis" + i + ".txt");
                BufferedReader br = new BufferedReader(fr);
                char[] cbuf = new char[(int) file.length()];
                br.read(cbuf);  
                buf.append(cbuf);
                br.close();
              }
              finally {
                if (fr != null) {
                  fr.close();
                }
              }
        }

    }*/
	public int getnumoflines()  //get the value from class
	{
		return numoflines;
	}	
	public int getnumofblanklines()
	{
		return numofblanklines;
	}
	public int getnumofspaces()
	{
		return numofspaces;
	}
	public int getnumofwords()
	{
		return numofwords;
	}
	public int getaverageCperline()
	{
		return averageCperline;
	}
	public int getaverageWlength()
	{
		return averageWlength;
	}
	public String getmostcommonword()
	{
		return mostcommonword;
	}
	public void setnumoflies(int linecounter) //set the value of input to class
	{
		numoflines = linecounter;
	}
	
	public void setnumofblanklines(int blanklinecounter)
	{
		numofblanklines = blanklinecounter;
	}
	
	public void setnumofspaces(int spacecounter)
	{
		numofspaces = spacecounter;
	}
	
	public void setnumofwords(int wordscounter)
	{
		numofwords = wordscounter;
	}
	
	public void setavecharperline(int averageCperline)
	{
		this.averageCperline  =  averageCperline;
	}
	
	public void setavewordlength(int averageWlength)
	{
		this.averageWlength = averageWlength;
	}
	
	public void setmostcommonword(String mostcommonword)
	{
		this.mostcommonword = mostcommonword;
	}
	
	public String toString()
	{
        //NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String result;
		result = "files";
		return result;		
	}	
}