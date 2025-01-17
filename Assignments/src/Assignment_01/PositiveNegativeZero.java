package Assignment_01;

import java.util.Scanner;

public class PositiveNegativeZero {

    public static void main(String[] args) {

        int numb;

        System.out.print("Enter Your Integer Value : ");
        numb=new Scanner(System.in).nextInt();

        if(numb < 0){
            System.out.println("Negative");
        }else {
            System.out.println("Positive");
        }
    }
}
