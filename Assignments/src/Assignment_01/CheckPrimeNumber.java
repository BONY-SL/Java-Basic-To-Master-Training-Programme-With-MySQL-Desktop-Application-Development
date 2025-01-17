package Assignment_01;

import java.util.Scanner;

public class CheckPrimeNumber {

    public static void main(String[] args) {

        int numb;

        System.out.print("Enter Your Integer Value : ");
        numb=new Scanner(System.in).nextInt();



        if(numb <= 1){
            System.out.println(numb+" is Not a Prime Number...");
        }else {

            int x=1;
            int count = 0;
            while (x<=numb){

                if(numb % x == 0){
                    count = count + 1;
                }
                x++;
            }
            if(count == 2){
                System.out.println(numb+" is a Prime Number...");
            }else {
                System.out.println(numb+" is Not a Prime Number...");
            }
        }

    }
}
