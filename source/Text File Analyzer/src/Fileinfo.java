//This class is to store all inputed address and information of file by user

import java.text.*;

public class Fileinfo {

	private int numoflines;
	private int numofblanklines;
	private int numofspaces;
	private int numofwords;
	private double averageCperline;
	private double averageWlength;
	private char mostcommonword;

	
	public Fileinfo()
	{
		numoflines = 0;
		numofblanklines = 0;
		numofspaces = 0;
		numofwords = 0;
		averageCperline = 0;
		averageWlength = 0.0;
		averageCperline = 0.0;
		mostcommonword = '\0';		
	}
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
	public double getaverageCperline()
	{
		return averageCperline;
	}
	public double getaverageWlength()
	{
		return averageWlength;
	}
	public char getmostcommonword()
	{
		return mostcommonword;
	}
	
	
	public void setnumoflies(int linecounter) //set # lines
	{
		numoflines = linecounter;
	}
	public void setnumofblanklines(int blanklinecounter)//set # blank lines
	{
		numofblanklines = blanklinecounter;
	}
	public void setnumofspaces(int numofspaces) //set # spaces
	{
		this.numofspaces = numofspaces;
	}
	public void setnumofwords(int numofwords) // set # words
	{
		this.numofwords = numofwords;
	}
	public void setavecharperline(double averageCperline)// set Average chars per line
	{
		this.averageCperline  =  averageCperline;
	}
	public void setaverageWlength(double averageWlength) //set Average word length
	{
		this.averageWlength = averageWlength;
	}
	public void setmostcommonword(char mostcommonword)//set Most common words
	{
		this.mostcommonword = mostcommonword;
	}
	
	
	
	public String toString()  //testing
	{
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String result;
		result = "num of lines: " + numoflines ;
		return result;
			
	}
	

	
	
}
