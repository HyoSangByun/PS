package DFS_BFS_Utilization;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_08_07 { //조합의 경우수(메모이제이션)
    static int[][] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        ch = new int[n + 1][r + 1];

        System.out.println(DFS(n, r));
    }

    public static int DFS(int n, int r) {
        if (r == n || r == 0) return 1;
        if (ch[n][r] > 0) return ch[n][r];
        else {
            ch[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
            return ch[n][r];
        }
    }
}

