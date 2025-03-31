package DFS_BFS_Utilization;

import java.util.Scanner;

public class Ex_08_09 { //조합구하기

    static int n, m;
    static int[] ch, pm;

    public static void DFS(int L, int start){
        if (L == m) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else {
            for (int i = start; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        ch = new int[n + 1];
        pm = new int[m];

        DFS(0, 1);


    }

}
