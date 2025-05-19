import java.util.*;

class EVChargingStation{
    private String stationName;
    private String providerName;
    private String city;
    private int totalChargingPoints;

    public EVChargingStation(String stationName, String providerName, String city, int totalChargingPoints){
        this.stationName = stationName;
        this.providerName = providerName;
        this.city = city;
        this.totalChargingPoints = totalChargingPoints;
    }

    public String getStationName(){
        return stationName;
    }

    public void setStationName(String stationName){
        this.stationName = stationName;
    }

    public String getProviderName(){
        return providerName;
    }

    public void setProviderName(String providerName){
        this.providerName = providerName;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public int getTotalChargingPoints(){
        return totalChargingPoints;
    }

    public void setTotalChargingPoints(int totalChargingPoints){
        this.totalChargingPoints = totalChargingPoints;
    }

    public double calculateChargingCost(String evType, int count){
        if(evType.equalsIgnoreCase("small")){
            return count*150.0*totalChargingPoints;
        }else if(evType.equalsIgnoreCase("large")){
            return count*totalChargingPoints*300.0;
        }
        return -1;
    }
}

public class EV{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the station name");
        String stationName = sc.nextLine();

        System.out.println("Enter the provider name");
        String providerName = sc.nextLine();

        System.out.println("Enter the city");
        String city = sc.nextLine();

        System.out.println("Enter the total charging count");
        int totalChargingPoints = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the EV Type and count");
        String evType = sc.nextLine();
        int count = Integer.parseInt(sc.nextLine());

        EVChargingStation evcs = new EVChargingStation(stationName, providerName, city, totalChargingPoints);

        double cost = evcs.calculateChargingCost(evType, count);

        if(cost == -1 || count < 0 || totalChargingPoints < 0){
            System.out.println("Invalid EV Type");
            return;
        }

        if(!evType.equalsIgnoreCase("Small") || !evType.equalsIgnoreCase("Large")){
            System.out.println("Invalid EV type");
            return;
        }

        System.out.println("Station name: "+ evcs.getStationName());
        System.out.println("Provider Name: "+ evcs.getProviderName());
        System.out.println("City: "+ evcs.getCity());
        System.out.println("Total Charging Points: "+ evcs.getTotalChargingPoints());
        System.out.println("Estimated Cost: "+ cost);

        sc.close();
    }
}