package Array;

import java.util.Scanner;

public class Ex_02_06 { //뒤집은 소수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String next = sc.next();
            int nextInt = Integer.parseInt(new StringBuilder(next).reverse().toString());

            if (isPrime(nextInt)) System.out.print(nextInt + " ");
        }


    }

    public static boolean isPrime(int n) {
        if(n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

/*
숫자를 계산으로 뒤집는 방법
int res = 0;
while(tmp > 0) {
    int t = tmp % 10;
    res = res * 10 + t;
    tmp =tmp/10;
}
 */