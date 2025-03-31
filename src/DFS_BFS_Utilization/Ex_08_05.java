package DFS_BFS_Utilization;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_08_05 { //동전교환 !틀림
    static int answer=Integer.MAX_VALUE, M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        M = sc.nextInt();
        DFS(0 ,0, arr);
        System.out.println(M);
        System.out.println(answer);
    }

    public static void DFS(int count, int sum,  int[] arr) {
        if (sum > M) return;  // 합이 M을 넘으면 종료
        if (sum == M) {
            answer = Math.min(answer, count); // 동전 개수의 최소값 갱신
        } else {
            for (int i = N - 1; i >= 0; i--) { // 큰 단위 동전부터 사용
                DFS(count + 1, sum + arr[i], arr);
            }
        }
    }
}
/*
if(sum > M) return;
        if (L == N) answer = Math.min(answer, L);
        else {
            for (int i = N - 1; i >= 0; i--) {
                //                System.out.println(i1);
                if (sum + arr[i] > M) break;
                else DFS(L+1, sum + arr[i],  arr);
            }
            DFS(L+1, sum, arr);
        }
 */