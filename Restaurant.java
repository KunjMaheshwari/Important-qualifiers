import java.util.*;

class ServicePartner{
    protected String partnerId;
    protected String partnerName;
    protected String contactNumber;
    protected double orderAmount;

    public ServicePartner(){};

    public ServicePartner(String partnerId, String partnerName, String contactNumber, double orderAmount){
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.contactNumber = contactNumber;
        this.orderAmount = orderAmount;
    }

    public ServicePartner(String partnerId, String partnerName, String contactNumber){
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.contactNumber = contactNumber;
    }



    public String getPartnerId(){
        return partnerId;
    }

    public void setPartnerId(String partnerId){
        this.partnerId = partnerId;
    }

    public String getPartnerName(){
        return partnerName;
    }

    public void setPartnerName(String partnerName){
        this.partnerName = partnerName;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }


    public double getOrderAmount(){
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount){
        this.orderAmount = orderAmount;
    }
}

class RestaurantPartner extends ServicePartner{
    private double discountPercentage;
    private double taxPercentage;

    public RestaurantPartner(String partnerId, String partnerName, String contactNumber, double discountPercentage, double taxPercentage){
        super(partnerId, partnerName, contactNumber);
        this.discountPercentage = discountPercentage;
        this.taxPercentage = taxPercentage;
    }

    public RestaurantPartner(String partnerId, String partnerName, String contactNumber, double orderAmount, double discountPercentage, double taxPercentage){
        super(partnerId, partnerName, contactNumber, orderAmount);
        this.discountPercentage = discountPercentage;
        this.taxPercentage = taxPercentage;
    }

    public double calculateOrderCost(){
        double finalCost = 0.0;
        double tax = taxPercentage/100.0;
        double discount = discountPercentage/100.0;
        if(orderAmount > 500){
            finalCost = (orderAmount) + (orderAmount*tax) - (orderAmount*discount);
        }else{
            finalCost += (orderAmount) + (orderAmount*tax);
        }
        return finalCost;
    }
}

class DeliveryPartner extends ServicePartner{
    private double distanceinKm;
    private double deliveryRatePerKm;

    public DeliveryPartner(String partnerId, String partnerName, String contactNumber, double orderAmount, double distanceinKm, double deliveryRatePerKm){
        super(partnerId, partnerName, contactNumber, orderAmount);
        this.distanceinKm = distanceinKm;
        this.deliveryRatePerKm = deliveryRatePerKm;
    }

    public double getDistanceinKm(){
        return distanceinKm;
    }

    public void setDistanceinKm(double distanceinKm){
        this.distanceinKm = distanceinKm;
    }

    public double getDeliveryRatePerKm(){
        return deliveryRatePerKm;
    }

    public void setDeliveryRatePerKm(double deliveryRatePerKm){
        this.deliveryRatePerKm = deliveryRatePerKm;
    }

    public double calculateDeliveryCharge(){
        if(orderAmount >= 200000){
            return 0.0;
        }else{
            if(distanceinKm > 10){
                return distanceinKm*deliveryRatePerKm+50;
            }
            return distanceinKm*deliveryRatePerKm;
        }
    }
}


public class Restaurant{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter partner details");

        String input = sc.nextLine();
        String parts[] = input.split(":");

        if(parts[0].equals("Restaurant")){
            String partnerId = parts[1];
            String partnerName = parts[2];
            String contactNumber = parts[3];
            double orderAmount = Double.parseDouble(parts[4]);
            double discountPercentage = Double.parseDouble(parts[5]);
            double taxPercentage = Double.parseDouble(parts[6]);

            RestaurantPartner rp = new RestaurantPartner(partnerId, partnerName, contactNumber, orderAmount, discountPercentage, taxPercentage);

            System.out.println("Calculated order cost for Restaurant Partner Spicy is "+ rp.calculateOrderCost());
        }

        if(parts[0].equals("Delivery")){
            String partnerId = parts[1];
            String partnerName = parts[2];
            String contactNumber = parts[3];
            double orderAmount = Double.parseDouble(parts[4]);
            double distanceinKm = Double.parseDouble(parts[5]);
            double deliveryRatePerKm = Double.parseDouble(parts[6]);

            DeliveryPartner dp = new DeliveryPartner(partnerId, partnerName, contactNumber, orderAmount, distanceinKm, deliveryRatePerKm);

            System.out.println("Calculated order cost for Delivery Partner Spicy is "+ dp.calculateDeliveryCharge());
        }
    }
}