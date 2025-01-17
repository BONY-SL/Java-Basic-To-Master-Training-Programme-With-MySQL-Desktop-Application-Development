package Assignment_01;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        int numb;

        System.out.print("Enter Your Integer Value : ");
        numb=new Scanner(System.in).nextInt();

        int x=1;

        long fact =1;

        while (x <= numb){

            fact = fact * x;
            x++;
        }

        System.out.println("Factorial of 5 is: " + fact);

    }
}
