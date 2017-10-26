public class BirthInfo
{
  private int date;
  private int month;
  private int year;
  private String city;
  private String state;
  
  public BirthInfo()
  {
    this.date = 0;
    this.month = 0;
    this.year = 0;
    this.city = "?";
    this.state = "?";
  }
  
  public void setDate(int date2)
  {
    this.date = date2;
  }
  
  public void setMonth(int month2)
  {
    this.month = month2;
  }
  
  public void setYear(int year2)
  {
    this.year = year2;
  }
  
  public void setCity(String city2)
  {
    this.city = city2;
  }
  
  public void setState(String state2)
  {
    this.state = state2;
  }
  
  public String toString()
  {
    return 
    
      "Date of Birth:\n" + this.month + "/" + this.date + "/" + this.year + "\n" + "Place of Birth:\n" + this.city + "," + this.state + "\n";
  }
}
