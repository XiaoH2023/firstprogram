import java.util.Scanner;
public class GPAtoPercent {
    public static void main(String[] args) {
        double gpa;
        int percent;
        
        System.out.println("Enter a number for GPA and press ENTER:");

        //input GPA
        Scanner inputScanner = new java.util.Scanner(System.in);
        while(true) {
            gpa = inputScanner.nextDouble();
    
            if (gpa > 4.0 || gpa < 0) {
                System.out.println("GPA must be in the range between 0.0 and 4.0 , Please input Valid GPA again and press ENTER:");
            }  
            else {
                System.out.println("GPA You typed: " + gpa  );
                break;
            }  
        }
        inputScanner.close();

        //Convert GPA to Percent
        if (gpa == 4.0){
            System.out.println("GPA: " + gpa + " to Percent Range: 100 % to 95.0%");
        }else if(gpa < 1.0){
            System.out.println("GPA: " + gpa + " to Percent Range: < 65.0 % to 0.0%");
        }else{
            percent = (int)(gpa * 10)  + 55;
            System.out.println("GPA: " + gpa + " to Percent Range: < "+ (percent+1) +".0 % to " + percent + ".0%");
        }
 
    }
}
