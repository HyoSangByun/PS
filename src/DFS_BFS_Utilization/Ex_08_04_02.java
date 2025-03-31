package DFS_BFS_Utilization;

import java.util.Scanner;

public class Ex_08_04_02 { //중복순열 구하기 !모름
    static int[] pm;
    static int n, m, total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        DFS(0);
    }

    public static void DFS(int L) {
        if (L == m) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();

        }
        else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L+1);
            }
        }
    }

}
/*
    각 원소를 부분집합에 넣는다 안넣는다로 나눔
 */