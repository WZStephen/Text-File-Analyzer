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
	private int averageCperline;
	private int averageWlength;
	private char mostcommonword;
	//private fileaddress fileaddress;
	public Fileinfo(ArrayList fileaddresslist)
	{
		fileaddress = "?";
		numoflies = 0;
		numofblanklines = 0;
		numofspaces = 0;
		numofwords = 0;
		averageCperline = 0;
		averageWlength = 0;
		mostcommonword = '\0';		
	}
	public int getnumoflines()
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
	public int getaverageCperline()
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
	public void setnumoflies(int linecounter)
	{
		numoflies = linecounter;
	}
	
	
	
	
}
