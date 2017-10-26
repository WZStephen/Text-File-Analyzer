import java.text.NumberFormat;

public class NewVehicle
  extends Vehicle
{
  double vehiclePrice;
  NumberFormat nf = NumberFormat.getCurrencyInstance();
  
  public NewVehicle(String make, int modelYear, String power, double price)
  {
    super(make, modelYear, power);
    this.vehiclePrice = price;
  }
  
  public void computeLicenseFee()
  {
    int baseFee = 150;int smogAbatementFee = 20;
    if (this.motivePower.equals("gas")) {
      this.licenseFee = (baseFee + smogAbatementFee + this.vehiclePrice * 0.15D);
    } else {
      this.licenseFee = (baseFee + this.vehiclePrice * 0.15D);
    }
  }
  
  public String toString()
  {
    String result = "\nNew Vehicle:" + super.toString() + "Price:\t\t" + this.nf.format(this.vehiclePrice) + "\n";
    return result;
  }
}
