package DFS_BFS_Utilization.Baekjoon.DFS;


import java.util.*;

public class Ex_17471 {
    static int N;
    static int res = Integer.MAX_VALUE;
    static int[] people;
    static boolean[] selected;
    static boolean[] visited;
    static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        people = new int[N + 1];
        selected = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            people[i] = sc.nextInt();
        }

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            int j = sc.nextInt();
            for (int k = 0; k < j; k++) {
                lists.get(i).add(sc.nextInt());
            }
        }

        divied(1);
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);

    }

    private static void divied(int city) {
        if (city == N) {
            ArrayList<Integer> aList = new ArrayList<>();
            ArrayList<Integer> bList = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if (selected[i]) aList.add(i);
                else bList.add(i);
            }

            if (aList.isEmpty() || bList.isEmpty()) return;

            if (check(aList) && check(bList)) { // 두 구역이 각각 연결되었는지 확인
                getPeopleDiff(); // 인구차 구하기
            }
            return;
        }

        selected[city] = true;
        divied(city + 1);
        selected[city] = false;
        divied(city + 1);
    }

    private static boolean check(ArrayList<Integer> list) {
        Queue<Integer> Q = new LinkedList<>();
        visited = new boolean[N + 1];
        visited[list.getFirst()] = true;
        Q.offer(list.getFirst());

        int count = 1;
        while (!Q.isEmpty()) {
            Integer cur = Q.poll();
            for (int i = 0; i < lists.get(cur).size(); i++) {
                int y = lists.get(cur).get(i);
                if (list.contains(y) && !visited[y]) {
                    Q.offer(y);
                    visited[y] = true;
                    count++;
                }
            }
        }
        if(count==list.size()) // 선거구에 해당하는 지역수와 방문한 지역수가 같은 경우
            return true;
        else
            return false;
    }

    private static void getPeopleDiff() {
        int pA = 0, pB = 0;
        for (int i = 1; i <= N; i++) {
            if (selected[i])
                pA += people[i];
            else
                pB += people[i];
        }
        int diff = Math.abs(pA - pB);
        res = Math.min(res, diff);
    }
}

/*
    각 구역을 칠하고 안칠하고 두 가지 경우로 나누고
    각 경우마다 조건을 만족하는지 확인후에 만족하면
    인구 차이를 구함.
 */