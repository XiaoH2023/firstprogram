import java.util.Scanner;

public class CelsiusToFahrenheit2{
    public static void main(String[] args) {
        double celsiusDgrees;
        double fahrenheitDgrees;
        
        System.out.println("Type double and press ENTER");

        Scanner inputScanner = new java.util.Scanner(System.in);
        celsiusDgrees = inputScanner.nextDouble();
        inputScanner.close();

        System.out.println("\n CelsiusDgrees You typed: " + celsiusDgrees + " \n" );

        // Convert C to F
        fahrenheitDgrees = celsiusDgrees * 9/5 + 32;

        System.out.print(celsiusDgrees + " degrees in Celsius is "+ fahrenheitDgrees + " degree in Fahrenheit.");

    }
}
