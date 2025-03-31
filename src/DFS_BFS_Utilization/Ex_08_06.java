package DFS_BFS_Utilization;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_08_06 { //순열 구하기
    static int n, m = 0;
    static int[] pm;
    static int[] ch;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        pm = new int[m];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0, arr);
    }

    public static void DFS(int L, int[] arr) {
        if (L == m) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1, arr);
                    ch[i] = 0;

                }
            }
        }
    }
}

/*
    체크 배열로 중복 체크함
 */