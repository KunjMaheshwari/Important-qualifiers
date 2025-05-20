package replace;

import java.util.Scanner;

public class User_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String sentence = sc.nextLine();
		
		if(!sentence.matches("[a-zA-Z ]+")) {
			System.out.println("Invalid input");
			return;
		}
		System.out.println("Enter the first word to be replaced");
		String c = sc.nextLine();
		if(!c.matches("[a-zA-Z]+")) {
			System.out.println("Invalid character entered");
			return;
		}
		System.out.println("Enter the word to be replaced");
		String d= sc.nextLine();
		

		if(sentence.contains(c)) {
			sentence = sentence.replaceFirst(c, d);
			System.out.println(sentence);
		}else {
			System.out.println("Character is not found");
		}

	}

}



// second Method

package replace;

import java.util.Scanner;

public class User_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String sentence = sc.nextLine();
		
		if(!sentence.matches("[a-zA-Z ]+")) {
			System.out.println("Invalid input");
			return;
		}
		System.out.println("Enter the first word to be replaced");
		String c = sc.nextLine();
		if(!c.matches("[a-zA-Z]+")) {
			System.out.println("Invalid character entered");
			return;
		}

		

		if(sentence.contains(c)) {
		System.out.println("Enter the word to be replaced");
		String d= sc.nextLine();
			sentence = sentence.replaceFirst(c, d);
			System.out.println(sentence);
		}else {
			System.out.println("Character is not found");
		}

	}

}

	
