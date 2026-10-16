
import java.util.*;
public class ExceptionDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
 int arr[]= new int [5];
 arr[4]= 10/0;

        int divident= sc.nextInt();
        int divisor= sc.nextInt();
        try {
            int result = divident / divisor;
            System.out.println("your answer is " + result);

        }catch (ArithmeticException |ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println("divisor cant be zero ");
        }


    }
}
