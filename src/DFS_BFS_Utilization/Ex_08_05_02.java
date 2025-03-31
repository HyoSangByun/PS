package DFS_BFS_Utilization;

import java.util.Scanner;

public class Ex_08_05_02 { //동전교환 (DFS)
    static int answer=Integer.MAX_VALUE, M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
//        Arrays.sort(arr);
        M = sc.nextInt();
        DFS(0 ,0, arr);
//        System.out.println(M);
        System.out.println(answer);
    }

    public static void DFS(int L, int sum,  int[] arr) {
        if( sum > M ) return;
        if (L >= answer) return;
        if (sum == M) {
            answer = Math.min(answer, L); // 동전 개수의 최소값 갱신
        }
        else {
            for (int i = N - 1; i >= 0 ; i--) { // 큰 단위 동전부터 사용
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }
}
/*
    answer보다 더 커지는 레벨로는 들어갈 필요가 없음 그래서 timelimit을 초과하는 것임
    그리고 큰 단위의 동전부터 사용해서 최적화함
 */