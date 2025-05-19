import java.util.*;

public class University{

    private HashMap<String, Double> map = new HashMap<>();

    public void addUniversityDetails(String universityName, double totalStudyExpense){
        map.put(universityName, totalStudyExpense);
    }

    public List<String> filterBudgetUniversity(double budgetAmount){
        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() <= budgetAmount){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        University u = new University();
        
        System.out.println("Enter the number of university records to be added:");
        int n = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter university details");
        for(int i = 0; i < n; i++){
            String input = sc.nextLine();
            String parts[] = input.split(":");
            String uniName = parts[0];
            double uniexpense = Double.parseDouble(parts[1]);

            u.addUniversityDetails(uniName, uniexpense);
        }

        System.out.println("Enter the student budget:");
        double budget = sc.nextDouble();

        if(budget < 0){
            System.out.println("Invalid budget");
            return;
        }
        
        List<String> finalList = u.filterBudgetUniversity(budget);

        if(!finalList.isEmpty()){
            System.out.println("Universities within budget: ");
            int size = finalList.size();
            for(int i = 0; i < size; i++){
                System.out.println(finalList.get(i));
            }
        }else{
            System.out.println("No universities found within the budget.");
        }
        
        sc.close();
    }
}
