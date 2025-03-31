package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex_2668 {
    private static int N;
    static int[] arr;
    static List<Integer> answerList = new ArrayList<>(); // 초기화 추가
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i,i);
            visited[i] = false;
        }

        Collections.sort(answerList); // 리스트를 오름차순으로 정렬
        System.out.println(answerList.size());
        for(int i=0; i<answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }

    static void DFS(int start, int target) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            DFS(arr[start], target );
            visited[arr[start]] = false;
        }

        if (arr[start] == target) {
            answerList.add(target);
        }
    }

}
