package Assignment_01;

import java.util.Scanner;

public class AreaRectangle {

    public static void main(String[] args){

        double length1,length2;

        Scanner input;

        input = new Scanner(System.in);

        System.out.print("Enter Length x : ");
        length1=input.nextDouble();

        System.out.print("Enter Length y : ");
        length2=input.nextDouble();

        System.out.println("Area of Rectangle : "+(length1*length2));
    }
}
