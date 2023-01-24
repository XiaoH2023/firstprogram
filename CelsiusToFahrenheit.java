public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        double celsiusDgrees;
        double fahrenheitDgrees;
        
        celsiusDgrees = 36.0;

        // Convert C to F
        fahrenheitDgrees = celsiusDgrees * 9/5 + 32;

        System.out.print(celsiusDgrees + " degrees in Celsius is "+ fahrenheitDgrees + " degree in Fahrenheit.");

    }
}
