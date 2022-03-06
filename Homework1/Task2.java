package Nbu.java;

import java.util.Scanner;

public class Main {


    public static int  SumOf(int n)
    {
        if(n < 1 || n > 9){
            return 0;
        }
        int sum = 0;

        for(int i = 1; i <= n; i++){
            sum = sum+i;
            for(int j = i+1; j <= n; j++){
                sum = sum + j;
            }
        }

        return (sum * 4) - 2*n;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        int k = SumOf(n);
        System.out.println(k);

    }
}
