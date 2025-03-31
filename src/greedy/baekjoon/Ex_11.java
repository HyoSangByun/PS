package greedy.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex_11 { // 백준 11000
    static class Study implements Comparable<Study> {
        private int time;
        private char type;

        public Study(int time, char type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Study o) {
            if (this.time == o.time) return this.type - o.type;
            else return this.time - o.time;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Study> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Study(s, 's'));
            list.add(new Study(e, 'e'));
        }

        Collections.sort(list);

        int count = 0;
        int answer = 0;
        for (Study study : list) {
            if (study.type == 'e') {
                count--;
                answer = Math.max(answer, count);
            }
            else {
                count++;
                answer = Math.max(answer, count);
            }
        }

        System.out.println(answer);
    }
}
