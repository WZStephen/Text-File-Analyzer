public class UsedVehicle
  extends Vehicle
{
  String preoviousLicenseState;
  int currentYear;
  
  public UsedVehicle(String make, int modelYear, String power, String previousState, int currentYear)
  {
    super(make, modelYear, power);
    this.preoviousLicenseState = previousState;
    this.currentYear = currentYear;
  }
  
  public void computeLicenseFee()
  {
    int titleTransferFee = 15;int smogWaiverFee = 8;int baseFee = 100;int smogAbatement = 20;
    if ((this.currentYear - this.modelYear >= 5) && (this.motivePower.equals("gas"))) {
      this.licenseFee = (baseFee + titleTransferFee + smogWaiverFee + smogAbatement);
    } else if ((this.currentYear - this.modelYear < 5) && (this.motivePower.equals("gas"))) {
      this.licenseFee = (titleTransferFee + baseFee + smogAbatement);
    } else if ((this.currentYear - this.modelYear < 5) && (!this.motivePower.equals("gas"))) {
      this.licenseFee = (baseFee + titleTransferFee);
    } else if ((this.currentYear - this.modelYear >= 5) && (!this.motivePower.equals("gas"))) {
      this.licenseFee = (baseFee + titleTransferFee + smogWaiverFee);
    }
  }
  
  public String toString()
  {
    String result = "\nUsed Vehicle:" + super.toString() + 
      "Years Old:\t" + (this.currentYear - this.modelYear) + "\n" + "Previous State:\t" + this.preoviousLicenseState + "\n";
    return result;
  }
}
