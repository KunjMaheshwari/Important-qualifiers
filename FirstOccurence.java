import java.util.*;


public class FirstOccurence{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String str = sc.nextLine();

        System.out.println("Enter the character to be searched");
        String c = sc.nextLine();

        System.out.println("Enter the character to be replaced");
        String d = sc.nextLine();

        if(!d.matches("[a-zA-Z]+")){
            System.out.println("Inavlid character Input");
            return;
        }

        if(str.contains(c)){
            str = str.replaceFirst(c, d);
            System.out.println(str);
        }else{
            System.out.println("Character is not found in the String");
        }
    }
}
