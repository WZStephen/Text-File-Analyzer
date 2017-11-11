//This class is to store all inputed address and information of file by user

import java.util.ArrayList;
import java.text.*;

public class Fileinfo {
	
	private ArrayList fileaddresslist;
	private String fileaddress;
	private int numoflies;
	private int numofblanklines;
	private int numofspaces;
	private int numofwords;
	private double averageCperline;
	private int averageWlength;
	private char mostcommonword;
	//private fileaddress fileaddress;
	public Fileinfo()
	{
		fileaddress = "?";
		numoflies = 0;
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
		return numoflies;
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
	
	
	public void setnumoflies(int linecounter) //set the value of input to class
	{
		numoflies = linecounter;
	}
	public void setnumofblanklines(int blanklinecounter)
	{
		numofblanklines = blanklinecounter;
	}
	public void setavecharperline(double numofcharperline)
	{
		averageCperline  =  numofcharperline;
	}
	
	public String toString()
	{
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String result;
		result = "das" + numoflies ;
		return result;
		
		
	}
	

	
	
}
