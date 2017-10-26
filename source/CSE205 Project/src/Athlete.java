public class Athlete
{
  private String firstName;
  private String lastName;
  private String sport;
  private BirthInfo birth;
  
  public Athlete()
  {
    this.firstName = "?";
    this.lastName = "?";
    this.sport = "?";
    this.birth = new BirthInfo();
  }
  
  public String getFirstName()
  {
    return this.firstName;
  }
  
  public String getLastName()
  {
    return this.lastName;
  }
  
  public String getSport()
  {
    return this.sport;
  }
  
  public BirthInfo getBirthInfo()
  {
    return this.birth;
  }
  
  public void setFirstName(String first)
  {
    this.firstName = first;
  }
  
  public void setLastName(String last)
  {
    this.lastName = last;
  }
  
  public void setSport(String someSport)
  {
    this.sport = someSport;
  }
  
  public void setBirthInfo(int date, int month, int year, String city, String state)
  {
    this.birth.setDate(date);
    this.birth.setMonth(month);
    this.birth.setYear(year);
    this.birth.setCity(city);
    this.birth.setState(state);
  }
  
  public String toString()
  {
    return 
    
      "\nName:\t" + getLastName() + "," + getFirstName() + "\n" + "Sport:\t" + getSport() + "\n" + this.birth.toString() + "\n\n";
  }
}
