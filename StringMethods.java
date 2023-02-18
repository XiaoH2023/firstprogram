import java.util.Scanner;
import java.util.Date;

public class StringMethods {
    public static void main(String[] args) {

        String  name;
        
        System.out.println("Enter Your name and press ENTER:");

        //input name
        Scanner inputScanner = new java.util.Scanner(System.in);
		name = inputScanner.nextLine(); 
		
        while(name.isEmpty()) {
			System.out.println("Please input Valid name again and press ENTER:");
            name = inputScanner.nextLine();    
        }
        inputScanner.close();

		name = name.trim();		//all leading and trailing space removed
		
        Date date = new Date();
 		System.out.println("Hello: " + name.toUpperCase() + ". Now time: " + date);
    }
}

