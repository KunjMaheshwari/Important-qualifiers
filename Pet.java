import java.util.*;

class PetInfo{
    TreeSet<String> set = new TreeSet<>();

    public void addPetDetails(String petDetails){
        set.add(petDetails);
    }

    public TreeSet<String> filterPetsByAgeAndBread(int ageInMonth, String breed){
        TreeSet<String> newSet = new TreeSet<>();

        for(String s : set){
            String parts[] = s.split(":");
            String petName = parts[0];
            String petBreed = parts[1];
            int petAge = Integer.parseInt(parts[2]);

            if((petAge <= ageInMonth) && petBreed.equals(breed)){
                newSet.add(petName);
            }
        }
        return newSet;
    }
}

public class Pet{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PetInfo pf = new PetInfo();

        System.out.println("Enter the number of pets to add");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter pet details in the format(Name:Breed:AgeInMonth)");

        for(int i=0;i<n;i++){
            String input = sc.nextLine();
            pf.addPetDetails(input);
        }

        System.out.println("Enter the maximum age in months to filter");
        int maxAge = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the breed to filter");
        String inputBreed = sc.nextLine();

        System.out.println("Pets matching the criterion");
        
        TreeSet<String> result = pf.filterPetsByAgeAndBread(maxAge, inputBreed);

        if(!result.isEmpty()){
            for(String s : result){
                System.out.println(s);
            }
        }else{
            System.out.println("No "+ inputBreed+" pets are available that are "+ maxAge+" old or younger");
            return;
        }
    }
}
