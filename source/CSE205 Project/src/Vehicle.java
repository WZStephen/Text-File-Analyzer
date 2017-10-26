import java.text.NumberFormat;

public abstract class Vehicle
{
  protected String make;
  protected int modelYear;
  protected String motivePower;
  protected double licenseFee;
  NumberFormat nf = NumberFormat.getCurrencyInstance();
  
  public Vehicle(String make, int modelYear, String power)
  {
    this.make = make;
    this.modelYear = modelYear;
    this.motivePower = power;
    this.licenseFee = 0.0D;
  }
  
  public int getmodelYear()
  {
    return this.modelYear;
  }
  
  public abstract void computeLicenseFee();
  
  public String toString()
  {
    String result = "\nMake:\t\t" + this.make + "\n" + 
      "Model Year:\t" + this.modelYear + "\n" + 
      "Motive Power:\t" + this.motivePower + "\n" + 
      "License Fee:\t" + this.nf.format(this.licenseFee) + "\n";
    return result;
  }
}
