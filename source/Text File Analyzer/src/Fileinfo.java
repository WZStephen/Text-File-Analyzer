//This class is to store all inputed address and information of file by user

import java.text.*;

public class Fileinfo {

	private int numoflines;
	private int numofblanklines;
	private int numofspaces;
	private int numofwords;
	private double averageCperline;
	private double averageWlength;
	private String mostcommonword;

	
	public Fileinfo()
	{
		numoflines = 2;
		numofblanklines = 0;
		numofspaces = 0;
		numofwords = 0;
		averageCperline = 0;
		averageWlength = 0.0;
		averageCperline = 0.0;
		mostcommonword = "?";		
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
	
	public void setavecharperline(double averageCperline)
	{
		this.averageCperline  =  averageCperline;
	}
	
	public void setavewordlength(double averageWlength)
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
		result = "num of lines: " + numoflines ;
		return result;		
	}	
}