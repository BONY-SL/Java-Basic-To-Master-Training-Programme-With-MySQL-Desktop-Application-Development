package Assignment_01;

import java.util.Scanner;

public class CircumferenceCircle {

    public static void main(String[] args) {

        double radian;

        System.out.print("Enter radian Value : ");
        radian=new Scanner(System.in).nextDouble();
        System.out.println("Circumference of Circle : "+ (2*(22/7.0)*radian));
    }
}
