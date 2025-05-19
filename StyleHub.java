import java.util.*;


class Stockinfo{
    private HashSet<String> stockSet = new HashSet<>();

    public void addClothStockDetails(String stockDetails){
        stockSet.add(stockDetails);
    }

    public Set<String> filterClothItemWithinStockRange(int minimumQuantity, int maximumQuantity){
        Set<String> set = new HashSet<>();

        for(String s : stockSet){
            String parts[] = s.split(":");
            int quantity = Integer.parseInt(parts[1]);

            if(quantity >= minimumQuantity && quantity <= maximumQuantity){
                set.add(parts[0]);
            }
        }
        return set;
    }
}


public class StyleHub{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of cloths to be added");
        int n = Integer.parseInt(sc.nextLine());
        Stockinfo s = new Stockinfo();

        System.out.println("Enter the size details in the format");
        for(int i=0;i<n;i++){
            String stockDetails = sc.nextLine();
            s.addClothStockDetails(stockDetails);
        }
        System.out.println("Enter the minimum stocks quantity");
        int min = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the maximum stocks quantity");
        int max = Integer.parseInt(sc.nextLine());

        Set<String> result = s.filterClothItemWithinStockRange(min, max);

        if(!result.isEmpty()){
            System.out.println("Cloths size with the quantity between "+ min + " and "+ max);
            for(String str : result){
                System.out.println(str);
            }
        }else{
            System.out.println("No cloths found");
        }
    }
}