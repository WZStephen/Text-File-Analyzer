public class VehicleParser
{
  public static Vehicle parserStringToVehicle(String lineToParse)
  {
    String[] r = lineToParse.split("/");
    Vehicle vehicle = null;
    for (int i = 0; i < r.length; i++) {
      if (r[0].equals("UsedVehicle")) {
        vehicle = new UsedVehicle(r[1], Integer.parseInt(r[2]), r[3], r[4], Integer.parseInt(r[5]));
      } else if (r[0].equals("NewVehicle")) {
        vehicle = new NewVehicle(r[1], Integer.parseInt(r[2]), r[3], Double.parseDouble(r[4]));
      }
    }
    return vehicle;
  }
}
