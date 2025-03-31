package DFS_BFS_Basic;

import java.util.Scanner;

//피보나키 수열을 출력하라 입력은 피보나치 수열의 총 항의 수
public class Ex_07_04 { //피보나치 재귀(메모이제이션)
    static int[] fibo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n + 1];
        recursion(n);
        for (int i = 1; i <= n; i++) {
            System.out.println(fibo[i]);
        }
    }

    public static int recursion(int n) {
        if( n == 1) return fibo[n]=1;
        else if( n == 2) return fibo[n]=1;
        else return fibo[n] = recursion(n - 2) + recursion( n - 1);
    }

}

/*
    배열에 저장하면서 리턴하면 더 빠른 성능을 보인다.
    중복계산을 피할수있다

    메모이제이션이란 동일한 계산을 반복하지 않도록 계산된 값을 저장해두는 최적화 기법이다.
 */