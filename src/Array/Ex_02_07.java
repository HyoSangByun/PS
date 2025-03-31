package Array;

import java.util.Scanner;

public class Ex_02_07 { //점수 계산
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int k = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
           if ( sc.nextInt() == 0) k=0;
           else sum += ++k;
        }

        System.out.println(sum);
    }
}
