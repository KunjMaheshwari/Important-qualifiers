import java.util.*;

class Hackers{
    public static int calculateSum(String part){
        int sum = 0;
        for(int i=0;i<part.length();i++){
            sum += (int)part.charAt(i);
        }
        return sum;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word");
        String word = sc.nextLine();

        if(word.matches("[0-9!@#$%^&* ]+")){
            System.out.println("Invalid word");
            return;
        }

        if(word.length() < 2){
            System.out.println("Invalid word");
            return;
        }

        int mid = word.length()/2;
        String left = word.substring(0, mid);
        String right = (word.length() % 2 == 0) ? word.substring(mid) : word.substring(mid+1);

        if(calculateSum(left) != calculateSum(right)){
            System.out.println("Word is not balanced");
        }else{
            System.out.println("Word is balanced");
        }

    }
}