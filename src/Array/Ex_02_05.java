package Array;

import java.util.Scanner;

public class Ex_02_05 { //에라토스테네스 체 (소수)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;

        for (int i = 0; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        System.out.println(count);

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
에라스토테네스체가 제곱근 방법보다 빠르다

에라스토테네스체 방식이란?
1. 처음에 배열을 모두 0으로 초기화
2. for문을 돌면서 0이라면 카운팅해주고 그 수의 배수들을 모두 1로 바꿈
3. 위 과정 반복
 */