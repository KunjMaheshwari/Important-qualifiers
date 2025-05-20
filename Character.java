import java.util.*;

public class Character {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence:");
        String str = sc.nextLine();

        if(!str.matches("[a-zA-Z ]+")){ // Allowing spaces in the sentence
            System.out.println("Invalid sentence input");
            return;
        }

        System.out.println("Enter the character to be searched:");
        char c = sc.next().charAt(0); // Read only a single character

        System.out.println("Enter the character to be replaced:");
        char d = sc.next().charAt(0); // Read only a single character

        if (!Character.isLetter(d)) {
            System.out.println("Invalid character input");
            return;
        }

        int index = str.indexOf(c);
        if(index != -1){
            char[] strArray = str.toCharArray();
            strArray[index] = d;
            str = new String(strArray);
            System.out.println(str);
        }else{
            System.out.println("Character is not found in the string");
        }

        sc.close();
    }
}
