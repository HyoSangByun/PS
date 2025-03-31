package greedy.baekjoon;

import java.util.*;

public class Ex_07 { //백준 2217
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            list.add(nextInt);
        }

        Collections.sort(list, Comparator.reverseOrder());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, list.get(i) * (i + 1));
        }

        System.out.println(answer);
    }
}
