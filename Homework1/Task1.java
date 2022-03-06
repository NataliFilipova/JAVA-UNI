package Nbu.java;


import java.io.BufferedReader;
import java.util.Scanner;


public class Main {

    public static int countNumbers(int bottom, int top, int difference) {

        int count = 0;

        if(bottom < 0 || top < 0){
            return 0;
        }
        if(bottom == 0){
            bottom += 1;
        }

        for(int i = bottom; i <= top; i++){

            if(reverseNum(i) - i >= difference){
                count++;
            }

        }
        return count;
    }
    public static int reverseNum(int n)
    {
        int tmp = n;

        n = n * 10;

        while (tmp >= 10)
            tmp /= 10;

        n += tmp;

        n = n % (int) Math.pow(10, (int) Math.log10(n));

        return n;
    }

    public static void main(String[] args)  {

        Scanner sc=new Scanner(System.in);
        int bottom = sc.nextInt();
        int top = sc.nextInt();
        int difference = sc.nextInt();



        int n = countNumbers(bottom, top, difference);

        System.out.println(n);

    }
}
