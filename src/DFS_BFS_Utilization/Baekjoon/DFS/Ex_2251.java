package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Map;
import java.util.Scanner;

public class Ex_2251 {
    static int A, B, C;
    static boolean[] possible;
    static boolean[][][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        visited = new boolean[201][201][201];
        possible = new boolean[201];

        DFS(0, 0, C); // 첫 번째, 두 번째 물통이 비어 있고, 세 번째 물통은 가득 찬 상태에서 시작

        for (int i = 0; i <= 200; i++) {
            if (possible[i]) {
                System.out.print(i + " "); // 가능한 세 번째 물통의 물 양 출력
            }
        }

    }

    static void DFS(int Abottle, int Bbottle, int Cbottle) {
        // 이미 방문한 상태라면 리턴
        if (visited[Abottle][Bbottle][Cbottle]) {
            return;
        }

        // 방문 처리
        visited[Abottle][Bbottle][Cbottle] = true;

        // 첫 번째 물통이 비어 있을 때 세 번째 물통의 물 양 저장
        if (Abottle == 0) {
            possible[Cbottle] = true;
        }

        // A -> B
        if (Abottle > 0 && Bbottle < B) {
            int movingWater = Math.min(Abottle, B - Bbottle);
            DFS(Abottle - movingWater, Bbottle + movingWater, Cbottle);
        }

        // A -> C
        if (Abottle > 0 && Cbottle < C) {
            int movingWater = Math.min(Abottle, C - Cbottle);
            DFS(Abottle - movingWater, Bbottle, Cbottle + movingWater);
        }

        // B -> A
        if (Bbottle > 0 && Abottle < A) {
            int movingWater = Math.min(Bbottle, A - Abottle);
            DFS(Abottle + movingWater, Bbottle - movingWater, Cbottle);
        }

        // B -> C
        if (Bbottle > 0 && Cbottle < C) {
            int movingWater = Math.min(Bbottle, C - Cbottle);
            DFS(Abottle, Bbottle - movingWater, Cbottle + movingWater);
        }

        // C -> A
        if (Cbottle > 0 && Abottle < A) {
            int movingWater = Math.min(Cbottle, A - Abottle);
            DFS(Abottle + movingWater, Bbottle, Cbottle - movingWater);
        }

        // C -> B
        if (Cbottle > 0 && Bbottle < B) {
            int movingWater = Math.min(Cbottle, B - Bbottle);
            DFS(Abottle, Bbottle + movingWater, Cbottle - movingWater);
        }
    }

}
