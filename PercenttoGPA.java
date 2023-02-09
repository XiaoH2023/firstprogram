import java.util.Scanner;
public class PercenttoGPA {
    public static void main(String[] args) {

         double gpa, percent;
         int iPercent;
        
        System.out.println("Enter a number for Percent and press ENTER:");

        //input Percent
        Scanner inputScanner = new java.util.Scanner(System.in);
        while(true) {
            percent = inputScanner.nextDouble();
    
            if (percent > 100.0 || percent < 0) {
                System.out.println("Percent must be in the range between 0.0 and 100.0 , Please input Valid PERCENT again and press ENTER:");
            }  
            else {
                System.out.println("PERCENT You typed: " + percent );
                break;
            }  
        }
        inputScanner.close();

        //Convert GPA to Percent
        if (percent >= 95){
            System.out.println("Percent: " + percent + " to GPA: 4.0");
        }else if(percent < 65){
            System.out.println("Percent: " + percent + " to GPA: 0.0");
        }else{
            iPercent = (int)percent - 55;
            gpa = (double)iPercent / 10;

            System.out.println("Percent: " + percent + " to GPA: " + String.format("%.1f", gpa));
        }
 
    }
}
