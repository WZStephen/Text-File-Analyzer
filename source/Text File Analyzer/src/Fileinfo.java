//This class is to store all inputed address and information of file by user

import java.text.*;

public class Fileinfo {

	private int numoflines;
	private int numofblanklines;
	private int numofspaces;
	private int numofwords;
	private double averageCperline;
	private int averageWlength;
	private char mostcommonword;

	
	public Fileinfo()
	{
		numoflines = 2;
		numofblanklines = 0;
		numofspaces = 0;
		numofwords = 0;
		averageCperline = 0;
		averageWlength = 0;
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
	public int getaverageWlength()
	{
		return averageWlength;
	}
	public char getmostcommonword()
	{
		return mostcommonword;
	}
	
	
	public int setnumoflies(int linecounter) //set the value of input to class
	{
		numoflines = linecounter;
		return numoflines;
	}
	public void setnumofblanklines(int blanklinecounter)
	{
		numofblanklines = blanklinecounter;
	}
	public void setavecharperline(double averageCperline)
	{
		this.averageCperline  =  averageCperline;
	}
	
	public String toString()
	{
        //NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String result;
		result = "num of lines: " + numoflines ;
		return result;
			
	}
	

	
	
}