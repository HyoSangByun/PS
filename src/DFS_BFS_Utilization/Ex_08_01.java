package DFS_BFS_Utilization;

import java.util.Scanner;

public class Ex_08_01 { //합이 같은 부분집합(DFS : 아마존 인터뷰) !강의봄
    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        DFS(0, 0, arr);
        System.out.println(answer);
    }

    public static void DFS(int L, int sum, int[] arr) {
        if (flag) return;
        if (sum > total/2) return;
        if (L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L+1, sum + arr[L], arr); //원소 사용함
            DFS(L+1, sum , arr); // 원소 사용 X
        }
    }
}

/*
    각 원소를 부분집합에 넣는다 안넣는다로 나눔
 */