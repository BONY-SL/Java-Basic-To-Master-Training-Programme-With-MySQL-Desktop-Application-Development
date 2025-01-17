package Assignment_01;

import java.util.Scanner;

public class SwapTwoNumbers {

    public static void main(String[] args) {

        int numb1,numb2;

        System.out.print("Enter Number one : ");
        numb1=new Scanner(System.in).nextInt();
        System.out.print("Enter Number Two : ");
        numb2=new Scanner(System.in).nextInt();

        System.out.println("Before Swapping : "+"Number 1 : "+numb1+" "+"Number 2 : "+numb2);

        int temp = numb1;

        numb1=numb2;

        numb2 =temp;

        System.out.println("After Swapping : "+"Number 1 : "+numb1+" "+"Number 2 : "+numb2);
    }
}
